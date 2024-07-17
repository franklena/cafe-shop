/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lourd
 */
public class signupserv extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username=request.getParameter("newuname");
        String password=request.getParameter("newpwd");
        String contact=request.getParameter("phoneno");
        String email=request.getParameter("emailid");
        
        try{
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","admin@123");
               PreparedStatement ps =con.prepareStatement("insert into signup(username,password,contact,email) values(?,?,?,?)");
        ps.setString(1,username);
        ps.setString(2,password);
        ps.setString(3,contact);
        ps.setString(4,email);
       
       ps.executeUpdate();
       RequestDispatcher rd=request.getRequestDispatcher("index.html");
            rd.include(request, response);
    }

       
catch(Exception e){
out.println(e);

}
        }
    }
