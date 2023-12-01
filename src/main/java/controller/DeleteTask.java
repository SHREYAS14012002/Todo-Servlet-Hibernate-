package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userdao;
import dto.Userdto;
import service.UserService;

@WebServlet("/delete-task")
public class DeleteTask extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Userdto dto = (Userdto) session.getAttribute("user");
		//Checking Session
		if (dto == null) {

			resp.getWriter().print("<h1>Session expired, Login again</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			//Taking id from url
			int id = Integer.parseInt(req.getParameter("id"));
			
			//Deleting Task
			UserService service = new UserService();
			service.deleteTask(id,dto);
			
			//Update Session
			Userdao dao=new Userdao();
			Userdto dto2=dao.findByID(dto.getId());
			req.getSession().setAttribute("user", dto2);
			
			//sending updated data
			resp.getWriter().print("<h1>Task Deleted</h1>");
			req.setAttribute("list", dto2.getTasks());
			req.getRequestDispatcher("Home.jsp").include(req, resp);
		}
	}
}
