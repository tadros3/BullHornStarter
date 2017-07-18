

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbPosts;
import customTools.DbUser;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String motto = request.getParameter("motto");
		String action = request.getParameter("action");
		String nextPage = "/error.jsp";//someplace to go if things don't work
		String message = "";
		HttpSession session = request.getSession();
		
		//did they click the logout link?
		//first... check that the action variable contains something
		//then the code below will determine if they clicked logout and kill the session
		//before sending the user back to the login page
		
		if(!action.isEmpty()||!(action==null)){
		    if (request.getParameter("action").toString().equals("logout")){
		        //Go back to login.jsp. 
		        nextPage = "/login.jsp";
		        response.sendRedirect(request.getContextPath() + nextPage);
		        return;//return here exits the method and prevents an error
		    }else{
		        nextPage = "/home.jsp";
		    }
		}
		
	
		//putting a blank message just ensures I have a blank message.Since the message is set in the session
		//it could still exist as the user navigates between pages so at the top of each page I should endure
		//the message attribute contains nothing. Alternatively, I could just remove it if it exists.
		session.setAttribute("message",message);

		model.Bhuser newUser = new model.Bhuser();
		newUser.setJoindate(new Date());
		newUser.setMotto(motto);
		newUser.setUseremail(email);
		newUser.setUsername(username);
		newUser.setUserpassword(password);
		
		DbUser.insert(newUser);
		//Existential question: Does the user exist? Are they really who they say they are???
		//And while you're at it... what is the meaning of life?
		message = "Welcome to Bullhorn!";
		session.setAttribute("message", message);
		session.setAttribute("user", DbUser.getUserByEmail(email));

		//Your work here is done. Redirect to next page as indicated by the value of the nextURL variable
		response.sendRedirect(request.getContextPath() + nextPage);
	
	}

}
