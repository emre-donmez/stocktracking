<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="tr">

<head>
  <title>Emrecan Dönmez</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="/css/font.css" >
  <link rel="stylesheet" href="/css/all.min.css">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/popform.css">
  <link rel="shortcut icon" href="/img/favicon.png">
</head>

<body>
    <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5">
      <h2 class="mb-4 text-center">Product Edit</h2>

        <form:form cssClass="modal-content animate" method="post" modelAttribute="product">
        
          <div class="container">
            <label><b>Product Name</b></label>
            <form:input path="name"/>

            <button type="submit">Edit</button>

          </div>

        </form:form>
      </div>

   
  
  
</body>

</html>