package AcessoEscolar;

import java.io.IOException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Carvalho
 */
@WebServlet("/CadastraNotasServlet")
public class CadastraNotasServlet extends HttpServlet {

    ArrayList<Aluno> bobaes = new ArrayList<Aluno>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String nota1t, trabalhot, frequenciat, projetot, pft;
            boolean nota1t1, trabalhot1, frequenciat1, projetot1, pft1;

            double nota1 = Double.parseDouble((String) req.getParameter("Nota 1"));
            double trabalho = Double.parseDouble((String) req.getParameter("Trabalho"));
            double frequencia = Double.parseDouble((String) req.getParameter("Frequencia"));
            double projeto = Double.parseDouble((String) req.getParameter("Projeto"));
            double pf = Double.parseDouble((String) req.getParameter("Prova Final"));
            double m1 = (0.7 * ((nota1 + trabalho) / 2)) + (projeto * 0.3);
            String nome = (String) req.getParameter("nome");
            String situacao;

            if (nota1 >= 0 && nota1 <= 10) {
                req.setAttribute("nota1t", nota1);
                nota1t1 = true;
            } else {
                req.setAttribute("Errnota1", "Valor da Nota deve ser entre 0 e 10");
                nota1t1 = false;
            }

            if (trabalho >= 0 && trabalho <= 10) {
                req.setAttribute("trabalhot", trabalho);
                trabalhot1 = true;
            } else {
                req.setAttribute("Errtrab", "Valor do Trabalho deve ser entre 0 e 10");
                trabalhot1 = false;
            }

            if (frequencia >= 0 && frequencia <= 100) {
                req.setAttribute("frequenciat", frequencia);
                frequenciat1 = true;
            } else {

                req.setAttribute("Errfreq", "Valor da Frequencia deve ser entre 0 e 100");
                frequenciat1 = false;
            }

            if (projeto >= 0 && projeto <= 10) {
                req.setAttribute("projetot", projeto);
                projetot1 = true;
            } else {

                req.setAttribute("Errproj", "Valor do Projeto deve ser entre 0 e 10");
                projetot1 = false;
            }

            if (pf >= 0 && pf <= 10) {
                req.setAttribute("pft", pf);
                pft1 = true;
            } else {

                req.setAttribute("Errpf", "Valor da PF deve ser entre 0 e 10");
                pft1 = false;
            }

            if (frequencia >= 75) {
                if (m1 >= 7) {
                    situacao = "Aprovado";
                } else if (m1 < 3) {
                    situacao = "Reprovado";
                } else {
                    if (((pf + m1) / 2) >= 5) {
                        situacao = "Aprovado";
                    } else {
                        situacao = "Reprovado";
                    }
                }
            } else {
                situacao = "Reprovado";
            }

            Aluno bobao1 = new Aluno(nome, nota1, trabalho, projeto, frequencia, pf, situacao);
            
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("aulaBanco");
            EntityManager manager = factory.createEntityManager();

            manager.getTransaction().begin();
            
            manager.persist(bobao1);
            manager.getTransaction().commit();
            
            manager.close();
            factory.close();

            
            bobaes.add(bobao1);
            req.setAttribute("bobaes", bobaes);
            req.getRequestDispatcher("tabelinha.jsp").forward(req, resp);

            if (nota1t1 && trabalhot1 && frequenciat1 && projetot1 && pft1) {
                Aluno bobao = new Aluno(nome, nota1, trabalho, projeto, frequencia, pf, situacao);
                bobaes.add(bobao);
                req.setAttribute("bobaes", bobaes);
                //req.getRequestDispatcher("error404.html").forward(req, resp);
            } else {
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }

}
