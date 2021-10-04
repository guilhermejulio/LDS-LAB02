<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="com.crudjspjava.dao.UsuarioDao, com.crudjspjava.bean.*, com.crudjspjava.dao.AgenteDao, com.crudjspjava.dao.CarroDao, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
List<Carro> list = CarroDao.getAllUsuarios();
request.setAttribute("list", list);

List<Usuario> list1 = UsuarioDao.getAllUsuarios();
request.setAttribute("list1", list1);
%>

<h1>Carros Cadastrados</h1>

<table border="1">

     <tr>
     
     <th>Matricula Carro</th>
     <th>Ano Carro</th>
     <th>Marca Carro</th>
     <th>Modelo Carro</th>
     <th>Placa Carro</th>
     <th>Propriedade</th>
     <th>Excluir</th>
                    
     <c:forEach items="${list}" var="carro">
        <tr>
        
        <td>${carro.getMatricula()}</td>
        <td>${carro.getAno()}</td>
        <td>${carro.getMarca()}</td>
        <td>${carro.getModelo()}</td>
        <td>${carro.getPlaca()}</td>
        <td>${carro.getPropriedade()}</td>      
        <td><a href="deletecarro.jsp?id=${carro.getId()}">Excluir</a></td>
     
        </tr>
     </c:forEach>
           
     </tr>
     
</table>

<a href="viewusuarios.jsp">Voltar página principal</a>


</body>
</html>