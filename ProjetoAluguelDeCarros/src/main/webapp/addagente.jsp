<%@page import="com.crudjspjava.dao.AgenteDao"  %>
<jsp:useBean id="u" class="com.crudjspjava.bean.Agente"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%

int i = AgenteDao.salvarAgente(u);

if(i > 0) {
	response.sendRedirect("addagente-succes.jsp");
} else {
	response.sendRedirect("addagente-error.jsp");
}

%>