/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package home.controller;

import java.io.IOException;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import system.core.AppCore;
import system.entity.News;

/**
 *
 * @author Loyd
 */
@WebServlet(name = "RemoveNews", urlPatterns = {"/removeNews"})
public class RemoveNews extends HttpServlet
{
    @PersistenceUnit(unitName="AMSPU")
    private EntityManagerFactory emf;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (!AppCore.initPage(request, response))
            return ;

        EntityManager em = emf.createEntityManager();

        String newsId = request.getParameter("news_id");
        int id = Integer.parseInt(newsId);

        UserTransaction transaction;
        try
        {
            transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();

            News news = (News) em.createNamedQuery("News.findById").setParameter("id", id).getSingleResult();
            em.remove(news);

            transaction.commit();
        }
        catch (Exception ex) { }

        response.sendRedirect("home");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
