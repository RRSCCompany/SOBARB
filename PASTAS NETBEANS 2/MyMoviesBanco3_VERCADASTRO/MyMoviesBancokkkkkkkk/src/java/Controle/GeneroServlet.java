/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOGenero;
import Entidades.Genero;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "GeneroServlet", urlPatterns = {"/GeneroServlet"})
public class GeneroServlet extends HttpServlet {

    private RequestDispatcher rd = null;
    private DAOGenero dao = new DAOGenero();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String funcao = request.getParameter("funcao");
        
        if (funcao.equals("listar")) {
            try {
                List<Genero> generos = dao.list();
                if (generos == null || generos.isEmpty()) {
                    request.setAttribute("msg", "Não existem Generos cadastrados no banco.");
                    rd = request.getRequestDispatcher("/erro.jsp");
                } else {
                    request.setAttribute("generos", generos);
                    rd = request.getRequestDispatcher("listGeneros.jsp");
                }
            } catch (Exception ex) {
                request.setAttribute("msg", "Conexão falhou.");
                rd = request.getRequestDispatcher("/erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String funcao = request.getParameter("funcao");
             
            if (funcao.equals("cadastrar")){
                try{
                    Genero g = new Genero();
                    g.setDescricao(request.getParameter("descricao"));
                    dao.inserir(g);
                    
                    List<Genero> generos = dao.list();
                    request.setAttribute("generos", generos);
                    rd = request.getRequestDispatcher("/listGeneros.jsp");
                } catch (Exception ex){
                    request.setAttribute("msg", "Não foi possível cadastrar o Gênero");
                    rd = request.getRequestDispatcher("/erro.jsp");
                } finally{
                    rd.forward(request, response);
                }
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
