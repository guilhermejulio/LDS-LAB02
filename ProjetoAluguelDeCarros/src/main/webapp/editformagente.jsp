<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Agente</title>
</head>
<body>

<%@page import="com.crudjspjava.bean.Agente, com.crudjspjava.dao.AgenteDao" %>

<% 
  String id = request.getParameter("id");
  Agente agente = AgenteDao.getRegistroById(Integer.parseInt(id));
%>

<h1>Editar Agente</h1>

<form action="editagente.jsp" method="post">
  <input type="hidden" name="id" value="<%= agente.getId()  %>"/>
  
  <table>
  
     <tr>
       <td>Nome: </td>
       <td><input type="text" name="nome" value="<%= agente.getNome() %>"/></td>
     </tr>
     <tr>
       <td>Password: </td>
       <td><input type="password" name="password" value="<%= agente.getPassword() %>"/></td>
     </tr>
     <tr>
       <td>E-mail: </td>
       <td><input type="email" name="email" value="<%= agente.getEmail() %>"/></td>
     </tr>
     <tr>
       <td>Endereco: </td>
       <td><input type="text" name="endereco" value="<%= agente.getEndereco() %>"/></td>
     </tr>
     <tr>
       <td>CPF: </td>
       <td><input type="number" name="cpf" value="<%= agente.getCpf() %>"/></td>
     </tr>
     <tr>
       <td>RG: </td>
       <td><input type="text" name="rg" value="<%= agente.getRg() %>"/></td>
     </tr>
     <tr>
     <td>Tipo: </td>
     <td><input type="radio" name="tipo" value="agente"/> Agente
     </td>
     </tr>
     <tr>
        <td colspan="2">
        <input type="submit" value="Editar Agente"></input>
        </td>
     </tr>
  
  </table>
</form>

</body>
</html>