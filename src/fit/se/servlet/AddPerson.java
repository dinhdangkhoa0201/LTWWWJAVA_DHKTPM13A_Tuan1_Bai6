package fit.se.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.beans.Person;
import fit.se.dao.PersonDAO;

/**
 * Servlet implementation class AddPerson
 */
public class AddPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonDAO personDAO = new PersonDAO();
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String message = "";
		if(!name.equalsIgnoreCase("") && !country.equalsIgnoreCase("")) {
			if(personDAO.addPerson(new Person(name, country)) == true){
				message = "Add Person Successfully";
			} else {
				message = "Add Person Fail";
			}
			
		} else if(name.equalsIgnoreCase("") || country.equalsIgnoreCase("")) {
			message = "Bạn phải nhập dữ liệu của cả 2 ô Name và Country";
		}
		request.getSession().setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
