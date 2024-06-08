<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="tr">

<head>
  <title>Emrecan Dönmez</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="css/font.css" >
  <link rel="stylesheet" href="css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/popform.css">
  <link rel="stylesheet" href="css/alert.css">
  <link rel="shortcut icon" href="img/favicon.png">
</head>

<body>

<div class="wrapper d-flex align-items-stretch">
    <nav id="sidebar" class="active">
        <h1><a href="../" class="logo">E.</a></h1>
        <ul class="list-unstyled components mb-5">
            <li class="active">
                <a href="../"><span class="fa-solid fa-box-archive "></span>Stock Status</a>
            </li>
            <li>
                <a href="stockin"><span class="fa-solid fa-boxes-packing"></span>Stock In</a>
            </li>
            <li>
                <a href="stockout" id="current1"><span class="fa-solid fa-truck-ramp-box"></span> Stock Out</a>
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
    
     <c:if test="${not empty message}">
    	<div class="alert success" id="alert">
		  <span class="closebtn" onclick=alert()>&times;</span>  
		  <strong>${message}</strong>
		</div>
    </c:if>
   
   <c:if test="${not empty errormessage}">
    	<div class="alert" id="alert">
		  <span class="closebtn" onclick=alert()>&times;</span>  
		  <strong>${errormessage}</strong>
		</div>
    </c:if>
    
      <h2 class="mb-4">Stock Out Transactions</h2>

      <button onclick="openned()" style="width:auto;">Stock Out</button>

      <div id="id01" class="modal">

        <form:form  cssClass="modal-content animate" action="saveout" method="post" modelAttribute="stockout">
          
          <span onclick="closed()" class="close" title="Close">&times;</span>

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
          </form:select></br>

            <label><b>Number of Products</b></label>
            <form:input path="quantity" type="number"/>
           
            <label><b>Sale Price</b></label>
           	<form:input path="price" type="number"/>

          	<form:button>Add</form:button>

          </div>

        </form:form>
      </div>

      <table class="table table-hover text-center">
        <thead>
          <tr>
              <th>Id</th>
              <th>Product Barcode</th>
              <th>Product Name</th>
              <th>Customer Name</th>
              <th>Product Quantity</th>
              <th>Selling Price</th>
              <th>Transaction Date</th>
          </tr>
        </thead>
        <tbody>
        
          <c:forEach items="${stockouts}" var="stockout">
          	
          <tr>
          	<td>${stockout.id}</td>
           	<td>${stockout.product.barcodeId}</td>
            <td>${stockout.product.name}</td>
            <td>${stockout.customer.company}</td>
            <td>${stockout.quantity}</td>
            <td>${stockout.price} ₺</td>
            <td><fmt:formatDate pattern = "dd.MM.yyyy" 
         		value = "${stockout.releaseDate}" /></td>
          </tr>
          
          </c:forEach>
                    
        </tbody>
      </table>
    </div>
  </div>

  <script>
  
    function openned() {
      document.getElementById('id01').style.display = 'block';
      document.querySelector("html").style.overflow = "hidden";
    }
    function closed() {
      document.getElementById('id01').style.display = 'none';
      document.querySelector("html").style.overflow = "auto";
    }
    
    setTimeout(alert,4000);
	function alert(){
        var alert=document.getElementById('alert');
        alert.style.opacity="0";
        setTimeout(function(){ alert.style.display = "none"; }, 600);
	}

  </script>
</body>

</html>