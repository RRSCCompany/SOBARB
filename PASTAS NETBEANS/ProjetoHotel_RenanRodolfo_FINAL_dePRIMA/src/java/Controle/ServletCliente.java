/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOCliente;
import DAOs.DAOPessoa;
import Entidades.Cliente;
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
@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente"})
public class ServletCliente extends HttpServlet {

    DAOCliente daocliente = new DAOCliente();
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
                Cliente cliente = daocliente.obter(id);
                request.setAttribute("cliente", cliente);
                rd = request.getRequestDispatcher("/Cliente_lista.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "O cliente não foi encontrado no banco de dados!");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }

        } else if (funcao.equals("listar")) {
            try {
                List<Cliente> clientes = daocliente.list();
                if (clientes == null || clientes.isEmpty()) {
                    request.setAttribute("msg", "Não existem cadastrados no banco.");
                    rd = request.getRequestDispatcher("Erro.jsp");
                } else {
                    request.setAttribute("clientes", clientes);
                    rd = request.getRequestDispatcher("Cliente.jsp");
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
                int id = Integer.parseInt(request.getParameter("idPessoa"));
                String cdo = request.getParameter("cidade_de_origem");
                String cdd = request.getParameter("cidade_de_destino");

                DAOPessoa daoPessoa = new DAOPessoa();
                Pessoa g = daoPessoa.obter(id);
                int x = g.getIdPessoa();
                System.out.println(x);
                Cliente c = new Cliente();
                c.setPessoaIdPessoa(x);
                c.setCidadeOrigem(cdo);
                c.setCidadeDestino(cdd);
                String dataString = request.getParameter("data_de_cadastro");
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }

                c.setDataCadastro(data);

                daocliente.inserir(c);

                List<Cliente> clientes = daocliente.list();
                request.setAttribute("clientes", clientes);
                rd = request.getRequestDispatcher("/Cliente.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "Não foi possível cadastrar o cliente");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        }
        if (funcao.equals("excluir")) {
            String str_id = request.getParameter("id");
            int id = Integer.parseInt(str_id);

            try {
                Cliente cliente = daocliente.obter(id);
                daocliente.remover(cliente);

                List<Cliente> clientes = daocliente.list();
                request.setAttribute("clientes", clientes);
                rd = request.getRequestDispatcher("/Cliente.jsp");
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
                String str_id = request.getParameter("idPessoa");
                int id = Integer.parseInt(str_id);
                Cliente f = daocliente.obter(id);

                request.setAttribute("cliente", f);
                rd = request.getRequestDispatcher("/alterCliente.jsp");
                rd.forward(request, response);
            } catch (Exception ex) {
                deuErro(request, response, "Cliente não encontrado!");
            }
        } else if (funcao.equals("alterar")) {
            try {
                int id = Integer.parseInt(request.getParameter("idPessoa"));
                String cdo = request.getParameter("cidade_de_origem");
                String cdd = request.getParameter("cidade_de_destino");

                DAOPessoa daoPessoa = new DAOPessoa();
                Pessoa g = daoPessoa.obter(id);
                int x = g.getIdPessoa();
                System.out.println(x);
                Cliente c = new Cliente();
                c.setPessoaIdPessoa(x);
                c.setCidadeOrigem(cdo);
                c.setCidadeDestino(cdd);
                String dataString = request.getParameter("data_de_cadastro");
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }

                c.setDataCadastro(data);

                daocliente.atualizar(c);

                request.setAttribute("cliente", c);
                rd = request.getRequestDispatcher("/Cliente_lista.jsp");
                rd.forward(request, response);
            } catch (Exception ex) {
                deuErro(request, response, "Não foi possivel alterar o Cliente. Erro: " + ex.toString());
            }
        }

    }
    
    private void listarClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = daocliente.list();
        request.setAttribute("clientes", clientes);
        rd = request.getRequestDispatcher("/Cliente.jsp");
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
