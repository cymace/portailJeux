package fr.m2i.poec.toureauvache.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccueilServlet
 */
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int r = new Random().nextInt(9000) + 1000;
	private Map<String, String> nombres = new HashMap<String, String>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(r);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("envoyer") != null) {
			String proposition = request.getParameter("proposition");
			String rep = "";
			for (int i = 0; i < 4; i++) {
					if (Integer.toString(r).indexOf(proposition.substring(i, i + 1))>-1) {
						if (Integer.toString(r).indexOf(proposition.substring(i, i + 1)) == i)
							rep += "T";
						else
							rep += "V";
					}
			}
			nombres.put(proposition, rep);
			request.setAttribute("nombres", nombres);
		}
		if (request.getParameter("recommencer") != null) {

			nombres.clear();
			request.setAttribute("nombres", nombres);
			r = new Random().nextInt(9000) + 1000;
		}
		doGet(request, response);
	}

}
