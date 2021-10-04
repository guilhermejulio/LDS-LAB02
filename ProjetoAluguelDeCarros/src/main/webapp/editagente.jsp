<%@page import="com.crudjspjava.dao.AgenteDao" %>
<jsp:useBean id="u" class="com.crudjspjava.bean.Agente"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%

int i = AgenteDao.updateAgente(u);
response.sendRedirect("viewusuarios.jsp");

%>