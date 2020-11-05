/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOFuncionario;
import DAOs.DAOPessoa;
import DAOs.DAOSetor;
import Entidades.Funcionario;
import Entidades.Pessoa;
import Entidades.Setor;
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
@WebServlet(name = "ServletFuncionario", urlPatterns = {"/ServletFuncionario"})
public class ServletFuncionario extends HttpServlet {

    DAOFuncionario daofuncionario = new DAOFuncionario();
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
                Funcionario funcionario = daofuncionario.obter(id);
                request.setAttribute("funcionario", funcionario);
                rd = request.getRequestDispatcher("/Funcionario_lista.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "O funcionario não foi encontrado no banco de dados!");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }

        } else if (funcao.equals("listar")) {
            try {
                List<Funcionario> funcionarios = daofuncionario.list();
                if (funcionarios == null || funcionarios.isEmpty()) {
                    request.setAttribute("msg", "Não existem cadastrados no banco.");
                    rd = request.getRequestDispatcher("Erro.jsp");
                } else {
                    request.setAttribute("funcionarios", funcionarios);
                    rd = request.getRequestDispatcher("Funcionario.jsp");
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
                int id2 = Integer.parseInt(request.getParameter("idSetor"));
                int id = Integer.parseInt(request.getParameter("idPessoa"));

                String contato = request.getParameter("contato");

                DAOPessoa daoPessoa = new DAOPessoa();
                Pessoa g = daoPessoa.obter(id);
                int x = g.getIdPessoa();
                System.out.println(x);
                Funcionario c = new Funcionario();
                c.setPessoaIdPessoa(x);

                DAOSetor daoSetor = new DAOSetor();
                Setor g1 = daoSetor.obter(id2);
                c.setSetorIdSetor(g1);
                c.setContato(contato);

                String dataString = request.getParameter("data_de_contratacao");
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }

                c.setDataContratacao(data);

                daofuncionario.inserir(c);

                List<Funcionario> funcionarios = daofuncionario.list();
                request.setAttribute("funcionarios", funcionarios);
                rd = request.getRequestDispatcher("/Funcionario.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "Não foi possível cadastrar o funcionario");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        }
        if (funcao.equals("excluir")) {
            String str_id = request.getParameter("id");
            int id = Integer.parseInt(str_id);

            try {
                Funcionario funcionario = daofuncionario.obter(id);
                daofuncionario.remover(funcionario);

                List<Funcionario> funcionarios = daofuncionario.list();
                request.setAttribute("funcionarios", funcionarios);
                rd = request.getRequestDispatcher("/Funcionario.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                String msg = "Não foi possível cadastrar a Pessoa" + " " + ex.toString();
                request.setAttribute("msg", msg);
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        } else if (funcao.equals("buscaalterar")) {
            try {
                String str_id = request.getParameter("id");
                int id = Integer.parseInt(str_id);
                Funcionario f = daofuncionario.obter(id);

                request.setAttribute("funcionario", f);
                rd = request.getRequestDispatcher("/alterFuncionario.jsp");
                rd.forward(request, response);
            } catch (Exception ex) {
                deuErro(request, response, "Funcionario não encontrado!");
            }
        } else if (funcao.equals("alterar")) {
            try {
                int id2 = Integer.parseInt(request.getParameter("idSetor"));
                int id = Integer.parseInt(request.getParameter("idPessoa"));

                String contato = request.getParameter("contato");

                DAOPessoa daoPessoa = new DAOPessoa();
                Pessoa g = daoPessoa.obter(id);
                int x = g.getIdPessoa();
                System.out.println(x);
                Funcionario c = new Funcionario();
                c.setPessoaIdPessoa(x);

                DAOSetor daoSetor = new DAOSetor();
                Setor g1 = daoSetor.obter(id2);
                c.setSetorIdSetor(g1);
                c.setContato(contato);

                String dataString = request.getParameter("data_de_contratacao");
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }

                c.setDataContratacao(data);

                daofuncionario.atualizar(c);

                request.setAttribute("funcionario", c);
                rd = request.getRequestDispatcher("/Funcionario_lista.jsp");
                rd.forward(request, response);
            } catch (Exception ex) {
                deuErro(request, response, "Não foi possivel alterar o Funcionario. Erro: " + ex.toString());
            }
        }

    }

    private void listarFuncionario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Funcionario> funcionarios = daofuncionario.list();
        request.setAttribute("funcionario", funcionarios);
        rd = request.getRequestDispatcher("/Funcionario.jsp");
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
