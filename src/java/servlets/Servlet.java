/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edmayen
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            //creamos las variables para procesar el titulo y
            //el mensaje de nuestra pagina web
            String titulo = null, mensaje = null;
            //detectamos el tipo de navegador que hizo la petición
            String tipoNavegador = request.getHeader("User-Agent");
            System.out.println("Tipo de navegador: " + tipoNavegador);
            //verificamos el tipo de navegador y personalizamos
            //el mensaje a enviar
            if (tipoNavegador != null && tipoNavegador.contains("Trident"))
            {
                titulo = "Navegador Internet Explorer";
                mensaje = "Estas navengando con IE";
            }
            else
                if (tipoNavegador != null && tipoNavegador.contains("Firefox"))
                {
                     titulo = "Navegador Firefox";
                     mensaje = "Estas navegando con firefox";
                }
            else
                if (tipoNavegador != null && tipoNavegador.contains("Chrome"))
                {
                     titulo = "Navegador Chrome";
                     mensaje = "Estas navegando con chrome";
                }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + titulo + "</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tipo de Navegador</h1>");
            out.println("<br>");
            out.println(mensaje);
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
