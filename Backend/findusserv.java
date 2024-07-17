/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lourd
 */
public class findusserv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String name=request.getParameter("uname");
       String email=request.getParameter("email");
       String cont=request.getParameter("contact");
       String text=request.getParameter("message");
        try{
           
       Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","admin@123");
        PreparedStatement ps =con.prepareStatement("insert into findusserv(name,email,cont,text) values(?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,cont);
        ps.setString(4,text);
       
        
        ps.executeUpdate();
       RequestDispatcher rd=request.getRequestDispatcher("findus.html");
            rd.include(request, response);
        out.println("<center><h1>inserted</h1></center>"); 
            
          
    }

       
catch(Exception e){
out.println(e);

}
    }
    }
