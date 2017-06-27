package assignment7.session1.dao;

import java.sql.*;

import assignment7.session1.factories.ConnectionFactory;

public class BooksDao {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public String insertBooks(String title,String author,String publisher,String year,int price){
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement("insert into books(title,authors,publisher,publication_year,price) values(?,?,?,?,?)");
		    pst.setString(1,title);
		    pst.setString(2,author);
		    pst.setString(3,publisher);
		    pst.setString(4,year);
		    pst.setInt(5,price);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error while inserting into books");
			e.printStackTrace();
			return "error";
		} finally{
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error while closing the connection");
				e.printStackTrace();
			}
		}
		return "success";
	}
	
	public String updateBooks(String title,String author,String publisher,String year,int price){
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement("update books set authors = ?,publisher = ?,publication_year = ?,price = ? where title = ?");
		    pst.setString(1,author);
		    pst.setString(2,publisher);
		    pst.setString(3,year);
		    pst.setInt(4,price);
		    pst.setString(5,title);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error while updating books");
			e.printStackTrace();
			return "error";
		} finally{
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error while closing the connection");
				e.printStackTrace();
			}
		}
		return "success";
		
	}
	
	public String deleteBooks(String title){
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement("delete from books where title = ?");
		    pst.setString(1,title);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error while deleting books");
			e.printStackTrace();
			return "error";
		} finally{
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error while closing the connection");
				e.printStackTrace();
			}
		}
		return "success";
		
	}

}
