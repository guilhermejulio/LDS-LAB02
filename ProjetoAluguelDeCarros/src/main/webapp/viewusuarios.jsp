<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualização de Usuários</title>
</head>
<body>

<%@ page import="com.crudjspjava.dao.UsuarioDao, com.crudjspjava.bean.*, com.crudjspjava.dao.AgenteDao, com.crudjspjava.dao.CarroDao, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Listagem de Usuários</h1>

<%
List<Usuario> list = UsuarioDao.getAllUsuarios();
request.setAttribute("list", list);

List<Agente> list1 = AgenteDao.getAllUsuarios();
request.setAttribute("list1", list1);

%>

<h1>Usuários</h1>

<table border="1">

     <tr>
     
     <th>ID</th>
     <th>Nome</th>
     <th>Password</th>
     <th>E-mail</th>
     <th>Endereco</th>
     <th>CPF</th>
     <th>RG</th>
     <th>Tipo</th>
     <th>Editar</th>
     <th>Excluir</th>
     <th>Carros</th>
                    
     <c:forEach items="${list}" var="usuario">
        <tr>
        
        <td>${usuario.getId()}</td>
        <td>${usuario.getNome()}</td>
        <td>${usuario.getPassword()}</td>
        <td>${usuario.getEmail()}</td>
        <td>${usuario.getEndereco()}</td>
        <td>${usuario.getCpf()}</td>
        <td>${usuario.getRg()}</td>
        <td>${usuario.getTipo()}</td>
        <td><a href="editform.jsp?id=${usuario.getId()}">Editar</a></td>
        <td><a href="deleteusuario.jsp?id=${usuario.getId()}">Excluir</a></td>
        <td><a href="carroform.html">Carros</a></td>
     
        </tr>
     </c:forEach>
           
     </tr>
     
</table>

<h1>Agentes</h1>

<table border="1">

<tr>

     <th>ID</th>
     <th>Nome</th>
     <th>Password</th>
     <th>E-mail</th>
     <th>Endereco</th>
     <th>CPF</th>
     <th>RG</th>
     <th>Tipo</th>
     <th>Editar</th>
     <th>Excluir</th>
     <th>Verificar</th>
     
     <c:forEach items="${list1}" var="agente">
        <tr>
        
        <td>${agente.getId()}</td>
        <td>${agente.getNome()}</td>
        <td>${agente.getPassword()}</td>
        <td>${agente.getEmail()}</td>
        <td>${agente.getEndereco()}</td>
        <td>${agente.getCpf()}</td>
        <td>${agente.getRg()}</td>
        <td>${agente.getTipo()}</td>
        <td><a href="editformagente.jsp?id=${agente.getId()}">Editar</a></td>
        <td><a href="deleteagente.jsp?id=${agente.getId()}">Excluir</a></td>
        <td><a href="viewcarros.jsp">Verificar</a></td>
     
        </tr>
     </c:forEach>
     
     </tr>


</table>

<br>

<br>

<a href="addform.jsp">Adicionar novo Usuário</a>
<a href="addformagente.jsp">Adicionar novo Agente</a>

</body>
</html>