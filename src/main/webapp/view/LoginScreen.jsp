<%@ page import="jakarta.servlet.annotation.WebServlet" %>
<%@ page import="javax.swing.text.Document" %>
<%@ page import="java.sql.JDBCType" %><%--
  Created by IntelliJ IDEA.
  User: jeongdaham
  Date: 2022/11/29
  Time: 2:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<script>

</script>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Gmarket+Sans+TTF&display=swap" rel="stylesheet"/>
    <link href="./css/main.css" rel="stylesheet"/>
    <title>Document</title></head>
<body>
<div class="v1_2">
    <div class="v1_25"></div>
    <form method="post" action="signup.jsp">
        <input type="submit" class="v1_3" value="QanDa" >
    </form>
    <div class="v1_20"></div>
    <div class="v1_19"></div>
    <div class="v1_18"></div>
    <div class="v1_17"></div>
    <div class="v1_16"></div>
    <div class="v1_13"></div>
    <div class="name"></div>

    <form action="login.do" method="post" >
        <input class="v1_27" type="text" name="email" >
        <input class="v1_28" type="password" name="pw">
        <input class="v1_41" type="submit" value="로그인">
    </form>
</div>
</body>
</html>



<%!
   public void open() {
       try {
           Class.forName("org.h2");

       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }
%>