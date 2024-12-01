<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addok" method="post">
    <table>
        <tr><td>Title:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Writer:</td><td><input type="text" name="author"/></td></tr>
        <tr><td>Date:</td><td><input type="text" name="date"></td></tr>
        <tr><td><button type="button" onclick="location.href='list'">View All Records</button></td>
            <td align="right"><button type="submit">Add Post</button></td></tr>
    </table>
</form>

</body>
</html>