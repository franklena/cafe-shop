/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lourd
 */
public class coffserv extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       //String name=request.getParameter("name");
       String contact=request.getParameter("contact");
       String address=request.getParameter("address");
       String tot=request.getParameter("amount");
       int amount=Integer.parseInt(tot);
       HttpSession session=request.getSession();
       String name=(String)session.getAttribute("name");
       
       try{
           Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","admin@123");
        Statement s=con.createStatement();
        PreparedStatement ps =con.prepareStatement("insert into coffeeserv(name,contact,address,amount) values(?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,contact);
        ps.setString(3,address);
        ps.setInt(4,amount);
        ps.executeUpdate();
         RequestDispatcher rd=request.getRequestDispatcher("coffee.html");
            rd.include(request, response);
        out.println("<center><h1>inserted</h1></center>"); 
       }
       catch(Exception e){
           out.println("error");
       }
    }

}
