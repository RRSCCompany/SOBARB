/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOAcomod;
import DAOs.DAOTipoAcomod;
import Entidades.Acomodacao;
import Entidades.TipoAcomodacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

/**
 *
 * @author Hotel
 */
@WebServlet(name = "ServletTipoAcomod", urlPatterns = {"/ServletTipoAcomod"})
public class ServletTipoAcomod extends HttpServlet {

    DAOTipoAcomod daoTipoAcomod = new DAOTipoAcomod();
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
                TipoAcomodacao TipoAcomod = daoTipoAcomod.obter(id);
                request.setAttribute("tipoacomod", TipoAcomod);
                rd = request.getRequestDispatcher("/TipoAcomod.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "O Tipo de Acomodação não foi encontrado no banco de dados!");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }

        } else if (funcao.equals("listar")) {
            try {
                List<TipoAcomodacao> TipoAcomods = daoTipoAcomod.list();
                if (TipoAcomods == null || TipoAcomods.isEmpty()) {
                    request.setAttribute("msg", "Não existem cadastrados no banco.");
                    rd = request.getRequestDispatcher("Erro.jsp");
                } else {
                    request.setAttribute("acomodacoes", TipoAcomods);
                    rd = request.getRequestDispatcher("/TipoAcomod_lista.jsp");
                }
            } catch (Exception ex) {
                request.setAttribute("msg", "Conexão falhou.");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String funcao = request.getParameter("funcao");

        if (funcao.equals("Cadastrar")) {
            try {
                TipoAcomodacao ta = new TipoAcomodacao();
                ta.setIdTipo(Integer.parseInt(request.getParameter("id")));
                ta.setNomeTipo(request.getParameter("nometipo"));

                daoTipoAcomod.inserir(ta);

                List<TipoAcomodacao> TipoAcomods = daoTipoAcomod.list();
                request.setAttribute("acomodacoes", TipoAcomods);
                rd = request.getRequestDispatcher("/TipoAcomod_lista.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "Não foi possível cadastrar a Tipo da Acomodacao");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        }
        if (funcao.equals("excluir")) {
            String str_id = request.getParameter("id");
            int id = Integer.parseInt(str_id);

            try {
                TipoAcomodacao TipoAcomods = daoTipoAcomod.obter(id);
                daoTipoAcomod.remover(TipoAcomods);

                List<TipoAcomodacao> setors = daoTipoAcomod.list();
                request.setAttribute("acomodacoes", setors);
                rd = request.getRequestDispatcher("/TipoAcomodacao.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                String msg = "Não foi possível cadastrar a Pessoa" + " " + ex.toString();
                request.setAttribute("msg", msg);
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        }else if (funcao.equals("buscaalterar")) {
            try {
                String str_id = request.getParameter("id");
                int id = Integer.parseInt(str_id);
                TipoAcomodacao f = daoTipoAcomod.obter(id);

                request.setAttribute("tipoacomod", f);
                rd = request.getRequestDispatcher("/alterTipoAcomod.jsp");
                rd.forward(request, response);
            } catch (Exception ex) {
                deuErro(request, response, "Tipo de Acomodacao não encontrado!");
            }
        } else if (funcao.equals("alterar")) {
            try {
                TipoAcomodacao ta = new TipoAcomodacao();
                ta.setIdTipo(Integer.parseInt(request.getParameter("id")));
                ta.setNomeTipo(request.getParameter("nometipo"));

                daoTipoAcomod.atualizar(ta);

                request.setAttribute("tipoacomod", ta);
                rd = request.getRequestDispatcher("/TipoAcomod.jsp");
                rd.forward(request, response);
            } catch (Exception ex) {
                deuErro(request, response, "Não foi possivel alterar o Tipo da Acomodação. Erro: " + ex.toString());
            }
        }
    }
    
    private void listarTiposAcomods(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<TipoAcomodacao> tipoacomods = daoTipoAcomod.list();
        request.setAttribute("acomodacoes", tipoacomods);
        rd = request.getRequestDispatcher("/TipoAcomod_lista.jsp");
        rd.forward(request, response);
    }

    private void deuErro(HttpServletRequest request, HttpServletResponse response, String msg)
            throws ServletException, IOException {
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/Erro.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
