<%--
  Created by IntelliJ IDEA.
  User: jeongdaham
  Date: 2022/11/30
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<script>
    function button1_click() {
        alert("버튼")
    }
    function formChk(){
        var f = document.SignupForm
        if(f.name.value === ""){
            alert("이름을 입력하세요");
        }else if(f.password1.value === "") {
            alert("password를 입력하세요")
        }
        else if(f.password1.value !== f.password2.value){
            alert("password를 잘못 입력하셨습니다.");
        }else{
            f.submit();
        }
    }
</script>

<html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Gmarket+Sans+TTF&display=swap" rel="stylesheet"/>
    <link href="./css/main.css" rel="stylesheet"/>
    <title>Document</title>
</head>
<body>
<div class="v11_2">
    <div class="v11_3"></div>
    <span class="v11_4">QanDa</span>
    <div class="v11_8"></div>
    <div class="v11_9"></div>
    <div class="v11_26"></div>
    <div class="v11_10"></div>

    <form name="SignupForm" action="signup.do" method="post" >
        <input type="text" class="v11_12" name="name" value="키에와">
        <input type="email" class="v11_63" name="email" value="eamli">
        <input type="password" class="v11_13" name="password1" value="">
        <input type="password" class="v11_27" name="password2" value="">
        <input type="text" class="postion" name="position" value="position">
        <input class="v11_15" type="button" onclick="formChk()" value="회원가입">
    </form>
    <div class="v11_62"></div>
    <input type="button" id="button1" onclick="button1_click();" value="버튼1" />
</div>
</body>
</html>
