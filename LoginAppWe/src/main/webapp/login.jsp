<%@ page import="com.login.dao.LoginDAO" %>
<%@ page language="java" contentType="text/plain; charset=UTF-8" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    LoginDAO dao = new LoginDAO();
    boolean status = dao.checkLogin(username, password);

    if(status){
        out.print("success");
    } else {
        out.print("fail");
    }
%>
