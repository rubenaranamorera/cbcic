package cat.cbcic.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

		HttpSession session = request.getSession();

        if (session == null || session.getAttribute("cbcic_user")== null) {
			response.sendRedirect("/login");
        }
		return "admin";
	}

}