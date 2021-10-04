<%@page import="com.crudjspjava.dao.CarroDao"  %>
<jsp:useBean id="u" class="com.crudjspjava.bean.Carro"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%

int i = CarroDao.salvarCarro(u);

if(i > 0) {
	response.sendRedirect("addcarro-succes.jsp");
} else {
	response.sendRedirect("addcarro-error.jsp");
}

%>

