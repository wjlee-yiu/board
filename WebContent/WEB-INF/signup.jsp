<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SignUp</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
        .container {
            width: 500px;
            margin: 40px auto;
            line-height: 16px;
        }
        h5 {
            text-align: center;
        }
        h5 span {
            color: teal;
        }
        .n {
            font-size: 13px;
        }
        #signup {
            background-color: rgb(255, 80, 90);
            color: white;
            border: 0;
            border-radius: 5px;
            padding: 10px 224px;
        }
        .bottom input {
            background-color: white;
            border: 0;
            color: teal;
            font-size: 16px;
        }
        i {
            color: lightgray;
        }
        #imail {
            position: absolute;
            top: 110px;
            margin: 0 470px;
        }
        #iperson1 {
            position: absolute;
            top: 160px;
            margin: 0 470px;
        }
        #iperson2 {
            position: absolute;
            top: 210px;
            margin: 0 470px;
        }
        #ipw {
            position: absolute;
            top: 260px;
            margin: 0 470px;
        }
        input {
            border: 1px solid lightgray;
            border-radius: 3px;
        }
    </style>
</head>

<body>
    <div class="container">
        <div id="imail">
            <i class="material-icons">person_outline</i>
        </div>
        <div id="iperson1">
            <i class="material-icons">person_outline</i>
        </div>
        <div id="iperson2">
            <i class="material-icons">person_outline</i>
        </div>
        <div id="ipw">
            <i class="material-icons">lock_outline</i>
        </div>
        <h5><span>?????? ??????</span> ??????????????????.</h5>
        <hr /><br />
        <form action="join.do" method="post" >
            <input type="text" placeholder="?????????" name="id" required style="height:30px; width: 495px" /><br /><br />
            <input type="password" placeholder="????????????" name="pw" required style="height:30px; width: 495px" /><br /><br />
            <input type="email" placeholder="????????? ??????" name="email" required style="height:30px; width: 495px" /><br /><br />
            <input type="text" placeholder="??????" name="name" required style="height:30px; width: 495px" /><br />
            <p>
            <input type="submit" value="????????????" id="signup" /><br /><br />
            </p>
        </form>
        <hr />
    </div>
</body>
</html>