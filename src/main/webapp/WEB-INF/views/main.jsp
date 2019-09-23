<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#add").click(function(){
		var option = new Object();
		option.url = "/insert"; 
		option.type = "POST";
		option.param = $("#result").serialize();
		getAjaxHtml(option);
	});
});

function getAjaxHtml(obj){
	$.ajax({
		url:obj.url,
		type:obj.type,
		data:obj.param,
		beforeSend : function() {
			loading();
		},
		error: function(e){
			loading(true); 
			console.log(e);
		},
		complete : function() {
			loading(true);
		}
	}).done(
		function(data) {			
			loading(true);
		}
	);
}
</script>

</head>
<body>
<form id="result" name="result">
	<input type="text" id="id" name="id" />
	<input type="text" id="name" name="name" />
	<button id="add">+</button>
</form>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
    </tr>
  </thead>
  <tbody>
  	<tr>
      <th scope="row">9</th>
      <td>jhon</td>
    </tr>
    <c:forEach var="todo" items="${list}">
	    <tr>
	      <th scope="row">${todo.id }</th>
	      <td>${todo.name }</td>
	      <td>${todo.address }</td>
	    </tr>
	</c:forEach>
  </tbody>
</table>
</body>
</html>