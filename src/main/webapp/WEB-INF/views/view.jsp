<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 상세보기</title>

</head>
<body>
<h1>게시물 상세보기</h1>

    <p><strong>Book name: </strong> ${u.name}</p>
    <p><strong>Author: </strong> ${u.author}</p>
    <p><strong>Date: </strong>${u.date}</p>


<br/>
<button onclick="location.href='../list'">목록으로 돌아가기</button>
</body>
</html>
