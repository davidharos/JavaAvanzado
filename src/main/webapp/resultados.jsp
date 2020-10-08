<%-- 
    Document   : resultados
    Created on : Sep 30, 2020, 10:47:27 PM
    Author     : david
--%>
<%@page import="model.operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultados</h1>
        <%
          operaciones op = (operaciones) request.getAttribute("resultados");
        %>
        <p>El area de tu triangulo es: <%=op.getArea()%></p>
        
        <p>El perimetro de tu triangulo es: <%=op.getPerim()%></p>
    </body>
</html>
