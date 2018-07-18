package fr.formation.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.service.AnalyseResultat;

/**
 * Servlet implementation class ChevalBlancServlet
 */
@WebServlet("/chevalBlanc")
public class ChevalBlancServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String reponse = request.getParameter("couleur");

		String resultat = AnalyseResultat.verifierResultat(reponse);

		request.setAttribute("resultat", resultat);

		request.getRequestDispatcher("result.jsp").forward(request, response);

	}

}