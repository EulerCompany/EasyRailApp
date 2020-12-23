<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>EasyRail — увійти</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/fonts/ionicons.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/login_style.css">

</head>

<body class="text-dark">
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>
  <!-- header -->
  <header>
    <nav class="navbar navbar-dark navbar-expand-md fixed-top">
        <div class="container-fluid"><a class="navbar-brand" href="#"><img class="train-logo" src="${contextPath}/resources/img/train.png" width="55" height="55">
          <span style="font-size:25px">EasyRail</span>
        </a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse justify-content-end" id="navcol-1">
                <ul class="nav navbar-nav">
                  <li class="nav-item" role="presentation"><a class="nav-link" href="#">Замовити квитки</a></li>
                  <li class="nav-item" role="presentation"><a class="nav-link" href="#">Контакти</a></li>
                  <li class="nav-item" role="presentation"><a class="nav-link" href="#">Увійти</a></li>
                  <li class="nav-item" role="presentation"><a class="nav-link" href="#"><i class="icon ion-android-cart"></i></a></li>
                </ul>
            </div>
        </div>
    </nav>
  </header>

  <main>
    <!-- main baner -->
    <div class="train-primary">
      <div id="login">
          <div class="container">
              <div id="login-row" class="row justify-content-center align-items-center">
                  <div id="login-column" class="col-md-6">
                      <div id="login-box" class="col-md-12">
                          <form id="login-form" class="form" method="POST" action="/login" >
                              <h3 class="text-center text-info">Вхід</h3>
                              <div class="form-group">
                                  <label for="username" class="text-info">Логін:</label><br>
                                  <input type="text" name="username" id="username" class="form-control">
                              </div>
                              <div class="form-group">
                                  <label for="password" class="text-info">Пароль:</label><br>
                                  <input type="password" name="password" id="password" class="form-control">
                              </div>
                              <div class="form-group">
                                  <input type="submit" name="submit" class="btn btn-info btn-md" value="Увійти">
                              </div>
                              <div id="register-link" class="text-right">
                                  <a href="/registration" class="text-info">Зареєструватись</a>
                              </div>
                          </form>
                      </div>
                  </div>
              </div>
          </div>
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
              <li class="nav-item" role="presentation"><a class="nav-link" href="#">Замовити квитки</a></li>
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
