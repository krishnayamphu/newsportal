<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>NewsPortal | Politics</title>
    <link rel="stylesheet" href="http://localhost:8080/newsportal/dist/css/adminlte.min.css">
</head>
<body>
<header>
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item d-none d-sm-inline-block">
                <a href="/" class="nav-link">Home</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Politics</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Life Sytle</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Sports</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Entertainment</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Contact</a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->
</header>

<main>
    <div class="container">
        <div class="row row-cols-2 row-cols-lg-4">
       <c:forEach var="post" items="${posts}">
           <div class="card">
               <div class="card-body">
                   <h3><a href="${pageContext.request.contextPath}/single?id=${post.id}">${post.title}</a></h3>
                   <img src="${pageContext.request.contextPath}/uploads/${post.image}" alt="${post.image}">
               </div>
           </div>
       </c:forEach>
        </div>
    </div>
</main>
</body>
</html>
