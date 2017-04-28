

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws	ServletException, IOException {
		
		//I don't want the user to get to the servlet using GET. I could remove this method which 
		//would cause an error. Or I could leave doGet here and redirect them to either an error page
		//or the login page
		//let's redirect them to an error page since I'm not sure how they could get to this point without
		//some kind of error
		
		//the session is created when the user first connects to the site. You can 
		//attach to the session using request.getSession and use the variable you
		//create below to refer to the session. 
		//The session is visible to every page. It works the same way that the windows clipboard 
		//allows you to pass data between open applications.
		HttpSession session = request.getSession();
		
		String message = "Please go to the log in page to use this site.";
		session.setAttribute("message",message);

		String nextPage = "/error.jsp";//someplace to go if things don't work
		//and away we go!
		response.sendRedirect(request.getContextPath() + nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nextPage = "/error.jsp";//someplace to go if things don't work
		String message = "";
		HttpSession session = request.getSession();
		//putting a blank message just ensures I have a blank message.Since the message is set in the session
		//it could still exist as the user navigates between pages so at the top of each page I should endure
		//the message attribute contains nothing. Alternatively, I could just remove it if it exists.
		session.setAttribute("message",message);
		
		//Existential question: Does the user exist? Are they really who they say they are???
		//And while you're at it... what is the meaning of life?
		if (DbUser.isValidUser(email,password)){
			//add the valid user to the session
			session.setAttribute("user", DbUser.getUserByEmail(email));
			nextPage = "/home.jsp";
		}else{
			//probably not necessary but you can clear all session variables just to be sure nobody can access them 
			session.invalidate();
			//they put in the wrong password or don't exist in the database
			nextPage = "/login.jsp";
		}
		
		//Your work here is done. Redirect to next page as indicated by the value of the nextURL variable
		response.sendRedirect(request.getContextPath() + nextPage);
	}

}
