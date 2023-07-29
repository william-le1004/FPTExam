<%--
  Created by IntelliJ IDEA.
  User: huuth
  Date: 7/29/2023
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>News</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./styles/style.css">
</head>
<body>
<%--header--%>
<%@ include file="header.jsp" %>
<%--header--%>

<%--content--%>
<h2>Danh sách tin tức:</h2>
<h3>số lượng tin tức hiện có : ${amountOfNews}</h3>
<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Tiêu Đề</th>
        <th scope="col">Nội Dung</th>
        <th scope="col">Tác Giả</th>
        <th scope="col">Lượt Xem</th>
        <th scope="col">Ngày Tạo</th>
        <th scope="col">Xem chi tiết</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${newslist}" var="x">
        <tr>
            <td>${x.id}</td>
            <td>${x.title}</td>
            <td>${x.content}</td>
<%--            <td style="white-space: nowrap;white-space: nowrap;text-overflow: ellipsis;">${x.content}</td>--%>
            <td>${x.author}</td>
            <td>${x.view}</td>
            <td>${x.date_created}</td>
            <td><a href="${pageContext.request.contextPath}/detailnews.jsp">Xem chi tiết</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--content--%>

<%--footer--%>
<%@ include file="footer.jsp" %>
<%--footer--%>
</body>
</html>
