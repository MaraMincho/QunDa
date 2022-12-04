<%@ page import="model.Professor" %>
<%@ page import="model.ProfessorBoardList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jeongdaham
  Date: 2022/11/29
  Time: 2:31 AM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://fonts.googleapis.com/css?family=Gmarket+Sans+TTF&display=swap" rel="stylesheet"/>
  <link href="./css/main.css" rel="stylesheet"/>
  <title>Document</title></head>
<script>
  function printTime() {
    var clock = document.getElementById("clock");
    var now = new Date();
    var nowTime =
            now.getMonth()+"월 " +
            now.getDate()+"일 "+
            now.getHours() + "시" +
            now.getMinutes() + "분" + now.getSeconds();
    clock.innerHTML = nowTime;
    setTimeout("printTime()",1000);//재귀호출: 자기자신안에서 자기자신을 부르는것
                                   // setTimeout(“실행할함수”,시간)
  }

  window.onload = function() {                   // 페이지가 로딩되면 실행

    printTime();}

</script>


<%
  String SubName1 = "";
  String SubName2 = "";
  String time1 = "";
  String time2 ="";
  String RoomNum1 = "";
  String RoomNum2 = "";
  ArrayList<ProfessorBoardList> list1 = (ArrayList<ProfessorBoardList>) request.getAttribute("boardList");
  int list1_len = list1.size();
  if (list1_len > 0) {
    SubName1 = list1.get(0).getSubjectName();
    time1 = list1.get(0).getTime();
    RoomNum1 = list1.get(0).getRoomNum();

    if(list1_len > 1) {
      SubName2 = list1.get(1).getSubjectName();
      time2 = list1.get(1).getTime();
      RoomNum2 = list1.get(1).getRoomNum();
    }
  }
%>

<%
  String name = (String)request.getAttribute("name");
  String email = (String)request.getAttribute("email");
  String postion = (String) request.getAttribute("position");
%>


<body>
<div class="v1_29"><span class="v1_31">QanDa</span>
  <div class="v1_43"></div>
  <div class="v1_46"></div>
  <div class="v1_47"></div>
  <span class="v1_48">안녕하세요 <%=name%></span>
  <span class="v1_54"><%=SubName1%></span>
  <form name="Professor1Board" method="post" action="Room.do">
    <input type="hidden" name="email" value="<%=email%>">
    <input type="hidden" name="name" value="<%=name%>">
    <input type="hidden" name="position" value="<%=postion%>">
    <input type="hidden" name="Time" value="<%=time1%>">
    <input type="hidden" name="Roomnum" value="<%=RoomNum1%>">
    <input type="hidden" name="SubName" value="<%=SubName1%>">
    <input type="submit" class="v1_55" value="<%=time1%>">
  </form>

  <span class="v1_64"><%=SubName2%></span>
  <form name="Professor2Board" method="post" action="Room.do">
    <input type="hidden" name="email" value="<%=email%>">
    <input type="hidden" name="name" value="<%=name%>">
    <input type="hidden" name="position" value="<%=postion%>">
    <input type="hidden" name="Time" value="<%=time2%>">
    <input type="hidden" name="Roomnum" value="<%=RoomNum2%>">
    <input type="hidden" name="SubName" value="<%=SubName2%>">
    <input type="submit" class="v1_65" value="<%=time2%>">
  </form>

  <form method="post" action="ProfessorInsertBoard.jsp">
    <input type="hidden" name="email" value="<%=email%>">
    <input type="hidden" name="name" value="<%=name%>">
    <input type="hidden" name="position" value="<%=postion%>">
    <input type="submit" class="insertBoard" value="dleehd">
  </form>
  <span class="v1_51" id = "clock"></span>
  <div class="v1_68"></div>
  <div class="name"></div>
</div>
</body>