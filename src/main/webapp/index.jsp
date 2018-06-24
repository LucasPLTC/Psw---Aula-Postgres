<%-- 
    Document   : index
    Created on : 26/03/2018, 18:07:29
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastre Notas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action ="CadastraNotasServlet" method ="POST">
            Nome: <input type ="text" name="nome" value="${param.nome}"><br>
            Nota 1: <input type ="text" name="Nota 1" value=${nota1t}>${Errnota1}<br>
            Trabalho: <input type ="text" name="Trabalho" value=${trabalhot}>${Errtrab}<br>
            Frequencia: <input type ="text" name="Frequencia" value=${frequenciat}>${Errfreq}<br>
            Projeto: <input type ="text" name="Projeto" value=${projetot}>${Errproj}<br>
            PF: <input type ="text" name="Prova Final" value=${pft}>${Errpf}<br>
            <button type ="submit"> Enviar </button>
        </form>
    </body>
</html>
