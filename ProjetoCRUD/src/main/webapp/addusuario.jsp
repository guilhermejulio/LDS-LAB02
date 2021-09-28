<%@page import="com.crudjsjava.dao.UsuarioDao"  %>
<jsp:useBean id="u" class="com.crudjsjava.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%

int i = UsuarioDao.salvarUsuario(u);

if(i > 0) {
	response.sendRedirect("addusuario-succes.jsp");
} else {
	response.sendRedirect("addusuario-error.jsp");
}

%>