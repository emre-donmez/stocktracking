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
      <h2 class="mb-4 text-center">Stock Out Edit</h2>

         <form:form  cssClass="modal-content animate" method="post" modelAttribute="stockout">
          
          <div class="container">
              <label><b>Product</b></label>
              </br>
              <form:select path="product.barcodeId">
                  <option value="">---Select---</option>
                  <c:forEach  items="${products}" var="product">
                      <form:option value="${product.barcodeId}">${product}</form:option>
                  </c:forEach>
              </form:select>
              </br>

              <label><b>Customer</b></label>
              </br>
              <form:select path="customer.id">
                  <option value="">---Select---</option>
                  <c:forEach  items="${customers}" var="customer">
                      <form:option value="${customer.id}">${customer}</form:option>
                  </c:forEach>
              </form:select>

              <label><b>Number of Products</b></label>
              <form:input path="quantity" type="number"/>

              <label><b>Sale Price</b></label>
              <form:input path="price" type="number"/>

              <label><b>Transaction Date</b></label></br>
              <form:input type="date" path="releaseDate"/>

          	<form:button>Edit</form:button>

          </div>

        </form:form>
        
      </div>

   
  
  
</body>

</html>