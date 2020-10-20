/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOPeriodoReserva;
import Entidades.PeriodoReserva;
import Entidades.PeriodoReservaPK;
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
 * @author presa
 */
@WebServlet(name = "ServletPeriodoReserva", urlPatterns = {"/ServletPeriodoReserva"})
public class ServletPeriodoReserva extends HttpServlet {

    DAOPeriodoReserva daoperiodoreserva = new DAOPeriodoReserva();
    RequestDispatcher rd = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String funcao = request.getParameter("funcao");
//
//        if (funcao.equals("buscar")) {
//
//            try {
//                String strid = request.getParameter("id");
//                int id = Integer.parseInt(strid);
//                PeriodoReservaPK periodoreserva = daoperiodoreserva.obter(id);
//                request.setAttribute("periodoreserva", periodoreserva);
//                rd = request.getRequestDispatcher("/PeriodoReserva_lista.jsp");
//            } catch (Exception ex) {
//                request.setAttribute("msg", "O periodoreserva não foi encontrado no banco de dados!");
//                rd = request.getRequestDispatcher("/Erro.jsp");
//            } finally {
//                rd.forward(request, response);
//            }
//
//        } else if (funcao.equals("listar")) {
//            try {
//                List<PeriodoReservaPK> periodoreservas = daoperiodoreserva.list();
//                if (periodoreservas == null || periodoreservas.isEmpty()) {
//                    request.setAttribute("msg", "Não existem cadastrados no banco.");
//                    rd = request.getRequestDispatcher("Erro.jsp");
//                } else {
//                    request.setAttribute("periodoreserva", periodoreservas);
//                    rd = request.getRequestDispatcher("/PeriodoReserva.jsp");
//                }
//            } catch (Exception ex) {
//                request.setAttribute("msg", "Conexão falhou.");
//                rd = request.getRequestDispatcher("Erro.jsp");
//            } finally {
//                rd.forward(request, response);
//            }
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String funcao = request.getParameter("funcao");

        if (funcao.equals("Cadastrar")) {
            try {
                PeriodoReservaPK e = new PeriodoReservaPK();
                int DataReserva = Integer.parseInt(request.getParameter("qtd_dias"));
                int IdReserva = Integer.parseInt(request.getParameter("IdReserva"));
                int IdApartamento = Integer.parseInt(request.getParameter("IdAcomodacao"));
                
                PeriodoReservaPK prk = new PeriodoReservaPK();
                prk.setDataReserva(DataReserva);
                prk.setReservaIdReserva(IdReserva);
                prk.setApartamentoIdApartamento(IdApartamento);
                
                PeriodoReserva pr = new PeriodoReserva();
                pr.setPeriodoReservaPK(prk);

                daoperiodoreserva.inserir(pr);

                List<PeriodoReserva> periodoreservas = daoperiodoreserva.list();
                request.setAttribute("periodoreservas", periodoreservas);
                rd = request.getRequestDispatcher("/PeriodoReserva_lista.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "Não foi possível cadastrar o PeriodoReserva");
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
