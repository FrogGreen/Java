//package com.company;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.sql.*;
//import java.io.PrintWriter;
//
///**
// * Servlet implementation class TestDatabaseServlet
// */
//@WebServlet("/TestDatabaseServlet")
//public class TestDatabaseServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String user = "FrogGreen";
//		String password = "FrogGreen";
//		String jdbcUrl = "jdbc:mysql://localhost:3306/froggreendatalist?useSSL=false&serverTimezone=UTC";
//		String driver = "com.mysql.jdbc.Driver";
//
//		try {
//			PrintWriter printWritter = response.getWriter();
//			printWritter.println("Connecting to database" + jdbcUrl);
//			Class.forName(driver);
//			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
//			printWritter.println("Successfull");
//			printWritter.close();
//			connection.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new ServletException(e);
//		}
//	}
//}