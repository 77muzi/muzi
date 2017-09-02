<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.css">
<script src="../resources/js/jquery-2.1.0.js"></script>
<script src="../resources/bootstrap/js/bootstrap.js"></script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>SSH Framework</title>
</head>
<script type="text/javascript" src="../resources/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
    $(function () {
        $("#userName").blur(function () {
           var userName= $(this).val();
           $.ajax({
               type:"post",
               url:"/user/checkName.action",
               data:{"userName":userName},
               dataType:"text",
               success:function (data) {
                   if(data=="true"){
                      $("#s1").html("用户名已存在");
                   }
               }
           });

        });
    });
</script>
<body>
<div class="page-header">
    <h1>注册页面</h1>
</div>
<form class="form-horizontal" role="form" action="/user/addUser.action" method="post">
    <div class="form-group">
        <label for="userName" class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入姓名"><span id="s1"></span>
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-3">
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
        </div>
    </div>
    <div class="form-group" >
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">注册</button>
        </div>
    </div>
</form>

</body>
</html>
