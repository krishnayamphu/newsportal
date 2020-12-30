<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>NewsPortal | Single</title>
    <link rel="stylesheet" href="http://localhost:8080/newsportal/dist/css/adminlte.min.css">
</head>
<body>
<header>
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item d-none d-sm-inline-block">
                <a href="${pageContext.request.contextPath}/home" class="nav-link">Home</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="${pageContext.request.contextPath}/politics" class="nav-link">Politics</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="${pageContext.request.contextPath}/life-style" class="nav-link">Life Sytle</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="${pageContext.request.contextPath}/sports" class="nav-link">Sports</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="${pageContext.request.contextPath}/entertainment" class="nav-link">Entertainment</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="${pageContext.request.contextPath}/contact" class="nav-link">Contact</a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->
</header>

<main>
    <div class="container">
           <div class="card mt-5">
               <div class="card-body">
                   <h3>${post.title}</h3>
                   <img src="${pageContext.request.contextPath}/uploads/${post.image}" alt="${post.image}">
                   <p>${post.text}</p>
               </div>
           </div>
    </div>
</main>


</body>
</html>
