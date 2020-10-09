/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAOs.DAOAtor;
import DAOs.DAOFilme;
import DAOs.DAOGenero;
import Entidades.Ator;
import Entidades.Filme;
import Entidades.Genero;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
@WebServlet(name = "FilmeServlet", urlPatterns = {"/FilmeServlet"})
public class FilmeServlet extends HttpServlet {

    private RequestDispatcher rd = null;
    private DAOFilme dao = new DAOFilme();

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
                Filme filme = dao.obter(id);
                request.setAttribute("filme", filme);
                rd = request.getRequestDispatcher("/filme.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "O filme não foi encontrado no banco de dados!");
                rd = request.getRequestDispatcher("/erro.jsp");
            } finally {
                rd.forward(request, response);
            }

        } else if (funcao.equals("listar")) {
            try {
                List<Filme> filmes = dao.list();
                if (filmes == null || filmes.isEmpty()) {
                    request.setAttribute("msg", "Não existem cadastrados no banco.");
                    rd = request.getRequestDispatcher("/erro.jsp");
                } else {
                    request.setAttribute("filmes", filmes);
                    rd = request.getRequestDispatcher("listFilmes.jsp");
                }
            } catch (Exception ex) {
                request.setAttribute("msg", "Conexão falhou.");
                rd = request.getRequestDispatcher("/erro.jsp");
            } finally {
                rd.forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String funcao = request.getParameter("funcao");

        if (funcao.equals("cadastrar")) {
            
            try {
                String nome = request.getParameter("nome");
                String descricao = request.getParameter("descricao");
                int ano = Integer.parseInt(request.getParameter("ano"));
                int genero_id = Integer.parseInt(request.getParameter("genero"));
                String[] atores_str = request.getParameterValues(("atores"));
                
                DAOAtor daoAtor = new DAOAtor();
                List<Ator> atores = new ArrayList<Ator>();
                int id;
                Ator a;
                for(String s: atores_str){
                    //["3","4","7"]
                    id = Integer.parseInt(s);
                    a = daoAtor.obter(id);
                    atores.add(a);
                }
                

                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR, ano);

                DAOGenero daoGenero = new DAOGenero();
                Genero g = daoGenero.obter(genero_id);

                Filme f = new Filme();
                f.setNome(nome);
                f.setDescricao(descricao);
                f.setAno(c.getTime());
                f.setIdGenero(g);
                f.setAtorList(atores);

                dao.inserir(f);
                
                List<Filme> filmes = dao.list();
                request.setAttribute("filmes", filmes);
                rd = request.getRequestDispatcher("/listFilmes.jsp");
            } catch (Exception ex) {
                request.setAttribute("msg", "Não foi possível cadastrar o filme");
                rd = request.getRequestDispatcher("/erro.jsp");
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
