/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import DAOs.DAOPessoa;
import Entidades.Erro;
import Entidades.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author juuli
 */
@WebServlet(name = "ServletPessoa", urlPatterns = {"/ServletPessoa"})
public class ServletPessoa extends HttpServlet {
    
    RequestDispatcher rd = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPessoa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPessoa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

       
        String funcao =  request.getParameter("funcao");
//        String strid = request.getParameter("id");
DAOPessoa daopessoa = new DAOPessoa();
if (funcao.equals("listar")) {
            List<Pessoa> pessoas = daopessoa.listInOrderId();
            if (pessoas != null) {
                request.setAttribute("pessoas", pessoas);
                rd = request.getRequestDispatcher("/Pessoa.jsp");
            } else {
                request.setAttribute("msg", "Não Existem Pessoas cadastrados!");
                rd = request.getRequestDispatcher("/Erro.jsp");
            }
            rd.forward(request, response);
        } else if (funcao.equals("buscar")) {

            try {
                String strid = request.getParameter("id");
                int id = Integer.parseInt(strid);
                Pessoa pessoa = daopessoa.obter(id);
                request.setAttribute("pessoa", pessoa);
                rd = request.getRequestDispatcher("/Pessoa_lista.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "A pessoa não foi encontrado no banco de dados!");
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
         DAOPessoa daopessoa = new DAOPessoa();
         if (funcao.equals("Cadastrar")){
             Pessoa p = new Pessoa();
             p.setIdPessoa(Integer.parseInt(request.getParameter("id")));
             p.setNomePessoa(request.getParameter("nome"));
             p.setCpfPessoa(request.getParameter("cpf"));
             
             SimpleDateFormat format = new SimpleDateFormat("dd/mm/aaaa");

           
             try {
                 p.setDataNascimento(format.parse(request.getParameter("data_de_nascimento")));
             } catch (ParseException ex) {
                 Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
             }

             daopessoa.inserir(p);
             rd = request.getRequestDispatcher("/cadPessoa.jsp");
             rd.forward(request, response);
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
