/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOAcomodacaoPrecoPK;
import DAOs.DAOAcomodacaoPreco;
import DAOs.DAOTipoAcomod;
import Entidades.AcomodacaoPreco;
import Entidades.AcomodacaoPrecoPK;
import Entidades.TipoAcomodacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "ServletAcomodPreco", urlPatterns = {"/ServletAcomodPreco"})
public class ServletAcomodPreco extends HttpServlet {

    DAOAcomodacaoPreco daoacomodprecoP = new DAOAcomodacaoPreco();
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
                AcomodacaoPreco acomodacaopreco = daoacomodprecoP.obter(id);
                request.setAttribute("acomodacaopreco", acomodacaopreco);
                rd = request.getRequestDispatcher("/AcomodPreco.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "O Tipo de Acomodação não foi encontrado no banco de dados!");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }

        } else if (funcao.equals("listar")) {
            try {
                List<AcomodacaoPreco> precoacomods = daoacomodprecoP.list();
                if (precoacomods == null || precoacomods.isEmpty()) {
                    request.setAttribute("msg", "Não existem cadastrados no banco.");
                    rd = request.getRequestDispatcher("Erro.jsp");
                } else {
                    request.setAttribute("precoacomods", precoacomods);
                    rd = request.getRequestDispatcher("/AcomodPreco_lista.jsp");
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

        String funcao = request.getParameter("funcao");

        if (funcao.equals("Cadastrar")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                int id2 = Integer.parseInt(request.getParameter("idtipoacomod"));
                double preco = Integer.parseInt(request.getParameter("preco"));
                String dataString = request.getParameter("dataentrada");
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                AcomodacaoPreco ap1 = new AcomodacaoPreco();
                
                DAOTipoAcomod daoTipoAcomod = new DAOTipoAcomod();
                TipoAcomodacao g1 = daoTipoAcomod.obter(id2);
//                ap1.setAcomodacaoPrecoPK(g1);

                
                DAOTipoAcomod daotipoacomod = new DAOTipoAcomod();
                TipoAcomodacao ta = daotipoacomod.obter(id);
                int x = ta.getIdTipo();

//                ap.setTipoAcomodacaoIdTipo(x);
//                ap.setData(data);
//                ap1.setPreco(preco);
//
//                daoacomodpreco.inserir(ap);
//                daoacomodprecoP.inserir(ap1);
//
//                List<AcomodacaoPrecoPK> precoacomods = daoacomodpreco.list();
//                request.setAttribute("precoacomods", precoacomods);
                rd = request.getRequestDispatcher("/precoacomod_lista.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "Não foi possível cadastrar a Tipo da Acomodacao");
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
