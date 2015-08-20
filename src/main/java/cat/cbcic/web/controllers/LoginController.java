package cat.cbcic.web.controllers;


import cat.cbcic.web.lao.LAONoticies;
import cat.cbcic.web.models.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String index(Model model, @RequestParam(value="error",required=false, defaultValue = "false"  ) String error) {

        model.addAttribute("error", error);
		return "/login";
	}

	@RequestMapping("/login/login")
	public String login(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(true);

        if (session.getAttribute("cbcic_user")== null) {

            String user = request.getParameter("usuari");
            String password = request.getParameter("password");

            if (user.equals("admin") && password.equals("admin")) {
                session.setAttribute("cbcic_user", user);
                response.sendRedirect("/admin");
            } else {
                response.sendRedirect("/login?error=true");
            }
        }

        return "/admin";
	}


    @RequestMapping("/login/logout")
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        HttpSession session = request.getSession(true);
        session.removeAttribute("cbcic_user");

        response.sendRedirect("/login");

        return "/login";
    }
}