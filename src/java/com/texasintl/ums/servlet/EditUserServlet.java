/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.texasintl.ums.servlet;

import com.texasintl.ums.db.DatabaseConnection;
import com.texasintl.ums.db.UserDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Yubaraj
 */
public class EditUserServlet extends HttpServlet {

    

   
    /**
     * Handles the HTTP <code>GET</code> method. This method fetch the 
     * user data from database associated with given userId.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        Connection cn = DatabaseConnection.getConnection();
        try {
            Statement stat = cn.createStatement();
            String sql = "select * from user where id ="+userId;
            // select * from user where id=1
           ResultSet rs = stat.executeQuery(sql);
           if(rs.next()){
               UserDto userDto = new UserDto();
               userDto.setId(rs.getInt("id"));
               userDto.setFirstName(rs.getString("first_name"));
               userDto.setLastName(rs.getString("last_name"));
               userDto.setUsername(rs.getString("username"));
               
               request.setAttribute("userDto", userDto);
               RequestDispatcher rd = request.getRequestDispatcher("./editUser.jsp");
               rd.forward(request, response);
           }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method. This method updates 
     * the user info.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("un");
        String firstName = request.getParameter("fn");
        String lastName = request.getParameter("ln");
        int id = Integer.parseInt(request.getParameter("userId"));
        PrintWriter out = response.getWriter();
        out.println("Username: "+username);
        
        
        Connection cn = DatabaseConnection.getConnection();
        //update user set first_name='value', last_name = 'value', username='value'
        // where id = value;
        String sql ="update user set first_name = '"+firstName+"', last_name='"+lastName+"',"
                + " username = '"+username+"' where id="+id;
        System.out.println("SQL: "+sql);
        try {
            Statement stat = cn.createStatement();
            stat.executeUpdate(sql);
            out.print("updated");
            response.sendRedirect("./UserListServlet");
        } catch (SQLException ex) {
            ex.printStackTrace();
            //pass exception message to error.jsp page
             response.sendRedirect("./error.jsp");
        }
    }

    
}
