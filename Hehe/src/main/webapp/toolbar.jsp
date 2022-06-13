
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<head>

<title>Toolbar with TextArea </title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="stylesheet" href="css/jquery.wysiwyg.css" type="text/css" />

<link rel="stylesheet" href="examples.css" type="text/css" />

 <script type="text/javascript" src="jquery/jquery-1.3.2.js"></script> 
<script type="text/javascript" src="jquery/jquery.wysiwyg.js"></script>


<script type="text/javascript">

$(function()

{

$('#wysiwyg').wysiwyg();

});

</script>

</head>

<body>

<h1>Toolbar with TextArea </h1>

<div>

<textarea name="wysiwyg" id="wysiwyg" rows="20" cols="100" ></textarea>

</div>

</body>

</html>