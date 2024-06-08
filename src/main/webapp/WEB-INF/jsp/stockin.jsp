<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a href="stockin" id="current1"><span class="fa-solid fa-boxes-packing"></span>Stock In</a>
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
    
      <h2 class="mb-4">Stock In Transactions</h2>

      <button onclick="openned('id01')" style="width:auto;">Add Stock</button>
      <button onclick="openned('id02')" style="width:auto; margin-right: 10px;">Add Product</button>

      <div id="id01" class="modal">

        <form:form  cssClass="modal-content animate" action="savestockin" method="post" modelAttribute="stockin">
          
          <span onclick="closed('id01') " class="close" title="Close">&times;</span>

          <div class="container">
            <label><b>Product</b></label>
            </br>
          <form:select path="product.barcodeId" cssClass="form-select">
          		<option value="">---Select---</option>
          	<c:forEach  items="${products}" var="product">
          		<form:option value="${product.barcodeId}">${product}</form:option>
          	</c:forEach>
          </form:select>
            </br>

            <label><b>Supplier</b></label>
            </br>
            <form:select path="supplier.id">
          		<option value="">---Select---</option>
          	<c:forEach  items="${suppliers}" var="supplier">
          		<form:option value="${supplier.id}">${supplier}</form:option>
          	</c:forEach>
          </form:select></br>

            <label><b>Product Quantity</b></label>
            <form:input type="number" path="quantity"/>
           
            <label><b>Purchase Price</b></label>
           	<form:input path="price" type="number"/>
           	
        

          	<form:button>Add</form:button>

          </div>

        </form:form>
      </div>

      <div id="id02" class="modal">

        <form:form cssClass="modal-content animate" action="saveproduct" method="post" modelAttribute="product">

          <span onclick="closed('id02') " class="close" title="Close">&times;</span>


          <div class="container">
            <label><b>Barcode Number</b></label>
            <form:input path="barcodeId" type="number"/><br/>
            <label><b>Product Name</b></label>
			<form:input path="name"/><br/>
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
              <th>Supplier Name</th>
              <th>Product Quantity</th>
              <th>Purchase Price</th>
              <th>Transaction Date</th>
          </tr>
        </thead>
        <tbody>
        
          <c:forEach items="${stockins}" var="stockin">
          	
          <tr>
              <td>${stockin.id}</td>
              <td>${stockin.product.barcodeId}</td>
              <td>${stockin.product.name}</td>
              <td>${stockin.supplier.company}</td>
              <td>${stockin.quantity}</td>
              <td>${stockin.price} ₺</td>
              <td><fmt:formatDate pattern = "dd.MM.yyyy"
                                  value = "${stockin.entryDate}" /></td>
          </tr>
          
          </c:forEach>
          
        </tbody>
      </table>
    </div>
  </div>
  <script>

    function openned(id) {
      document.getElementById(id).style.display = 'block';
      document.querySelector("html").style.overflow = "hidden";
    }
    function closed(id) {
      document.getElementById(id).style.display = 'none';
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