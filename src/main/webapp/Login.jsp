<%-- 
    Document   : Login
    Created on : 26/03/2018, 16:18:21
    Author     : Lucas Carvalho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "AcessoEscolar.Usuario"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>

<!DOCTYPE html>

<%
    String nome = request.getParameter("Login");
    if(nome == null){
        nome = "";
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logue para Cadastrar uma nota</title>
    </head>
    <body> 
        <h1><%= (request.getParameter("error") == null) ? "":request.getParameter("error")%></h1>
        <form action="ServletLogin" method="POST">
            Login:<input type ="text" name="Login" value = "<%= request.getParameter("Login") != null ? request.getParameter("Login") : "" %>"><%= request.getAttribute("LoginErr") != null ? request.getAttribute("LoginErr") : "" %><br>
            Senha:<input type ="password" name="Senha" ><br>
            <button type="submit">Logar</button>
            <select name = "perfil">
                <option value="Aluno"<%= (request.getParameter("perfil") != null) && (request.getParameter("perfil").equals("Aluno")) ? "selected":""%> >Aluno </option>
                <option value="Professor"<%= (request.getParameter("perfil") != null) && (request.getParameter("perfil").equals("Professor")) ? "selected":""%> >Professor</option>
            </select><%= request.getAttribute("msgErroPerfil") != null ? request.getAttribute("msgErroPerfil") : "" %></br>
        </form>
    </body>
</html>
