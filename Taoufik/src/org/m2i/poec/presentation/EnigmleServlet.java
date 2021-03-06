package org.m2i.poec.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.m2i.poec.service.EnigmeManager;



/**
 * Servlet implementation class EnigmleServlet
 */
@WebServlet("/formulaire")
public class EnigmleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    public EnigmleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession	session = request.getSession();
		session.setAttribute("enigme", EnigmeManager.mapEnigme.get("enigme1"));
		request.getRequestDispatcher("jsp/formulaire.jsp").forward(request, response);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String repose= request.getParameter("treponse");
		
		doGet(request, response);
	}

}
