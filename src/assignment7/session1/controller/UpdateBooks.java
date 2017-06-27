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
 * Servlet implementation class UpdateBooks
 */
@WebServlet("/UpdateBooks")
public class UpdateBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String authors = request.getParameter("authors");
		String publisher = request.getParameter("publisher");
		String year = request.getParameter("year");
		int price = Integer.parseInt(request.getParameter("price"));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		BooksDao dao = new BooksDao();
		
		String result = dao.updateBooks(title,authors,publisher,year,price);
		
		if(result.equals("success")){
			out.println("Book details updated successfully!!!!");
		}
		else if(result.equals("error")){
			out.println("Error while updating details!!!");
		}
	}

}
