/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


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
 * @author Hotel
 */
@WebServlet(name = "ServletAcomodPreco", urlPatterns = {"/ServletAcomodPreco"})
public class ServletAcomodPreco extends HttpServlet {

    DAOAcomodacaoPreco daoacomodpreco = new DAOAcomodacaoPreco();
    RequestDispatcher rd = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String funcao = request.getParameter("funcao");

        if (funcao.equals("listar")) {
            try {
                List<AcomodacaoPreco> acomodacoespreco = daoacomodpreco.list();
                if (acomodacoespreco == null || acomodacoespreco.isEmpty()) {
                    request.setAttribute("msg", "Não existem cadastrados no banco.");
                    rd = request.getRequestDispatcher("/Erro.jsp");
                } else {
                    request.setAttribute("acomodacoespreco", acomodacoespreco);
                    rd = request.getRequestDispatcher("AcomodPreco_lista.jsp");
                }
            } catch (Exception ex) {
                request.setAttribute("msg", "Conexão falhou.");
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        } else if (funcao.equals("buscar")){
            try{
                int id = Integer.parseInt(request.getParameter("idtipoacomod"));
                double preco = Integer.parseInt(request.getParameter("preco"));
                String dataString = request.getParameter("dataentrada");
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }

                List<AcomodacaoPreco> acomodacoespreco = daoacomodpreco.list();
                AcomodacaoPreco acomodacoespreco_correto = null;
                for (AcomodacaoPreco p: acomodacoespreco){
                    if ((p.getAcomodacaoPrecoPK().getData() == data) && (p.getTipoAcomodacao().getIdTipo() == id)){
                        acomodacoespreco_correto = p;
                    }
                }
                request.setAttribute("acomodacaopreco", acomodacoespreco_correto);
                rd = request.getRequestDispatcher("/AcomodacaoPreco.jsp");
            }catch (Exception ex){
                request.setAttribute("msg", "Deu erro: "+ex.toString());
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
                int id = Integer.parseInt(request.getParameter("idtipoacomod"));
                double preco = Integer.parseInt(request.getParameter("preco"));
                String dataString = request.getParameter("dataentrada");
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                AcomodacaoPrecoPK apk = new AcomodacaoPrecoPK();
                apk.setData(data);
                apk.setTipoAcomodacaoIdTipo(id);
                
                AcomodacaoPreco ap = new AcomodacaoPreco();
                ap.setAcomodacaoPrecoPK(apk);
                ap.setPreco(preco);
                
                daoacomodpreco.inserir(ap);

                List<AcomodacaoPreco> precoacomods = daoacomodpreco.list();
                request.setAttribute("acomodacoespreco", precoacomods);
                rd = request.getRequestDispatcher("/AcomodPreco_lista.jsp");
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
                AcomodacaoPreco acomodpreco = daoacomodpreco.obter(id);
                daoacomodpreco.remover(acomodpreco);

                List<AcomodacaoPreco> acomodspreco = daoacomodpreco.list();
                request.setAttribute("acomodacoespreco", acomodspreco);
                rd = request.getRequestDispatcher("/AcomodPreco_lista.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                String msg = "Não foi possível cadastrar o preço da acomodação" + " " + ex.toString();
                request.setAttribute("msg", msg);
                rd = request.getRequestDispatcher("/Erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        }else if (funcao.equals("buscaalterar")) {
            try {
                String str_id = request.getParameter("id");
                int id = Integer.parseInt(str_id);
                AcomodacaoPreco f = daoacomodpreco.obter(id);

                request.setAttribute("acomodacaopreco", f);
                rd = request.getRequestDispatcher("/alterAcomodPreco.jsp");
                rd.forward(request, response);
            } catch (Exception ex) {
                deuErro(request, response, "Preco da Acomodacao não encontrado!");
            }
        } else if (funcao.equals("alterar")) {
            try {
                int id = Integer.parseInt(request.getParameter("idtipoacomod"));
                double preco = Integer.parseInt(request.getParameter("preco"));
                String dataString = request.getParameter("dataentrada");
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                AcomodacaoPrecoPK apk = new AcomodacaoPrecoPK();
                apk.setData(data);
                apk.setTipoAcomodacaoIdTipo(id);
                
                AcomodacaoPreco ap = new AcomodacaoPreco();
                ap.setAcomodacaoPrecoPK(apk);
                ap.setPreco(preco);

                daoacomodpreco.atualizar(ap);

                request.setAttribute("acomodacaopreco", ap);
                rd = request.getRequestDispatcher("/AcomodacaoPreco.jsp");
                rd.forward(request, response);
            } catch (Exception ex) {
                deuErro(request, response, "Não foi possivel alterar o preço da acomodação. Erro: " + ex.toString());
            }
        }
    }
    private void listarSetores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<AcomodacaoPreco> acomodacoespreco = daoacomodpreco.list();
        request.setAttribute("acomodacoespreco", acomodacoespreco);
        rd = request.getRequestDispatcher("/AcomodPreco_lista.jsp");
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
