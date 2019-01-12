<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="x-ua-compatible" content="ie=edge">
   
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Adding a person</title>
<script type ="text/javascript">
$(document).ready(function(){
	$("#key").keyup(function(){
		$ajax({
			type:"GET",
			url:"/pkeyAJAX?pkey =" +$("#key").val(),
			success: function(result){
				if(result == "taken"){
					$("#add").hide();
					$("#pkey").html("the Key(ID) selected has been taken,please choose another ");
				}
				if(result== "ok"){
					$("#add").hide();
					$("#pkey").html("OK");
					
				}
			}
		});
		
	});
	$("#FatherKey").keyup(function(){
		$ajax({
			type:"GET",
			url:"/mkeyAJAX?mkey =" +$("#motherKey").val() + "&fkey"=$("#fatherKey").val(),
			success: function(result){
				if(result == "dontExist"){
					$("#add").prop("disabled", true);
					$("#mname").html("MotherKey and FatherKey must both exisit ");
				}
				if(result == "noMother"){
					$("#add").prop("disabled", true);
					$("#mname").html("MotherKey must exisit ");
				}
				if(result == "noFather"){
					$("#add").prop("disabled", true);
					$("#mname").html("FatherKey must exisit ");
				}
			
				if(("#motherKey").val() == "0" && $("#fatherKey").val() == "0"){
					$("#add").prop("disabled", false);
					$("#mname").html("");
				}
				if(result== "OK"){
				if(("#fatherKey").val() == $("#motherKey").val()){
					$("#add").prop("disabled", true);
					$("#mname").html("mother and father key cannot be the same");
				}
				}
				if(result== "OK"){
					$("#add").prop("disabled", false);
					$("#mname").html("OK");
					
				}
			}
		});
		
	});
	$("#MotherKey").keyup(function(){
		$ajax({
			type:"GET",
			url:"/mkeyAJAX?mkey =" +$("#motherKey").val() + "&fkey"=$("#fatherKey").val(),
			success: function(result){
				if(result == "dontExist"){
					$("#add").prop("disabled", true);
					$("#mname").html("MotherKey and FatherKey must both exisit ");
				}
				if(result == "noMother"){
					$("#add").prop("disabled", true);
					$("#mname").html("MotherKey must exisit ");
				}
				if(result == "noFather"){
					$("#add").prop("disabled", true);
					$("#mname").html("FatherKey must exisit ");
				}
			
				if(("#motherKey").val() == "0" && $("#fatherKey").val() == "0"){
					$("#add").prop("disabled", false);
					$("#mname").html("");
				}
				if(result== "OK"){
				if(("#fatherKey").val() == $("#motherKey").val()){
					$("#add").prop("disabled", true);
					$("#mname").html("mother and father key cannot be the same");
				}
				}
				if(result== "OK"){
					$("#add").prop("disabled", false);
					$("#mname").html("OK");
					
				}
			}
		});
		
	});
	
}
</script>


<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
    
   <script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
   

</head>
<body>

<nav class="navbar navbar navbar-inverse navbar-fixed fluid-top " style="margin-bottom:0px;" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="tree">Home</a>
    </div>

    <ul class="nav navbar-nav navbar-right">
      <li><a href="settings"><span class="glyphicon glyphicon-user"></span>  Settings </a></li>
      <li><a href="add"><span class="glyphicon glyphicon-log-in"></span> Add Person</a></li>
      <li><a href="search"><span class="glyphicon glyphicon-log-in"></span> Search Person Ancestor/ Decendents</a></li>
      
      
    </ul>
  </div>
</nav> 

<form method= "POST" action="/FamilyTree/new">
		<div class = "table-responsive">
				<center><h2>adding a family member ?</h2></center>
<p>Please fill in this to add a family member </p>
<table align ="center" style = "margin:auto;">
<thead>
<tr>
<th> Key(ID)</th>
<th> Full name</th>
<th> Date of Birth (YYYYMMDD)</th>
<th>Mother Key</th>
<th> Father Key</th>
<th> Gender</th>
</tr>
</thead>
<tbody>
<tr>
<td><input type = "number" name ="key" required ="required" id="key"></td>
<td><input type = "text" name ="name" required ="required" id="name"></td>
<td><input type = "number" name ="dob" required ="required" id="dob"></td>
<td><input type = "number" name ="m" required ="required" id="MotherKey"></td>
<td><input type = "number" name ="f" required ="required" id="FatherKey"></td>
<td><input type = "text" name ="g" required ="required" id="gender"></td>
</tr>

</tbody>
     </table>
     </div>
     <div style ="text-align:center"><input type="submit" value="Add" id="add" class="btn btn-success"/></div>
</form>
<br><p id ="mname" align = "center"></p>
<br><p id ="pkey" align = "center"></p>

</body>

</html>