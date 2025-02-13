import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String contact = request.getParameter("contact");
		String accountType = request.getParameter("accountType");
		if (name != null && !name.isEmpty() && dob != null && !dob.isEmpty() && contact != null
				&& contact.matches("\\d{10}") && (accountType.equals("Savings") || accountType.equals("Current"))) {

			response.getWriter().println("<h3>Registration Successful!</h3>");
			response.getWriter().println("<p>Name: " + name + "</p>");
			response.getWriter().println("<p>D.O.B: " + dob + "</p>");
			response.getWriter().println("<p>Contact: " + contact + "</p>");
			response.getWriter().println("<p>Account Type: " + accountType + "</p>");
		} else {
			response.getWriter().println("<h3>Invalid details! Please enter correct information.</h3>");
		}
	}
}
