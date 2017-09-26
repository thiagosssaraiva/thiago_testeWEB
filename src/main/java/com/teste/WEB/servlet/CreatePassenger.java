/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.WEB.servlet;

import com.teste.WEB.dao.DriverDao;
import com.teste.WEB.dao.PassengerDAO;
import com.teste.WEB.entities.Driver;
import com.teste.WEB.entities.Passenger;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago
 */
@WebServlet(name = "CreatePassenger", urlPatterns = {"/CreatePassenger"})
public class CreatePassenger extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateContact</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateContact at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

        }
    }
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Passenger passenger = new Passenger();
        
        passenger.setNome(request.getParameter("nome"));
        passenger.setData_nascimento(request.getParameter("dt_nasc"));
        passenger.setCPF(request.getParameter("telefone"));
        passenger.setSexo(request.getParameter("sexo"));
        String status = request.getParameter("isActive");
        if(status == "0"){
            passenger.setStatus(false);
        }else{
            passenger.setStatus(true);
        }

        
        PassengerDAO dao = new PassengerDAO();
        try {
            dao.Add(passenger);
        } catch (SQLException ex) {
            Logger.getLogger(com.teste.WEB.servlet.CreateDriver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(com.teste.WEB.servlet.CreateDriver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(com.teste.WEB.servlet.CreateDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Driver> lista = new ArrayList<Driver>();
        try {
            lista = dao.listAll();
        } catch (Exception ex) {
            Logger.getLogger(com.teste.WEB.servlet.CreateDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("lista", lista);
        
            // Encaminhamento para o processamento continuar no jsp.
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("listaPassenger.jsp");
            dispatcher.forward(request,response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
