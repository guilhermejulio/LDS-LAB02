<%@page import="com.crudjspjava.dao.CarroDao"%>
<jsp:useBean id="u" class="com.crudjspjava.bean.Carro"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%

CarroDao.deletarCarro(u);
response.sendRedirect("viewusuarios.jsp");

%>