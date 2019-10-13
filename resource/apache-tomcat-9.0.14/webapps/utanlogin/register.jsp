<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<center>
<body>
    <form action="register" method="post">
       <table>
       <tr><td> Name: </td><td><input type="text" name="userName"/></td></tr>
        <tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
        <tr><td>Email Id:</td><td><input type="text" name="email" /></td></tr>
        <tr><td>Language: </td><td><select name="language">
            <option>Swedish</option>
            <option>English</option>
            <option>Spanish</option>
        </select></td></tr>
		</table>
        <input type="submit" value="Submit"/>
  
    </form>
</body>
</center>
</html>