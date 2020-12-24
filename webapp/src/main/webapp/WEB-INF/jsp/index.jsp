<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>EasyRail — головна</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/fonts/ionicons.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/main_page.css">
</head>

<body class="text-dark">
  <!-- header -->
  <header>
    <nav class="navbar navbar-dark navbar-expand-md fixed-top">
      <div class="container-fluid"><a class="navbar-brand" href="#"><img class="train-logo" src="${contextPath}/resources/img/train.png" width="55" height="55">
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
      <img class="img-fluid" src="${contextPath}/resources/img/background_train.png">
      <div class="greeting">Мандруй швидко та зручно разом з нами!</div>
      <div class="arrow-down"><a href="#"><img class="arr-d" src="${contextPath}/resources/img/arrows.png" width="100" height="100"></a></div>
    </div>
    <!-- search inputs -->
    <div class="search-wrapper containter-fluid">
      <div class="col-1">
        <!-- none -->
      </div>
      <div class="search-background col-10">
        <div class="container-fluid">
          <!-- popular routes -->
          <div class="row">
            <p class="popular-routes">Популярні напрямки</p>
          </div>
          <!--начинаю делать хуйню-->
            <div class="row d-flex justify-content-between">
              <div class="col-1">
                <!-- none -->
              </div>
              <div class="route d-flex justify-content-center">
                <p class="from">Київ</p>
                <img src="${contextPath}/resources/img/double-arrow.png" alt="double-arrow">
                <p class="to">Харків</p>
              </div>
              <div class="route d-flex justify-content-center">
                <p class="from">Київ</p>
                <img src="${contextPath}/resources/img/double-arrow.png" alt="double-arrow">
                <p class="to">Львів</p>
              </div>
              <div class="route d-flex justify-content-center">
                <p class="from">Київ</p>
                <img src="${contextPath}/resources/img/double-arrow.png" alt="double-arrow">
                <p class="to">Дніпро-Головний</p>
              </div>
              <div class="route d-flex justify-content-center">
                <p class="from">Київ</p>
                <img src="${contextPath}/resources/img/double-arrow.png" alt="double-arrow">
                <p class="to">Одеса</p>
              </div>
              <div class="col-1">
                <!-- none -->
              </div>
            </div>
          <!--заканчиваю делать []уйню-->
          <!-- input form -->
          <div class="input-wrapper container-fluid">
            <form action="/search" method="post">
              <div class="row">
                <div class="col-1">
                  <!-- none -->
                </div>
                <!-- input form -->
                <div class="col-10">
                  <div class="form-horizontal d-flex justify-content-center" role="form">
                      <!-- from -->
                    <div class="left col-6">
                      <div class="form-group">
                        <label class="control-label" for="from" >Звідки</label>
                        <input name="firstCity" type="text" id="from-date" class="form-control">
                      </div>
                    </div>
                    <!-- to -->
                    <div class="right col-6">
                      <div class="form-group">
                        <label class="control-label" for="to" >Куди</label>
                        <input name="lastCity" type="text" id="to-date" class="form-control">
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-1">
                  <!-- none -->
                </div>
              </div>
              <!-- calendar form -->
              <div class="row">
                <div class="col-1">
                  <!-- none -->
                </div>
                <div class="butt-form col-10">
                  <div class="form-horizontal d-flex justify-content-left">
                    <div class="col-5">
                      <div class="form-group">
                        <label for="date">Час відправлення</label>
                        <input name="date" type="date" id="calendar" class="form-control">
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-1">
                  <!-- none -->
                </div>
              </div>
              <!-- search button -->
              <div class="row">
                <div class="search-butt btn-group" data-toggle="buttons">
                  <button type="submit" class="btn search-butt">Пошук потягів</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
      <div class="col-1">
        <!-- none -->
      </div>
    </div>
  </main>

  <footer>
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
