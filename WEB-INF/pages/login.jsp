<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
<style>
	.button:hover {
	color:white;
	background-color: 3399FF;
	}
</style>
</head>
<body style="background-color:lightpink;">
<TD><BR></BR></TD>
<TD><BR></BR></TD>

<div align="center" >
	<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
		<TR VALIGN=TOP style="color:blue;" >
			<TH colspan="2" style = "font-size:17px; font-variant:small-caps; background-color:yellow; text-align:center;"> Welcome To Pet Clinic</TH>
		</TR>
	</TABLE>

	<TR><BR>    </BR></TR>
	<p style="color:330033;font-weight:bold;">LOGIN </p>

<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc" style="color:black;">
<form:form method="POST" commandName="emp" action="authEmp" >
	<TR>
			<td> Username:</td>
			<td><form:input path="username" /></td>
			<td><form:errors path="username" /></td>
	</TR>
	<TR>
			<td> Password:</td>
			<td><form:input type="password" path="password" /></td>
			<td><form:errors path="password" /></td>
	</TR>
</TABLE>

<TABLE WIDTH=20% BORDER=0 BORDERCOLOR="#aabbcc" style="color:black;">
	<TR>
		<td colspan="1" style="text-align:right;"> <input style="background-color:0099ff;color:white;font-weight:bold; width:80px;height:25px;" class="button" type="submit" value="Login"/></td>
</form:form>

<form:form  commandName="emp" action="" >
		<td colspan="1" style="text-align:right;width:20%;"> <input style="background-color:0099ff;color:white; font-weight:bold;width:80px;height:25px;" class="button" type="submit" value="Reset"/></td>
	</TR>
</form:form>

</TABLE>

</div>
</body>
</html>