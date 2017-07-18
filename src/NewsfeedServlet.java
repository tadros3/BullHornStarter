

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbPosts;

/**
 * Servlet implementation class NewsfeedServlet
 */
@WebServlet("/NewsfeedServlet")
public class NewsfeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsfeedServlet() {
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
		long filterByUserID = 0; 
		String searchtext = "";
		
		String nextURL = "/error.jsp";
		//get user out of session. If they don't exist then send them back to the login page.
		//kill the session while you're at it.
		HttpSession session = request.getSession();
		if (session.getAttribute("user")==null){
			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
			nextURL = "/login.jsp";
			session.invalidate();
			response.sendRedirect(request.getContextPath() + nextURL);
		    return;//return prevents an error
		}
		
		//get posts based on parameters; if no parameters then get all posts
		List<model.Bhpost> posts = null;
//		if (!request.getParameter("userid").equals("")){
//			filterByUserID = Integer.parseInt(request.getParameter("userid"));
//			posts = DbPosts.postsofUser(filterByUserID);
//		}else if (request.getParameter("searchtext")!=null){
//			searchtext = request.getParameter("searchtext").toString();
//			posts = DbPosts.searchPosts(searchtext);
//		}else{
//			posts = DbPosts.bhPost();
//		}
		if (!request.getParameter("searchtext").equals("")) {
			try {
				filterByUserID = Integer.parseInt(request.getParameter("searchtext"));
				posts = DbPosts.postsofUser(filterByUserID);
			} catch (NumberFormatException e) {
				searchtext = request.getParameter("searchtext");
				posts = DbPosts.searchPosts(searchtext);
			}
		} else {
			posts = DbPosts.bhPost();
		}
		
		
		//add posts to session
		session.setAttribute("filteredPosts", posts);
		//display posts in newsfeed.jsp
		nextURL = "/newsfeed.jsp";
		//redirect to next page as indicated by the value of the nextURL variable
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
	}

}
