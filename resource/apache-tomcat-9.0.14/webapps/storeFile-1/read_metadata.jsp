<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/MasDok">


SELECT  @rownum := @rownum + 1 AS no,t.name,t.time_inserted,t.personnummer,t.skadenummer,t.policy_number,t.varumarke,t.customerid  FROM mm_document t , (SELECT @rownum := 0) t

</sql:query>

<html>
  <head>
    <title>Maetadata</title>
  </head>
  <body>
<center>
  <h2>Metdata</h2>



<table "border=1">
 <tr>
    <th>No</th>
    <th>name</th>
    <th>time_inserted</th>   
    <th>personnummer</th>
    <th>skadenummer</th> 
    <th>policy_number</th>    
    <th>varumarke </th>
    <th>customerid</th>    
  </tr>
<c:forEach var="row" items="${rs.rows}">
<tr>
   <td>${row.no}</td> 
   <td>  ${row.name}</td>
	<td>  ${row.time_inserted}</td>
	 <td> ${row.personnummer}</td>
	 <td> ${row.skadenummer}</td>
	 <td> ${row.policy_number}</td>
	<td>  ${row.varumarke}</td>
	<td>  ${row.customerid}</td>
	</tr>
</c:forEach>

</table>
</center>
  </body>
</html>