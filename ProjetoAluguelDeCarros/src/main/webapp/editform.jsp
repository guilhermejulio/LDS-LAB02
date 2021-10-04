<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Usuário</title>
</head>
<body>

<%@page import="com.crudjspjava.bean.Usuario, com.crudjspjava.dao.UsuarioDao" %>

<% 
  String id = request.getParameter("id");
  Usuario usuario = UsuarioDao.getRegistroById(Integer.parseInt(id));
%>

<h1>Editar Usuário</h1>

<form action="editusuario.jsp" method="post">
  <input type="hidden" name="id" value="<%= usuario.getId()  %>"/>
  
  <table>
  
     <tr>
       <td>Nome: </td>
       <td><input type="text" name="nome" value="<%= usuario.getNome() %>"/></td>
     </tr>
     <tr>
       <td>Password: </td>
       <td><input type="password" name="password" value="<%= usuario.getPassword() %>"/></td>
     </tr>
     <tr>
       <td>E-mail: </td>
       <td><input type="email" name="email" value="<%= usuario.getEmail() %>"/></td>
     </tr>
     <tr>
       <td>Endereco: </td>
       <td><input type="text" name="endereco" value="<%= usuario.getEndereco() %>"/></td>
     </tr>
     <tr>
       <td>CPF: </td>
       <td><input type="number" name="cpf" value="<%= usuario.getCpf() %>"/></td>
     </tr>
     <tr>
       <td>RG: </td>
       <td><input type="text" name="rg" value="<%= usuario.getRg() %>"/></td>
     </tr>
     <tr>
     <td>Tipo: </td>
     <td><input type="radio" name="tipo" value="usuario"/> Usuário
     </td>
     </tr>
     <tr>
        <td colspan="2">
        <input type="submit" value="Editar Usuário"></input>
        </td>
     </tr>
  
  </table>
</form>

</body>
</html>