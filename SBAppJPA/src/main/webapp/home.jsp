<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5>Add Alient Data</h5>
	<form action="addAlien">
		Id: <input type="text" name="aid" /><br/>
		Name <input type="text" name="aname"/><br /> 
		Tech <input type="text" name="tech"/><br /> 
		<input type="submit" "/>
	</form>
	
	<h5>Update Alient Data</h5>
	<form action="updateAlien">
		Id: <input type="text" name="aid" /><br/>
		Name <input type="text" name="aname"/><br /> 
		Tech <input type="text" name="tech"/><br /> 
		<input type="submit" "/>
	</form>

	<h5>Delete Alient Data</h5>
	<form action="deleteAlien">
		Id: <input type="text" name="aid" /><br/>
		<input type="submit" "/>
	</form>

	<h5>Show Alient Data</h5>
	<form action="showAlien">
		Id: <input type="text" name="aid" /><br/>
		<input type="submit" "/>
	</form>

	<h5>Show Alient Data by Name</h5>
	<form action="showAlientsByName">
		Name: <input type="text" name="name" /><br/>
		<input type="submit" "/>
	</form>

	<h5>Show Alient Data by Tech</h5>
	<form action="showAlientsByTech">
		Tech: <input type="text" name="tech" /><br/>
		<input type="submit" "/>
	</form>
	
	<h5>Show Alient Data by Tech order by aname</h5>
	<form action="showAlientsQury">
		Tech: <input type="text" name="tech" /><br/>
		<input type="submit" "/>
	</form>
	
</body>
</html>