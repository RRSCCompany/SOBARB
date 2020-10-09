/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import DAOs.DAOAtor;
import Entidades.Ator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juuli
 */
@WebServlet(name = "AtorServlet", urlPatterns = {"/AtorServlet"})
public class AtorServlet extends HttpServlet {

    private RequestDispatcher rd = null;
    private DAOAtor dao = new DAOAtor();
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
  
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        try{
            String strid = request.getParameter("id");
            int id = Integer.parseInt(strid);
            Ator ator = dao.obter(id);
            request.setAttribute("ator", ator);
            rd = request.getRequestDispatcher("/ator.jsp");
        }catch(Exception ex){
            request.setAttribute("msg", "O ator não foi encontrado no banco de dados!");
            rd = request.getRequestDispatcher("/erro.jsp");
        }finally{
            rd.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
