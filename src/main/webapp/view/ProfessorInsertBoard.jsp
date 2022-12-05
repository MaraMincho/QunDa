
<%@ page import="model.ProfessorBoardList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<script>
    function CheckBoardList() {
        var f = document.SubjectBoard;
        if (f.SubjectName.value === "") {
            alert("과목명을 입력하세요")
        }
        else if (f.Time.value === "") {
            alert("시간을 입력하세요")
        }
        else if (f.RoomNum.value === "") {
            alert("방 번호를 입력하세요")
        }
        else {
            f.submit();
        }
    }
</script>

<%
    String name = request.getParameter("name").toString();
    String email = request.getParameter("email").toString();
    String postion = request.getParameter("position").toString();



%>



<head>
    <link href="https://fonts.googleapis.com/css?family=Gmarket+Sans+TTF&display=swap" rel="stylesheet"/>
    <link href="./css/main.css" rel="stylesheet"/>
    <title>Document</title></head>
<body>
<h1><%=email%></h1>
<div class="v91_2">
    <span class="v91_3">QanDa</span>
    <div class="v91_4"></div>
    <div class="v91_5"></div>
    <div class="v91_6"></div>
    <span class="v91_21">과목 추가</span>
    <form name= "SubjectBoard" action="insertBoard.do">
        <input type="hidden" name="name" value="<%=name%>">
        <input type="hidden" name="position" value="<%=postion%>">
        <input type="hidden" name="email" value="<%=email%>">
        <span class="v91_8"> 과목 명</span>
        <span class="v91_15">시간 </span>
        <span class="v91_16"> 방번호 </span>
        <input name="InsertBoard" onclick="CheckBoardList()" class="v91_161" value="insert">
        <input class="v91_20" type="text" name="SubjectName">
        <input class="v91_18" type="text" name="Time">
        <input class="v91_19" type="number" name="RoomNum">
    </form>

    <div class="v91_13"></div>
    <div class="name"></div>
</div>
</body>
</html>