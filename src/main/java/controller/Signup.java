package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dto.Userdto;
import service.UserService;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		int age=Period.between(dob, LocalDate.now()).getYears();
		
		Userdto dto = new Userdto();
		dto.setName(req.getParameter("name"));
		dto.setEmail(req.getParameter("email"));
		dto.setPassword(req.getParameter("password"));
		dto.setMobile(Long.parseLong(req.getParameter("mobile")));
		dto.setGender(req.getParameter("gender"));
		dto.setDob(dob);
		dto.setAge(age);
		
		UserService service = new UserService();
		if (service.saveUser(dto)==1) {
			resp.getWriter().print("<h1 style='color:green;'>Account Created</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}else if(service.saveUser(dto)==0){
			resp.getWriter().print("<h1 style='color:red; font-size: 20px; margin-top: 20px;'>User age should be above 18</h1>");
			req.getRequestDispatcher("Signup.html").include(req, resp);
		}else if(service.saveUser(dto)==2){
			resp.getWriter().print("<h1 style='color:red; font-size: 20px; margin-top: 20px;'>Email already exists</h1>");
			req.getRequestDispatcher("Signup.html").include(req, resp);
		}
		
	}
}
