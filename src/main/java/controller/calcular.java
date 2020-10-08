/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.operaciones;

/**
 *
 * @author david
 */
public class calcular extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //Se reciben los datos con un request
            String b = request.getParameter("base");
            String h = request.getParameter("altura");
            String a = request.getParameter("autor");
            
            //Se inicializa el objeto de operaciones
            operaciones op = new operaciones(b,h,a);
            
            op.calcArea();
            double resultadoArea = op.getArea();
            op.calcPerim();
            double resultadoPerim = op.getPerim();
            request.setAttribute("resultados",op);
            
           
            //Cookies
            Cookie ck = new Cookie("base",op.getBase()+"");
            response.addCookie(ck);
            ck= new Cookie("altura",op.getAltura()+ "");
            response.addCookie(ck);
            ck= new Cookie("resultadoArea",op.getArea()+"");
            response.addCookie(ck);
            ck= new Cookie("resultadoPerim",op.getPerim()+"");
            response.addCookie(ck);
            
            //Sesiones
            HttpSession sesion = request.getSession(false);
            sesion.setAttribute("autor",op.getAutor());
            
            request.getRequestDispatcher("/resultados.jsp").forward(request, response);
        }
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
