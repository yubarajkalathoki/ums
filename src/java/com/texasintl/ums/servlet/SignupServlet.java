/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.texasintl.ums.servlet;

import com.texasintl.ums.db.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yubaraj
 */
public class SignupServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        String username = request.getParameter("un");
        String password = request.getParameter("pw");
        String firstName = request.getParameter("fn");
        String lastName = request.getParameter("ln");
        PrintWriter out = response.getWriter();
        out.println("Username: "+username);
        out.println("Password :"+password);
        
        
        Connection cn = DatabaseConnection.getConnection();
        String sql = "insert into user (username, password, first_name, "
                + "last_name) values ('"+username+"', '"+password+"', "
                + ""+firstName+"', '"+lastName+"')";
        System.out.println("SQL: "+sql);
        try {
            Statement stat = cn.createStatement();
            stat.executeUpdate(sql);
            out.print("inserted");
            response.sendRedirect("./login.jsp");
        } catch (SQLException ex) {
            ex.printStackTrace();
            //pass exception message to error.jsp page
             response.sendRedirect("./error.jsp");
        }

// if signup is success then send to login.jsp page

    //response.sendRedirect("login.jsp");

//    else

    }
}
