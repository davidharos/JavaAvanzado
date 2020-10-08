<%-- 
    Document   : index
    Created on : Sep 30, 2020, 10:32:49 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.calcular"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculadora de area y Perimetro para Triangulos</h1>

        <form action="calcular" method="post">
            Introduzca la Base:
            <input type="text" name="base">
            <p>
                Introduzca la altura:
                <input type="text" name="altura">
            </p>
            <p>
                Cual es tu nombre?
                <input type="text" name="autor">
            </p>
            <p>
                <input type="submit" value="Calcular">   
            </p>          
        </form>

        <h2>Ultimo triangulo calculado:</h2>
        <!-- Cookies -->
        <%
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (int i = 0; i < ck.length; i++) {
                    if (ck[i].getName().equals("base")) {
                        out.print("<p>Tu triangulo anterior fue: </p>" + ck[i].getValue() + " de base y ");
                    }

                    if (ck[i].getName().equals("altura")) {
                        out.print(ck[i].getValue() + " de altura <p>De resultado como Area fue: </p> ");
                    }

                    if (ck[i].getName().equals("resultadoArea")) {
                        out.print(ck[i].getValue() + "<p>De resultado como Perimetro fue: </p>");
                    }

                    if (ck[i].getName().equals("resultadoPerim")) {
                        out.print(ck[i].getValue() + "");
                    }

                }
            }
        %>

        <!-- Sesion  -->
        <% 
            HttpSession sesion = request.getSession(false);
            Enumeration e = sesion.getAttributeNames();
            if(e.hasMoreElements())
            {
                out.print("<p>Ultimo nombre registrado es </P> ");
                out.print(sesion.getAttribute("autor"));
            }
        %>
    </body>
</html>
