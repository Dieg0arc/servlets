<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/05/2024
  Time: 10:15 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<Context>
    <Resource name="jdbc/mysqlDB" auth="Container" type="javax.sql.DataSource"
              maxTotal="100" maxIdle="30" maxWaitMillis="10000"
              username="root" password="admin"
              driverClassName="com.mysql.cj.jdbc.Driver"
              url="jdbc:mysql://localhost:3306/proyectonotas"/>
</Context>
</body>
</html>
