/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOAcomod;
import DAOs.DAOEquipamento;
import DAOs.DAOTipoAcomod;
import Entidades.Acomodacao;
import Entidades.Equipamento;
import Entidades.TipoAcomodacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renan
 */
@WebServlet(name = "ServletAcomod", urlPatterns = {"/ServletAcomod"})
public class ServletAcomod extends HttpServlet {
    DAOAcomod daoAcomod = new DAOAcomod();
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
                Acomodacao Acomod = daoAcomod.obter(id);
                request.setAttribute("acomodacao", Acomod);
                rd = request.getRequestDispatcher("/Acomodacao.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "A Acomodação não foi encontrado no banco de dados!");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }

        } else if (funcao.equals("listar")) {
            try {
                List<Acomodacao> Acomods = daoAcomod.list();
                if (Acomods == null || Acomods.isEmpty()) {
                    request.setAttribute("msg", "Não existem cadastrados no banco.");
                    rd = request.getRequestDispatcher("Erro.jsp");
                } else {
                    request.setAttribute("acomodacoes", Acomods);
                    rd = request.getRequestDispatcher("/Acomodacao_lista.jsp");
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
                int id = Integer.parseInt(request.getParameter("id"));
                int idtipo = Integer.parseInt(request.getParameter("idtipo"));
                String nome = request.getParameter("nomeacomod");
                
//                DAOTipoAcomod daotipoacomod = new DAOTipoAcomod();
//                TipoAcomodacao ta = daotipoacomod.obter(idtipo);
//                int x = ta.getIdTipo();
                DAOTipoAcomod daotipoacomod = new DAOTipoAcomod();
                TipoAcomodacao g = daotipoacomod.obter(idtipo);
                
                String[] equipamentos_str = request.getParameterValues(("equipamentos"));
                
                DAOEquipamento DAOEquipamento = new DAOEquipamento();
                List<Equipamento> equipamentos = new ArrayList<Equipamento>();
                int id2;
                Equipamento b;
                for(String s: equipamentos_str){
                    //["3","4","7"]
                    id = Integer.parseInt(s);
                    b = DAOEquipamento.obter(id);
                    equipamentos.add(b);
                }
                
                Acomodacao a = new Acomodacao();
                
                a.setTipoAcomodacaoIdTipo(g);
                a.setIdAcomodacao(id);
                a.setNomeAcomodacao(nome);
                a.setEquipamentoList(equipamentos);
                
                daoAcomod.inserir(a);

                List<Acomodacao> Acomods = daoAcomod.list();
                request.setAttribute("acomodacoes", Acomods);
                rd = request.getRequestDispatcher("/Acomodacao_lista.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "Não foi possível cadastrar a Acomodacao");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        }
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
