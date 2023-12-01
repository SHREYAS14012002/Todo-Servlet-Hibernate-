package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userdao;
import dto.Task;
import dto.Userdto;
import service.UserService;

@WebServlet("/change-status")
public class ChangeStatus extends HttpServlet {
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
			
			//Changing status
			UserService service = new UserService();
			service.changeStatus(id);
			
			//Update Session
			Userdao dao=new Userdao();
			Userdto dto2=dao.findByID(dto.getId());
			req.getSession().setAttribute("user", dto2);
			
			//sending updated data
			resp.getWriter().print("<h1>Task Completed</h1>");
			req.setAttribute("list", dto2.getTasks());
			req.getRequestDispatcher("Home.jsp").include(req, resp);
			
		}
	}
}
