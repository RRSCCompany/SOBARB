/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOPessoa;
import Entidades.Pessoa;
import java.awt.KeyboardFocusManager;
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
@WebServlet(name = "ServletPessoa", urlPatterns = {"/ServletPessoa"})
public class ServletPessoa extends HttpServlet {

    DAOPessoa daopessoa = new DAOPessoa();
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
                Pessoa pessoa = daopessoa.obter(id);
                request.setAttribute("pessoa", pessoa);
                rd = request.getRequestDispatcher("/Pessoa_lista.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "O pessoa não foi encontrado no banco de dados!");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }

        } else if (funcao.equals("listar")) {
            try {
                List<Pessoa> pessoas = daopessoa.list();
                if (pessoas == null || pessoas.isEmpty()) {
                    request.setAttribute("msg", "Não existem cadastrados no banco.");
                    rd = request.getRequestDispatcher("Erro.jsp");
                } else {
                    request.setAttribute("pessoas", pessoas);
                    rd = request.getRequestDispatcher("/Pessoa.jsp");
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
                Pessoa p = new Pessoa();
                p.setIdPessoa(Integer.parseInt(request.getParameter("id")));
                p.setCpfPessoa(request.getParameter("cpf"));
                p.setNomePessoa(request.getParameter("nome"));
                String dataString = request.getParameter("data_de_nascimento");
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }

                p.setDataNascimento(data);
                daopessoa.inserir(p);

                List<Pessoa> pessoas = daopessoa.list();
                request.setAttribute("pessoas", pessoas);
                rd = request.getRequestDispatcher("/Pessoa.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "Não foi possível cadastrar a Pessoa");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        }
        if (funcao.equals("excluir")) {
            String str_id = request.getParameter("id");
            int id = Integer.parseInt(str_id);
            
            try{
            Pessoa pessoa = daopessoa.obter(id);
            daopessoa.remover(pessoa);
            
            
            List<Pessoa> pessoas = daopessoa.list();
                request.setAttribute("pessoas", pessoas);
                rd = request.getRequestDispatcher("/Pessoa.jsp");
                rd.forward(request, response);
                
            } catch (Exception ex) {
                String msg = "Não foi possível cadastrar a Pessoa" + " " + ex.toString();
                request.setAttribute("msg", msg);
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }}else if (funcao.equals("buscaalterar")) {
            try {
                String str_id = request.getParameter("id");
                int id = Integer.parseInt(str_id);
                Pessoa f = daopessoa.obter(id);

                request.setAttribute("pessoa", f);
                rd = request.getRequestDispatcher("/alterPessoa.jsp");
                rd.forward(request, response);
            } catch (Exception ex) {
                deuErro(request, response, "Pessoa não encontrado!");
            }
        } else if (funcao.equals("alterar")) {
            try {
                Pessoa p = new Pessoa();
                p.setIdPessoa(Integer.parseInt(request.getParameter("id")));
                p.setCpfPessoa(request.getParameter("cpf"));
                p.setNomePessoa(request.getParameter("nome"));
                String dataString = request.getParameter("data_de_nascimento");
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }

                p.setDataNascimento(data);

                daopessoa.atualizar(p);

                request.setAttribute("pessoa", p);
                rd = request.getRequestDispatcher("/Pessoa_lista.jsp");
                rd.forward(request, response);
            } catch (Exception ex) {
                deuErro(request, response, "Não foi possivel alterar o Pessoa. Erro: " + ex.toString());
            }
        }
                   
    }
    private void listarPessoas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pessoa> pessoas = daopessoa.list();
        request.setAttribute("pessoas", pessoas);
        rd = request.getRequestDispatcher("/Pessoa.jsp");
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
