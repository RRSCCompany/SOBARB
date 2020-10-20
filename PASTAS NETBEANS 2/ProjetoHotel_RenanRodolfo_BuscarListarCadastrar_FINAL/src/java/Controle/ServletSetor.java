/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOSetor;
import Entidades.Setor;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
 * @author juuli
 */
@WebServlet(name = "ServletSetor", urlPatterns = {"/ServletSetor"})
public class ServletSetor extends HttpServlet {

    DAOSetor daosetor = new DAOSetor();
    RequestDispatcher rd = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String funcao = request.getParameter("funcao");

        if (funcao.equals("buscar")) {

            try {
                String strid = request.getParameter("id");
                int id = Integer.parseInt(strid);
                Setor setor = daosetor.obter(id);
                request.setAttribute("setor", setor);
                rd = request.getRequestDispatcher("/Setor_lista.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "O setor não foi encontrado no banco de dados!");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }

        } else if (funcao.equals("listar")) {
            try {
                List<Setor> setores = daosetor.list();
                if (setores == null || setores.isEmpty()) {
                    request.setAttribute("msg", "Não existem cadastrados no banco.");
                    rd = request.getRequestDispatcher("Erro.jsp");
                } else {
                    request.setAttribute("setores", setores);
                    rd = request.getRequestDispatcher("/Setor.jsp");
                }
            } catch (Exception ex) {
                request.setAttribute("msg", "Conexão falhou.");
                rd = request.getRequestDispatcher("Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
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

        String funcao = request.getParameter("funcao");

        if (funcao.equals("Cadastrar")) {
            try {
                Setor s = new Setor();
                s.setIdSetor(Integer.parseInt(request.getParameter("id")));
                s.setNomeSetor(request.getParameter("setor_nome"));

                daosetor.inserir(s);

                List<Setor> setores = daosetor.list();
                request.setAttribute("setores", setores);
                rd = request.getRequestDispatcher("/Setor.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "Não foi possível cadastrar o Setor");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        }
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
