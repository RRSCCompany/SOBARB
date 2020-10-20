/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOEquipamento;
import Entidades.Equipamento;
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
@WebServlet(name = "ServletEquipamento", urlPatterns = {"/ServletEquipamento"})
public class ServletEquipamento extends HttpServlet {

    DAOEquipamento daoequipamento = new DAOEquipamento();
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
                Equipamento equipamento = daoequipamento.obter(id);
                request.setAttribute("equipamento", equipamento);
                rd = request.getRequestDispatcher("/Equipamento_lista.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "O equipamento não foi encontrado no banco de dados!");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }

        } else if (funcao.equals("listar")) {
            try {
                List<Equipamento> equipamentos = daoequipamento.list();
                if (equipamentos == null || equipamentos.isEmpty()) {
                    request.setAttribute("msg", "Não existem cadastrados no banco.");
                    rd = request.getRequestDispatcher("Erro.jsp");
                } else {
                    request.setAttribute("equipamentos", equipamentos);
                    rd = request.getRequestDispatcher("/Equipamento.jsp");
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
                Equipamento e = new Equipamento();
                e.setIdEquipamento(Integer.parseInt(request.getParameter("id")));
                e.setNomeEquipamento(request.getParameter("equipamento_nome"));
                
                daoequipamento.inserir(e);

                List<Equipamento> equipamentos = daoequipamento.list();
                request.setAttribute("equipamentos", equipamentos);
                rd = request.getRequestDispatcher("/Equipamento.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "Não foi possível cadastrar o Equipamento");
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
