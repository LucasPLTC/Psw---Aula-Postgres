<%-- 
    Document   : TabelaAlunos
    Created on : 26/03/2018, 16:31:06
    Author     : Lucas Carvalho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "AcessoEscolar.Aluno"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela de Notas</title>
    </head>
    <body>
        <table>
            <th> Nome </th>
            <th> Nota 1 </th>
            <th> Trabalho </th>
            <th> Projeto </th>
            <th> Frequencia </th>
            <th> Prova Final </th>
            <th> Situacao </th>
                <c:if test="${not empty bobaes}" >
                    <c:forEach items="${bobaes}" var="bobo" >
                    <tr>
                        <td>${ bobo.nome }</td>
                        <td>${ bobo.nota1 }</td>
                        <td>${ bobo.trabalho }</td>
                        <td>${ bobo.projeto }</td>
                        <td>${ bobo.frequencia }</td>
                        <td>${ bobo.pf }</td>
                        <td>${ bobo.situacao }</td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </body>
</html>
</table>
</body>
</html>
