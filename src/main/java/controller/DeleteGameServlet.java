package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoJogo;

/**
 * Servlet implementation class DeleteGameServlet
 */
@WebServlet("/DeleteGame")
public class DeleteGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DaoJogo dao = DaoJogo.getInstance();
       

    public DeleteGameServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
