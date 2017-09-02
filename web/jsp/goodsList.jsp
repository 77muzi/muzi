<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/30
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.css">
<script src="../resources/js/jquery-2.1.0.js"></script>
<script src="../resources/bootstrap/js/bootstrap.js"></script>
<html>
<head>
    <title>商品列表</title>
</head>
<script type="text/javascript" src="../resources/js/angular-1.0.1.min.js"></script>
<script type="text/javascript">
    var app=angular.module('myApp',[]);
    app.controller('myCtrl',function ($scope, $http) {
        $http({
            method:"get",
            url:"/goods/queryAllGoods.action",
        }).then(function successCallback(response) {
            $scope.goods=response.data;
        });

        //加
       $scope.add=function (id) {
           $http({
              method:"post",
              url:"/goods/addAccount.action?id="+id+"",
           }).then(function successCallback(response) {
               $scope.goods=response.data;
           });
       };

       //删除
       $scope.del=function (id) {
           $http({
               method:"post",
               url:"/goods/deleteGoods.action?id="+id+"",
           }).then(function successCallback(response) {
               $scope.goods=response.data;
           });
       };


       //减
       $scope.reduce=function (id, account) {
         if(account==1){
             var flag=confirm("确定要删除吗");
             if(flag==true){
                 $scope.del(id);
             }
         }else{
             $http({
                 method:"post",
                 url:"/goods/reduceAccount.action?id="+id+"&account="+account+"",
             }).then(function successCallback(response) {
                 $scope.goods=response.data;
             });
         }
       }
    });
</script>

<script type="text/javascript" src="../resources/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
   $(function () {
       $("#add").click(function () {
          var obj= $("input[name='ids']:checked");
          var arr_ids=[];
          for(k in obj){
              if(obj[k].checked){
                  arr_ids.push(obj[k].value);
              }
          }
          alert(arr_ids);
          if(arr_ids.length==0){
              alert("请选择要结算的商品");
          }else{
              $.ajax({
                  type:"post",
                  url:"/order/addOrder.action",
                  data:{"ids":arr_ids.join(",")},
                  dataType:"text",
                  success:function (data) {
                      if(data=="true"){
                          alert("添加成功");
                      }else{
                          alert("添加失败");
                      }
                  },
                  error:function () {
                      alert("系统异常");
                  }
              })
          }
       });
   });
</script>
<body class="container" ng-app="myApp" ng-controller="myCtrl">
<div class="page-header">
   <h1>商品列表</h1>
</div>

<div >
    <table class="table table-bordered table-hover table-striped table-condensed" style="text-align: center">
        <thead>
        <tr>
            <td><input type="checkbox" ng-model="all"/></td>
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
            <td>数量</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
          <tr ng-repeat="x in goods">
              <td><input type="checkbox" name="ids" ng-checked="all" id="ids" value="{{x.id}}" /></td>
              <td>{{x.id}}</td>
              <td>{{x.goodsName}}</td>
              <td>{{x.price}}</td>
              <td>
                  <button class="btn btn-info btn-sm" ng-click="add(x.id)">+</button>
                  {{x.account}}
                  <button class="btn btn-info btn-sm" ng-click="reduce(x.id,x.account)">-</button>
              </td>
              <td><button class="btn btn-danger" ng-click="del(x.id)">删除</button></td>
          </tr>
        </tbody>
        <tfoot>
           <button class="btn btn-default" id="add">添加订单</button>
        </tfoot>
    </table>

</div>
</body>
</html>
