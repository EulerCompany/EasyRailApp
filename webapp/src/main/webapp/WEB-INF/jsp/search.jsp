<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Log in with your account</title>
</head>

<body>
<div>
  <form method="POST" action="/search">
    <h2>Поиск городов</h2>
    <div>
      <input name="first_name" type="text" placeholder="CityName"
             autofocus="true"/>
      <input name="second_name" type="text" placeholder="SecondCityName"/>
       <input name="date" type="date" path = "date" placeholder="Date"/>
      <button type="submit">Log In</button>

      <h4><a href="/registration">Зарегистрироваться</a></h4>
    </div>
  </form>
</div>

</body>
</html>