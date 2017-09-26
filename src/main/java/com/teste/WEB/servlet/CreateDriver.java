
package com.teste.WEB.servlet;

import com.teste.WEB.dao.DriverDao;
import com.teste.WEB.entities.Driver;
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

@WebServlet(name = "CreateDriver", urlPatterns = {"/CreateDriver"})
public class CreateDriver extends HttpServlet {

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
        Driver driver = new Driver();
        
        driver.setNome(request.getParameter("nome"));
        driver.setData_nascimento(request.getParameter("dt_nasc"));
        driver.setCPF(request.getParameter("cpf"));
        driver.setModelCar(request.getParameter("modelCar"));
        driver.setSexo(request.getParameter("sexo"));
        String status = request.getParameter("isActive");
        if(status == "0"){
            driver.setStatus(false);
        }else{
            driver.setStatus(true);
        }
        
        DriverDao dao = new DriverDao();
        try {
            dao.Add(driver);
        } catch (SQLException ex) {
            Logger.getLogger(CreateDriver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateDriver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CreateDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Driver> lista = new ArrayList<Driver>();
        try {
            lista = dao.listAll();
        } catch (Exception ex) {
            Logger.getLogger(CreateDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("lista", lista);
        
            // Encaminhamento para o processamento continuar no jsp.
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("lista.jsp");
            dispatcher.forward(request,response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
