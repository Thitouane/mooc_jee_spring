package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/bag")
public class BagServlet extends HttpServlet{
	
	public static String jspView = "WEB-INF/bag.jsp";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession(true);

		Bag bag = (Bag) session.getAttribute("bag");
		req.setAttribute("bag", bag);
		if(bag != null) bag.print(out);

		res.setContentType("text/html");
		req.getRequestDispatcher(jspView).forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession(true);

		String ref = (String) req.getParameter("ref");
		String qty = (String) req.getParameter("qty");

		if (ref != null && qty != null && ref != "" && qty != "") {
			Bag bag = (Bag) session.getAttribute("bag");
			if (bag == null) bag = new Bag();
			bag.setItem(ref, Integer.parseInt(qty));
			
			session.setAttribute("bag", bag);

			res.sendRedirect("/exo103/bag");
		} else {
			res.setStatus(400);
		}

	}
	
}