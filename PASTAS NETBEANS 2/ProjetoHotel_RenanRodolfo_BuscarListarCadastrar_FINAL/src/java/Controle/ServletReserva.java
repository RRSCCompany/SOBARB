/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOCliente;
import DAOs.DAOReserva;
import Entidades.Cliente;

import DAOs.DAOReserva;
import Entidades.Reserva;
import Entidades.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
@WebServlet(name = "ServletReserva", urlPatterns = {"/ServletReserva"})
public class ServletReserva extends HttpServlet {

    DAOReserva daoreserva = new DAOReserva();
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
                Reserva reserva = daoreserva.obter(id);
                request.setAttribute("reserva", reserva);
                rd = request.getRequestDispatcher("/Reserva_lista.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "O cliente não foi encontrado no banco de dados!");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }

        } else if (funcao.equals("listar")) {
            try {
                List<Reserva> reservas = daoreserva.list();
                if (reservas == null || reservas.isEmpty()) {
                    request.setAttribute("msg", "Não existem cadastrados no banco.");
                    rd = request.getRequestDispatcher("/Erro.jsp");
                } else {
                    request.setAttribute("reservas", reservas);
                    rd = request.getRequestDispatcher("Reserva.jsp");
                }
            } catch (Exception ex) {
                request.setAttribute("msg", "Conexão falhou.");
                rd = request.getRequestDispatcher("/Erro.jsp");
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
                int id = Integer.parseInt(request.getParameter("idReserva"));
                int idcp = Integer.parseInt(request.getParameter("idClientePessoa"));

                DAOCliente daocliente = new DAOCliente();
                Cliente g = daocliente.obter(idcp);
                
                String dataString = request.getParameter("datareserva");
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
                Reserva r = new Reserva();
                r.setIdReserva(id);
                r.setDataReserva(data);
                r.setClientePessoaIdPessoa(g);
                
                

                daoreserva.inserir(r);

                List<Reserva> reservas = daoreserva.list();
                request.setAttribute("reservas", reservas);
                rd = request.getRequestDispatcher("/Reserva.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "Não foi possível cadastrar a reserva");
                rd = request.getRequestDispatcher("/Erro.jsp");
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
