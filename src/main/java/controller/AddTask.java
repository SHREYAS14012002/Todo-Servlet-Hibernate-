package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

@WebServlet("/add-task")
public class AddTask extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Userdto dto = (Userdto) session.getAttribute("user");
		
		if (dto == null) {

			resp.getWriter().print("<h1>Session expired, Login again</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			
			Task task=new Task();
			task.setName(req.getParameter("taskName"));
			task.setDecription(req.getParameter("taskDescription"));
			task.setCreatedTime(LocalDateTime.now());
			task.setStatus(false);
			
			UserService service = new UserService();
			service.saveTask(task);
			
			List<Task> tasks=dto.getTasks();
			if(tasks==null)
				tasks=new ArrayList<Task>();
			
			tasks.add(task);
			dto.setTasks(tasks);
			
			
			service.updateUser(dto);
			
			Userdao dao  = new Userdao();
			req.getSession().setAttribute("user", dao.findBYEmail(dto.getEmail()));
			
			
			resp.getWriter().print("<h1 style='color:green'>Task Added Successfully</h1>");
			req.setAttribute("list", dto.getTasks());
			req.getRequestDispatcher("Home.jsp").include(req, resp);
		}
		
	}
}
