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
<title>search</title>
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
<form action="/#" method = "POST">
<center><h2>Search</h2></center>
<p>type in the key below to find out the ancestors/decendants </p>
<div style ="text-align:center;"><input type ="text" name ="search" id ="search" placeholder="enter here ..."/>
  <input type="submit" value="go" id="submit" class="btn btn-success"/></div>   
</form>
</body>

</html>