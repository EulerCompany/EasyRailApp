<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>EasyRail — кошик</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/fonts/ionicons.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/empty_cart_style.css">
</head>

<body class="text-dark">
  <!-- header -->
  <header>
    <nav class="navbar navbar-dark navbar-expand-md fixed-top">
        <div class="container-fluid"><a class="navbar-brand" href="/"><img class="train-logo" src="${contextPath}/resources/img/train.png" width="55" height="55">
          <span style="font-size:25px">EasyRail</span>
        </a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse justify-content-end" id="navcol-1">
                <ul class="nav navbar-nav">
                  <li class="nav-item" role="presentation"><a class="nav-link" href="/">Замовити квитки</a></li>
                  <li class="nav-item" role="presentation"><a class="nav-link" href="#">Контакти</a></li>
                    <sec:authorize access="!isAuthenticated()">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="/login">Увійти</a></li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="/account">Акаунт</a></li>
                    </sec:authorize>
                  <li class="nav-item" role="presentation"><a class="nav-link" href="/cart"><i class="icon ion-android-cart"></i></a></li>
                </ul>
            </div>
        </div>
    </nav>
  </header>
  <!-- main -->
  <main>
    <!-- main baner -->
    <div class="train-primary container-fluid">
      <div class="container here-nothing">
        <p>Тут поки нічого :( </p>
        <img src="${contextPath}/resources/img/basket2.png" alt="basket">
        <div>
        <form action="${pageContext.request.contextPath}/" method="GET">
          <button type="submit" class="start-searching">Знайти квитки</button>
        </form>
        <div>
      </div>
      </div>

  </main>

  <footer class="fixed-bottom">
   <div class="container-fluid">
      <nav class="navbar navbar-dark navbar-expand-md">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">
            <span style="font-size:25px">EasyRail</span>
            <img class="train-logo" src="${contextPath}/resources/img/train.png" width="55" height="55">
          </a>
          <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"></button>
          <div class="collapse navbar-collapse justify-content-end" id="navcol-1">
            <ul class="nav navbar-nav">
              <li class="nav-item" role="presentation"><a class="nav-link" href="#">Про нас</a></li>
              <li class="nav-item" role="presentation"><a class="nav-link" href="/">Замовити квитки</a></li>
              <li class="nav-item" role="presentation"><a class="nav-link" href="#">Задати питання</a></li>
              <li class="nav-item" role="presentation"><a class="nav-link" href="#">Повернення квитків</a></li>
              <li class="nav-item" role="presentation"><a class="nav-link" href="#">Робота з нами</a></li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
    <!-- Copyright -->
    <div class="text-center footer-copyright">
      Copyright ©EasyRail. All rights reserved.
    </div>
    <!-- Copyright -->
  </footer>
</body>

</html>
