<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Free Board</title>
    <style>
        #list {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        #list td, #list th {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        #list tr:nth-child(even) {background-color: #f2f2f2;}
        #list tr:hover {background-color: #ddd;}
        #list th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #006bb3;
            color: white;
        }
    </style>
    <script>
        function delete_ok(id) {
            var a = confirm("정말로 삭제하겠습니까?");
            if (a) {
                location.href = 'deleteok/' + id;
            }
        }
    </script>
</head>
<body>
<h1>자유게시판</h1>

<!-- 검색 폼 추가 -->
<form action="search" method="get" class="mb-3">
    <input type="text" name="query" placeholder="검색어를 입력하세요" required>
    <button type="submit">검색</button>
</form>

<table id="list" width="90%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Author</th>
        <th>Date</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>View</th>
    </tr>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.seq}</td>
            <td>${u.name}</td>
            <td>${u.author}</td>
            <td>${u.date}</td>
            <td><a href="edit/${u.seq}">Edit</a></td>
            <td><a href="javascript:delete_ok(${u.seq})">Delete</a></td>
            <td><a href="view/${u.seq}">View</a></td>
        </tr>
    </c:forEach>
</table>

<br/><button type="button" onclick="location.href='add'">Add New Post</button>
</body>
</html>
