import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dist")
public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		// TODO : show a HTML form with 4 input text (2 for each point)
		//        your input must be named 'p1lat', 'p1lng', 'p2lat', 'p2lng'
		req.getRequestDispatcher("/vue.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		// TODO : get first point latitude / longitude
		Double latA = Double.parseDouble(req.getParameter("p1lat"));
		Double lngA = Double.parseDouble(req.getParameter("p1lng"));

		// TODO : get second point latitude / longitude
		Double latB = Double.parseDouble(req.getParameter("p2lat"));
		Double lngB = Double.parseDouble(req.getParameter("p2lng"));
	
		// TODO : compute distance between two points
		Double r = 6371.0;
		Double phi1 = Math.toRadians(latA);
		Double phi2 = Math.toRadians(latB);

		Double deltaPhi = Math.toRadians(latB - latA);
		Double deltaLambda = Math.toRadians(lngB - lngA);
		
		Double a = Math.sin(deltaPhi/2) * Math.sin(deltaPhi/2) + Math.cos(phi1) * Math.cos(phi2) * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda/2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		Double result = r * c;
		System.out.println(result);

		// TODO : display distance, in kilometer with 1 decimal
		DecimalFormat format = new DecimalFormat("#.#");
		resp.getWriter().write("Distance = " + format.format(result));
	}

}