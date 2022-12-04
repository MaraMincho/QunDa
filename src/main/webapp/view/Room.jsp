<%@ page import="model.Room" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jeongdaham
  Date: 2022/12/03
  Time: 2:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://fonts.googleapis.com/css?family=Gmarket+Sans+TTF&display=swap" rel="stylesheet"/>
  <link href="./css/main.css" rel="stylesheet"/>
  <title>Document</title></head>

<%
  String name = (String)request.getAttribute("name");
  String email = (String)request.getAttribute("email");
  String postion = (String) request.getAttribute("position");

  String Time = request.getParameter("Time").toString();
  String Roomnum = request.getParameter("Roomnum");
  String SubName = request.getParameter("SubName").toString();

  String Ask1 ="";
  String Ask2 ="";
  String Ask3 ="";
  String Ask4 ="";
  String Ask5 ="";

  ArrayList<Room> list1 = (ArrayList<Room>) request.getAttribute("list");
  int list1_len = list1.size();
  if (list1_len > 0) {
    Ask1 = list1.get(0).getBody();
    if(list1_len > 1) {
      Ask2 = list1.get(1).getBody();
      if(list1_len > 2) {
        Ask3 = list1.get(2).getBody();
        if (list1_len>3){
          Ask4 = list1.get(3).getBody();
        }
      }
    }
  }
%>

<body>
<div class="v1_70"><span class="v1_71">QanDa</span>
  <div class="v1_72"></div>
  <div class="v1_73"></div>
  <div class="v1_74"></div>
  <span class="v1_76"><%=Roomnum%>방번호임</span>
  <span class="v1_77"><%=Time%>ㅅㅣ간임</span>
  <span class="v1_165"><%=SubName%>방번호 : <%=Roomnum %></span>
  <span class="v1_78"><%=Ask1%></span>
  <span class="v1_90"><%=Ask2%></span>
  <span class="v1_92"><%=Ask3%></span>
  <span class="v1_94"><%=Ask4%></span>

  <div class="v1_81"></div>
  <div class="name"></div>
  <div class="v1_86"></div>
  <div class="v1_91"></div>
  <div class="v1_93"></div>
  <div class="v1_95"></div>
  <div class="v1_157">
    <div class="v1_154"></div>
    <div class="v1_155"></div>
    <div class="v1_156"></div>
  </div>
  <form method="post" action="InsertRoom.jsp">
    <input type="submit" class="v1_163" value="글쓰기">
    <input type="hidden" name="email" value="<%=email%>">
    <input type="hidden" name="name" value="<%=name%>">
    <input type="hidden" name="position" value="<%=postion%>">
    <input type="hidden" name="Time" value="<%=Time%>">
    <input type="hidden" name="Roomnum" value="<%=Roomnum%>">
    <input type="hidden" name="SubName" value="<%=SubName%>">

  </form>
  <div class="v11_91"></div>
</div>
</body>
</html>