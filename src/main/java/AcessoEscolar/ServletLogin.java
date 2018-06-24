/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AcessoEscolar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Carvalho
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    
   
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String login = req.getParameter("Login");
        String senha = req.getParameter("Senha");
        String perfil = req.getParameter("Perfil");
        String loginCerto = "Carlinhos";
        String senhaCerta = "123";
        String error;
        
        
        boolean formValido = true;
        
        //efetua a validação
        if(login == null || login.length() <= 5){
            req.setAttribute("LoginErr", "O login deve ter mais do 5 caracters");
            formValido = false;
        }
        
        
        if(perfil == null || perfil.equals("")){
            req.setAttribute("PerfilErr", "O perfil deve ser preenchido");
            formValido = false;
        }
        
        
        
                 if(login.equals(loginCerto) && senha.equals(senhaCerta)){
                     req.getRequestDispatcher("/index.jsp").forward(req, resp);
            
                 }
                 else{
                     req.getRequestDispatcher("/error404.html").forward(req, resp);
                 }
            
       
          
        
       
    }

   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        doGet(req,resp);
    }

}
