package assignment7.session1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment7.session1.dao.BooksDao;

/**
 * Servlet implementation class DeleteBooks
 */
@WebServlet("/DeleteBooks")
public class DeleteBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		BooksDao dao = new BooksDao();
		
		String result = dao.deleteBooks(title);
		
		if(result.equals("success")){
			out.println("Book details deleted successfully!!!!");
		}
		else if(result.equals("error")){
			out.println("Error while deleting details!!!");
		}
	}

}
