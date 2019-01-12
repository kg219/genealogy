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
<title>Family Tree</title>
<script id ="code">
if(window.goSamples) goSamples();
var $ = go.Graphobject.make;
myDiagram =
	$(go.Diagram, "myDiagramDiv" {
		intialAutoScale:go.Diagram.Uniform,
		intialContentAlignment: go.Spot.Center,
		"undoManager.isEnable" : true,
		nodeSelectionAdormentTemplate:
			$(go.Adorment , "Auto", {layerName:"Grid"}
			$(go.Shape, "Circle", {
				fill:red, stroke:null})
				$(go.Placeholder)),
				layout:
					$(genogramLayout,{direction :90, layerSpacing :30, columnSpacing:10 })
			});
			function attrFill(a){
				switch(a){
				case "A": return "green";
				case "B": return "orange";
				case "C": return "red";
				case "D": return "gold";
				case "E": return "pink";
				case "F": return "blue";
				case "G": return "brown";
				case "H": return "purple";
				case "I": return "grey";
				case "J": return "black";
				case "K": return "green";
				case "L": return "green";
				case "M": return "green";
				default: return "transparent";


				}
			}
var tlsq = go.Geometry.parse("F M1 1 l19 0 0 19 -19 0z");
var trsq = go.Geometry.parse("F M20 1 l19 0 0 19 -19 0z");
var brsq = go.Geometry.parse("F M20 20 l19 0 0 19 -19 0z");
var blsq = go.Geometry.parse("F M1 20 l19 0 0 19 -19 0z");
var slash = go.Geometry.parse("F M38 1 l40 0 40 2 2 40 0 40 0 38z");
function maleGeometry(a){
				switch(a){
				case "A": return tlsq;
				case "B": return tlsq;
				case "C": return tlsq;
				case "D": return trsq;
				case "E": return trsq;
				case "F": return trsq;
				case "G": return brsq;
				case "H": return brsq;
				case "I": return brsq;
				case "J": return blsq;
				case "K": return blsq;
				case "L": return blsq;
				case "M": return slash;
				default: return tlsq;


				}
			}
			myDiagram.nodeTemplateMap.add("M" , 
					$(go.Node, "Vertical",{
						locationSpot:go.Spot.Center, locationObjectName: "ICON"},$(go.Panel,{name:"ICON"},
								$(go.Shape,"Square", {width :40, height: 40, strokeWidth:2, fill:"white", portId:""
								},$(go.Panel, {
									itemTemplate: $(go.Shape{
										Stoke: null, stokeWidth: 0
									}, 
									new go.Binding("fill", "", attrFill),
									new go.Binding("geometry", "" , maleGeometry))
									),
									margin:1
								},
								new go.binding("itemArray" , "a"))
								),
								$(go.TextBlock,{textAlign: " center", maxSize: new go.Size(80,NaN)
								}
								new go.binding("text" , "n"))
								));
			
			myDiagram.nodeTemplateMap.add("LinkLabel", $(go.node, {selectable :false :width:1, height 1, fromEndSegmentLength :20}));
			myDiagram.linkTemplate = $(go.Link,{
				routing: go.Link.Orthogonal, curviness:15, layerName: "Background", selectable:false, fromSpot:go.Spot.Bottom, toSpot.Top},
				$(go.Shape,{ strokeWidth: 2}) );
			myDiagram.linkTemplateMap.add("Marrige", $(go.Link,{ selectable : false },
					$(go.Shape,{ stokeWidth:2, stoke: "blue"})));
			setupDiagram(myDiagram,[], 4);
			}
					
</script>

</head>
<body>

<nav class="navbar navbar navbar-inverse navbar-fixed fluid-top " style="margin-bottom:0px;" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="famTree">Home</a>
    </div>

    <ul class="nav navbar-nav navbar-right">
      <li><a href="settings"><span class="glyphicon glyphicon-user"></span>  Settings </a></li>
      <li><a href="add"><span class="glyphicon glyphicon-log-in"></span> Add Person</a></li>
      <li><a href="search"><span class="glyphicon glyphicon-log-in"></span> Search Person Ancestor/ Decendents</a></li>
      
      
    </ul>
  </div>
</nav> 

<center><h2>family Tree</h2></center>
<p>browse through your family tree </p>
<table align ="center" style = "margin:auto;" class ="table">

<tbody>
<ul>
      <c:forEach var ="person" items ="${person}">
     <li>
     <c:if test ="${person.key=='1'}">
     <li>${person.name }</li>
     </c:if>
     </li>
      </c:forEach>                              
</ul>
</tbody>
     </table>
     

</body>

</html>