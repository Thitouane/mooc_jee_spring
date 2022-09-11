import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

	// TODO : only handle POST request for authentication
	@Override
	protected void doPOST(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		// TODO : get login / password from request parameters
		String login = req.getParameter("login");
		String password = req.getParameter("password");
	
		HttpSession session = req.getSession();

		// TODO : if auth is OK, 
		if (login != null && password != null) {
			// add something in session for next calls,
			session.setAttribute("auth", login);
	 
		  	// then redirect to "welcome.jsp"
			resp.sendRedirect("/exo102/welcome.jsp");

		// TODO : if auth KO
		} else {
			// set an "errorMessage" in request attribute
			session.setAttribute("auth", "error");
			req.setAttribute("errorMessage", "Login or Password incorrect");
		  	// forward to auth.jsp with request dispatcher
			req.getRequestDispatcher("/auth.jsp").forward(req, resp);
		}

	}
	
	// TODO : allow to disconnect with a GET to /auth with any parameter "logout" value
	@Override
	protected void doGET(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
	  // TODO : check for "logout" parameter
	  String logout =  req.getParameter("logout");
	  HttpSession session = req.getSession();
	  //   if so : disconnect and show auth.jsp
	  if (logout != null) {
		session.removeAttribute("auth");
		req.getRequestDispatcher("/auth.jsp").forward(req, resp);
	  //   if not : Error 500
	  } else {
		throw new ServletException("logout is null");
	  }
	}

}