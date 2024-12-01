<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Post</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <h2>Edit Post</h2>
    <%--@elvariable id="boardVO" type=""--%>
    <form:form modelAttribute="boardVO" method="post" action="../editok">
        <form:hidden path="seq"/> <!-- 게시물 ID를 숨겨진 필드로 추가 -->


        <div class="mb-3">
            <label for="name" class="form-label">Book name</label>
            <form:input type="text" class="form-control" id="name" path="name"/>
        </div>

        <div class="mb-3">
            <label for="author" class="form-label">Author</label>
            <form:input type="text" class="form-control" id="author" path="author" />
        </div>

        <div class="mb-3">
            <label for="date" class="form-label">Date</label>
            <form:textarea class="form-control" id="date" path="date" rows="5" />
        </div>

        <div class="d-flex justify-content-between">
            <a href="../list" class="btn btn-secondary">Back to List</a>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
