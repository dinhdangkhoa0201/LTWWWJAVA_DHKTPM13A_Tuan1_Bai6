package fit.se.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.beans.Person;
import fit.se.dao.PersonDAO;

@WebServlet(urlPatterns = {"/DeletePerson"})
public class DeletePerson extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DeletePerson() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonDAO personDAO = new PersonDAO();
		String id = req.getParameter("idPerson");
		String message = "";
		if(!id.equalsIgnoreCase("")) {
			if(personDAO.deletePerson(new Person(id, "", "")) == true) {
				message = "Delete Person Successfully";
			} else {
				message = "Delete Person Fail";
			}
		}
		req.getSession().setAttribute("message", message);
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
}
