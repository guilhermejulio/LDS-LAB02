<%@page import="com.crudjsjava.dao.UsuarioDao"%>
<jsp:useBean id="u" class="com.crudjsjava.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%

UsuarioDao.deletarUsuario(u);
response.sendRedirect("viewusuario.jsp");

%>