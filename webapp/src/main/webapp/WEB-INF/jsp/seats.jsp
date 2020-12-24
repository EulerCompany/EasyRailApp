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
    <link rel="stylesheet" href="${contextPath}/resources/css/choose_seats.css">
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
                <li class="nav-item" role="presentation"><a class="nav-link" href="#">Замовити квитки</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="#">Контакти</a></li>
                <sec:authorize access="!isAuthenticated()">
                  <li class="nav-item" role="presentation"><a class="nav-link" href="/login">Увійти</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                  <li class="nav-item" role="presentation"><a class="nav-link" href="/account">Акаунт</a></li>
                </sec:authorize>
                <li class="nav-item" role="presentation"><a class="nav-link" href="#"><i class="icon ion-android-cart"></i></a></li>
              </ul>
          </div>
      </div>
    </nav>
  </header>
  <!-- main -->
  <main>
    <!-- main baner -->
    <div class="main-wrapper container-fluid">
      <div class="row container-fluid">
        <div class="col-2">
          <!-- none -->
        </div>
        <div class="col-8">
          <div class="row d-flex justify-content-center">
            <div class="h-14">
              <p>Виберіть місце</p>
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="h-21">
              <div class="train-data container-fluid">
                <!-- TODO: add train data -->
              </div>
            </div>
          </div>
          <!-- choose carriage -->
          <div class="row d-flex justify-content-center">
            <div class="carriages">
              <div class="btn-group" data-toggle="buttons">
                <button class='btn active'>
                  <img src="${contextPath}/resources/img/carriage1.png" alt="carriage1">
                  <div class="img-overlay">
                    <!-- put number here -->
                    1
                  </div>
                </button>
                <button class='btn'>
                  <img src="${contextPath}/resources/img/carriage1.png" alt="carriage1">
                  <div class="img-overlay">
                    <!-- put number here -->
                    2
                  </div>
                </button>
              </div>
            </div>
          </div>
          <!-- choose a seat -->
          <div class="seats-wrapper row justify-content-center">
            <div class="flour img-overlay">
              <!-- coupe -->
              <div class="coupe row d-flex align-items-start">
                <div class="seats  d-flex justify-content-center">
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn active">
                          <img class="hue" src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            2
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            4
                          </div>
                        </button>
                      </div>
                    </div>
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            1
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            3
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            6
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            8
                          </div>
                        </button>
                      </div>
                    </div>
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            5
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            7
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            10
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            12
                          </div>
                        </button>
                      </div>
                    </div>
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            9
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            11
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            14
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            16
                          </div>
                        </button>
                      </div>
                    </div>
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            13
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            15
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            18
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            20
                          </div>
                        </button>
                      </div>
                    </div>
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            17
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            19
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            22
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            24
                          </div>
                        </button>
                      </div>
                    </div>
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            21
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            23
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            26
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            28
                          </div>
                        </button>
                      </div>
                    </div>
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            25
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            27
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            30
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            32
                          </div>
                        </button>
                      </div>
                    </div>
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            29
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            31
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            34
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            36
                          </div>
                        </button>
                      </div>
                    </div>
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            33
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            35
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                </div>
              </div>
              <!-- side -->
              <div class="side row d-flex justify-content-center">
                <div class="seats  d-flex justify-content-center">
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            54
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            53
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            52
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            51
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            50
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            49
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            48
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            47
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            46
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            45
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            44
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            43
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            42
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            41
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            40
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            39
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                  <!--  -->
                  <div class="coupe">
                    <div class="btn-toolbar">
                      <div class="btn-group justify-content-center">
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_up.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            38
                          </div>
                        </button>
                        <button class="btn">
                          <img src="${contextPath}/resources/img/seat_down.png" alt="seat_up">
                          <div class="img-overlay">
                            <!-- put number here -->
                            37
                          </div>
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- choosed button -->
          <div class="row justify-content-center">
            <div class="search-butt form-group">
                <input type="submit" name="submit" class="btn btn-info btn-md" value="Оформлення квитків">
            </div>
          </div>
        </div>
        <div class="col-2">
          <!-- none -->
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
