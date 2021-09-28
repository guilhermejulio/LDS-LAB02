<%@page import="com.crudjsjava.dao.UsuarioDao" %>
<jsp:useBean id="u" class="com.crudjsjava.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%

int i = UsuarioDao.updateUsuario(u);
response.sendRedirect("viewusuario.jsp");

%>