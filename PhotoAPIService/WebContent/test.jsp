<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/MasDok">
SELECT username,email,language, inserttime FROM masoud
</sql:query>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>
<center>
  <h2>Results</h2>
<table>

<tr>
    <th><b>No</th>
    <th><b>username</th>
    <th><b>email</th>   
    <th><b>language</th>
    <th><b>inserttime</th>   
  </tr>
  
<c:forEach var="row" items="${rs.rows}">
    <tr><td>${row.username}</td>
    <td> ${row.email}</td>
	 <td> ${row.language}</td>
	<td>   ${row.inserttime}</td>
</tr>
</c:forEach>
</table>
</center>
  </body>
</html>