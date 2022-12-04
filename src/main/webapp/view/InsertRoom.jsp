<%--
  Created by IntelliJ IDEA.
  User: jeongdaham
  Date: 2022/12/03
  Time: 3:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String postion = request.getParameter("position");

    String Time = request.getParameter("Time");
    String Roomnum = request.getParameter("Roomnum");
    String SubName = request.getParameter("SubName");
%>
<head>
    <link href="https://fonts.googleapis.com/css?family=Gmarket+Sans+TTF&display=swap" rel="stylesheet"/>
    <link href="./css/main.css" rel="stylesheet"/>
    <title>Document</title></head>
<body>
<div class="v1_248"><span class="v1_249">QanDa</span>
    <div class="v1_250"></div>
    <div class="v1_251"></div>
    <div class="v1_252"></div>
    <span class="v1_253"><%=SubName%></span>
    <span class="v1_254"><%=Roomnum%></span>
    <form method="post" action="InsertRoom.do">
        <input type="submit" class="v1_255" value="글쓰기">
        <input type="hidden" name="email" value="<%=email%>">
        <input type="hidden" name="name" value="<%=name%>">
        <input type="hidden" name="position" value="<%=postion%>">
        <input type="hidden" name="Time" value="<%=Time%>">
        <input type="hidden" name="Roomnum" value="<%=Roomnum%>">
        <input type="hidden" name="SubName" value="<%=SubName%>">
        <input type="text" class="v1_256" name="body" value="">
        <span class="v1_270"></span>
    <div class="v1_260"></div>
    <div class="name"></div>
    <span class="v1_267">방번호 : 20221113</span>
    <div class="v1_268"></div>


</div>
</body>
</html>