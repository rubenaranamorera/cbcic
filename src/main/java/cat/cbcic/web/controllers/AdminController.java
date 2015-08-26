package cat.cbcic.web.controllers;


import cat.cbcic.web.lao.LAOLogin;
import cat.cbcic.web.lao.LAONoticies;
import cat.cbcic.web.lao.LAOUtils;
import cat.cbcic.web.models.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {


	@Autowired
	private LAONoticies laoNoticies;

    @Autowired
    private LAOUtils laoUtils;

    @Autowired
    private LAOLogin laoLogin;


    public static final int ERROR_USUARI = 1;
    public static final int SUCCESS_USUARI = 2;
    public static final int ERROR_CREAR_NOTICIA = 3;
    public static final int SUCCESS_CREAR_NOTICIA = 4;
    public static final int ERROR_EDITAR_NOTICIA = 5;
    public static final int SUCCESS_EDITAR_NOTICIA = 6;
    public static final int ERROR_ELIMINAR_NOTICIA = 7;
    public static final int SUCCESS_ELIMINAR_NOTICIA = 8;

	@RequestMapping("/admin")
	public String index(Model model, HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value="error", required = false, defaultValue="false" ) boolean error,
                        @RequestParam(value="success", required = false, defaultValue="false") boolean success,
                        @RequestParam(value="msgType", required = false, defaultValue="-1" ) int msgType
                        ) throws Exception{

        checkLogged(request, response);

        HttpSession session = request.getSession(true);

		String user = (String) session.getAttribute("cbcic_user") ;

        boolean isSuperAdmin = laoLogin.isSuperAdmin(user);
        model.addAttribute("superAdmin", isSuperAdmin);

		List<Noticia> noticies = new ArrayList();

        if (isSuperAdmin){
            noticies = laoNoticies.getAllNoticies();
        }
        else{
            noticies = laoNoticies.getNoticiesByOwner(user);
        }

        for (Noticia n: noticies){
            n.setContingut(n.getContingut());
            n.setTitol(n.getTitol());
            n.setResum(n.getResum());
            n.setKeywords(n.getKeywords());
            n.setOwner(n.getOwner());
        }

		model.addAttribute("noticiesList", noticies);

        if (error){
            insertError(model, msgType);
        }
        else if (success){
            insertSuccess(model, msgType);
        }

		return "admin";
	}

    @RequestMapping("/admin/crear-noticia")
    public String crearNoticia(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        String user = checkLogged(request, response);
        String titol = request.getParameter("titol");
        String resum = request.getParameter("resum");
        String contingut = request.getParameter("contingut");
        String fotoUrl = request.getParameter("fotoUrl");
        String keywords = request.getParameter("keywords");
        String owner = user;
        Boolean portada = Boolean.parseBoolean(request.getParameter("portada"));
        Boolean cronica = Boolean.parseBoolean(request.getParameter("cronica"));

        Noticia noticia = new Noticia();
        noticia.setTitol(titol);
        noticia.setResum(resum);
        noticia.setContingut(contingut);
        noticia.setFotoUrl(fotoUrl);
        noticia.setKeywords(keywords);
        noticia.setPortada(portada);
        noticia.setCronica(cronica);
        noticia.setOwner(owner);

        boolean error = false;
        boolean success= false;
        int msgType = -1;

        if (laoNoticies.crearNoticia(noticia)){
            success = true;
            msgType = SUCCESS_CREAR_NOTICIA;
        }
        else{
            error = true;
            msgType = ERROR_CREAR_NOTICIA;
        }

        response.sendRedirect("/admin?error=" + error + "&success=" + success +"&msgType=" + msgType);

        return "admin";
    }

    @RequestMapping("/admin/editar-noticia")
    public String editarNoticia(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        checkLogged(request, response);

        int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
        String titol = request.getParameter("titol");
        String resum = request.getParameter("resum");
        String contingut = request.getParameter("contingut");
        String fotoUrl = request.getParameter("fotoUrl");
        String keywords = request.getParameter("keywords");
        Boolean portada = Boolean.parseBoolean(request.getParameter("portada"));
        Boolean cronica = Boolean.parseBoolean(request.getParameter("cronica"));
        String owner = request.getParameter("owner");


        Noticia noticia = new Noticia();
        noticia.setIdNoticia(idNoticia);
        noticia.setTitol(titol);
        noticia.setResum(resum);
        noticia.setContingut(contingut);
        noticia.setFotoUrl(fotoUrl);
        noticia.setKeywords(keywords);
        noticia.setPortada(portada);
        noticia.setCronica(cronica);
        noticia.setOwner(owner);

        boolean error = false;
        boolean success = false;
        int msgType = -1;
        if (laoNoticies.updateNoticia(noticia)){
            success = true;
            msgType = SUCCESS_EDITAR_NOTICIA;
        }
        else{
            error = true;
            msgType = ERROR_EDITAR_NOTICIA;
        }

        response.sendRedirect("/admin?error=" + error + "&success=" + success +"&msgType=" + msgType);

        return "admin";
    }

    @RequestMapping("/admin/eliminar-noticia")
    public String eliminarNoticia(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        checkLogged(request, response);

        String idNoticiaStr = request.getParameter("idNoticia");
        boolean error = false;
        boolean success = false;
        int msgType = -1;

        if (idNoticiaStr != null && !idNoticiaStr.equals("")){
            int idNoticia = Integer.parseInt(idNoticiaStr);
            Noticia noticia = new Noticia();
            noticia.setIdNoticia(idNoticia);

            if (laoNoticies.deleteNoticia(noticia)){
                success = true;
                msgType = SUCCESS_ELIMINAR_NOTICIA;
            }
            else{
                error = true;
                msgType = ERROR_ELIMINAR_NOTICIA;
            }

        } else {
            error = true;
            msgType = ERROR_ELIMINAR_NOTICIA;
        }

        response.sendRedirect("/admin?error=" + error + "&success=" + success +"&msgType=" + msgType);

        return "admin";
    }

    @RequestMapping("/admin/crear-usuari")
    public String crearUsuari(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        checkLogged(request, response);

        String user = request.getParameter("usuari");
        String password = request.getParameter("password");
        Boolean superAdmin = Boolean.parseBoolean(request.getParameter("superAdmin"));
        String email =  request.getParameter("email");
        Boolean admin = true;

        boolean error = false;
        boolean success= false;
        int msgType = -1;
        if (laoLogin.createUser(user, password, admin, superAdmin, email)) {
            success = true;
            msgType = SUCCESS_USUARI;
        }
        else {
            error = true;
            msgType = ERROR_USUARI;
        }

        response.sendRedirect("/admin?error=" + error + "&success=" + success +"&msgType=" + msgType);

        return "/admin";
    }


    private String checkLogged(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession(true);
        if (session.getAttribute("cbcic_user") == null) {
            response.sendRedirect("/login");
        }

        return (String)session.getAttribute("cbcic_user");
    }


    private void insertError(Model model, int msgType ){
        model.addAttribute("error", true);
        model.addAttribute("success", false);
        model.addAttribute("missatge", getMessageByType(msgType));
    }

    private void insertSuccess(Model model, int msgType ){
        model.addAttribute("error", false);
        model.addAttribute("success", true);
        model.addAttribute("missatge", getMessageByType(msgType));
    }

    private String getMessageByType(int type){


        switch (type){
            case ERROR_USUARI:
                return "Error al crear un usuari";
            case SUCCESS_USUARI:
                return "Usuari creat correctament";
            case ERROR_CREAR_NOTICIA:
                return "Error al crear la notícia";
            case SUCCESS_CREAR_NOTICIA:
                return "Notícia creada correctament";
            case ERROR_EDITAR_NOTICIA:
                return "Error al editar la notícia";
            case SUCCESS_EDITAR_NOTICIA:
                return "Notícia editada correctament";
            case ERROR_ELIMINAR_NOTICIA:
                return "Error al eliminar la notícia";
            case SUCCESS_ELIMINAR_NOTICIA:
                return "Notícia eliminada correctament";
            default:
                return "No hi ha cap missatge";
        }

    }


}