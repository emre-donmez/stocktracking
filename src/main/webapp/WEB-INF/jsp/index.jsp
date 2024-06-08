<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="tr">

<head>
  <title>Emrecan Dönmez</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="css/font.css" >
  <link rel="stylesheet" href="css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="shortcut icon" href="img/favicon.png">
</head>

<body>

  <div class="wrapper d-flex align-items-stretch">
    <nav id="sidebar" class="active">
      <h1><a href="../" class="logo">E.</a></h1>
      <ul class="list-unstyled components mb-5">
        <li class="active">
          <a href="../" id="current1"><span class="fa-solid fa-box-archive "></span>Stock Status</a>
        </li>
        <li>
          <a href="stockin"><span class="fa-solid fa-boxes-packing"></span>Stock In</a>
        </li>
        <li>
          <a href="stockout"><span class="fa-solid fa-truck-ramp-box"></span> Stock Out</a>
        </li>
        <li>
          <a href="user"><span class="fa-solid fa-id-card"></span> Customer & Supplier</a>
        </li>
        <li>
          <a href="excel"><span class="fa-solid fa-file-export"></span> Export</a>
        </li>
        <li>
          <a href="javascript:;" onclick="document.getElementById('form1').submit();"><span class="fa-solid fa-right-from-bracket"></span> Exit</a>
        </li>
      </ul>
    </nav>
	<form action="logout" method="post" id="form1">
		<input type="hidden"
		name="${_csrf.parameterName}"
		value="${_csrf.token}">
	</form>

    <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5">
      <h2 class="mb-4">Stock Status</h2>
      <table class="table table-hover text-center">
        <thead>
          <tr>
            <th>#</th>
            <th>Barcode Number</th>
            <th>Product Name</th>
            <th>The Amount of Stock</th>
            <th>Average Unit Cost</th>
          </tr>
        </thead>
        <tbody>
        
          <c:forEach items="${stockStatus}" var ="stock" varStatus="Index">
          	 <tr>
          	 	<td>${Index.index + 1}</td>
	            <td>${stock.barcodeId}</td>
            	<td>${stock.name}</td>
	            <td>${stock.quantity}</td>
	            <td>${stock.averageCost} ₺</td>
          	</tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</body>
</html>