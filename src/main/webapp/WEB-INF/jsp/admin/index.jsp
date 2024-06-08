<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
    <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5">
      <h2 class="mb-4 text-center">Admin Panel</h2>


		<h4>Stock Ins</h4>
		<table class="table table-hover">
        <thead>
          <tr>
            <th>Id</th>
            <th>Product Barcode</th>
            <th>Product Name</th>
            <th>Supplier Name</th>
            <th>Product Quantity</th>
            <th>Purchase Price</th>
            <th>Transaction Date</th>
            <th style="width: 65px"></th>
          </tr>
        </thead>
        <tbody>
        
          <c:forEach items="${stockIns}" var="stockin">
          	
          <tr>
            <td>${stockin.id}</td>
            <td>${stockin.product.barcodeId}</td>
            <td>${stockin.product.name}</td>
            <td>${stockin.supplier.company}</td>
            <td>${stockin.quantity}</td>
            <td>${stockin.price} ₺</td>
            <td><fmt:formatDate pattern = "dd.MM.yyyy" 
         		value = "${stockin.entryDate}" /></td>
         	<td><a href="<c:url value='admin/update/stockin/${stockin.id}' />" class="btn btn-warning custom-width"><i class="fa-solid fa-pen-to-square"></i></a></td>
            <td><a href="<c:url value='admin/delete/stockin/${stockin.id}' />" class="btn btn-danger custom-width" onclick="return confirmDelete();"><i class="fa-solid fa-trash"></i></a></td>
          </tr>
          
          </c:forEach>
          
        </tbody>
      </table>
      
      <h4>Stock Outs</h4>
      
      <table class="table table-hover">
        <thead>
          <tr>
          	<th>Id</th>
            <th>Product Barcode</th>
            <th>Product Name</th>
            <th>Supplier Name</th>
            <th>Product Quantity</th>
            <th>Purchase Price</th>
            <th>Transaction Date</th>
            <th style="width: 65px"></th>
          </tr>
        </thead>
        <tbody>
        
          <c:forEach items="${stockOuts}" var="stockout">
          	
          <tr>
            <td>${stockout.id}</td>
            <td>${stockout.product.barcodeId}</td>
            <td>${stockout.product.name}</td>
            <td>${stockout.customer.company}</td>
            <td>${stockout.quantity}</td>
            <td>${stockout.price} ₺</td>
            <td><fmt:formatDate pattern = "dd.MM.yyyy" 
         		value = "${stockout.releaseDate}" /></td>
         	<td><a href="<c:url value='admin/update/stockout/${stockout.id}' />" class="btn btn-warning custom-width"><i class="fa-solid fa-pen-to-square"></i></a></td>
            <td><a href="<c:url value='admin/delete/stockout/${stockout.id}' />" class="btn btn-danger custom-width" onclick="return confirmDelete();"><i class="fa-solid fa-trash"></i></a></td>
         		
          </tr>
          
          </c:forEach>
                    
        </tbody>
      </table>
      
      <h4 class="d-inline">Products </h4> <p class="d-inline"> When the product is deleted, the relevant records are also deleted.</p>
      
      <table class="table table-hover">
        <thead>
          <tr>
            <th>Barcode Code</th>
            <th>Product Name</th>
            <th style="width: 65px"></th>
          </tr>
        </thead>
        <tbody>
        
          <c:forEach items="${products}" var="product">
          	
          <tr>
           	<td>${product.barcodeId}</td>
           	<td>${product.name}</td>
           	<td><a href="<c:url value='admin/update/product/${product.barcodeId}' />" class="btn btn-warning custom-width"><i class="fa-solid fa-pen-to-square"></i></a></td>
            <td><a href="<c:url value='admin/delete/product/${product.barcodeId}' />" class="btn btn-danger custom-width" onclick="return confirmDelete();"><i class="fa-solid fa-trash"></i></a></td>
          </tr>
          
          </c:forEach>
                    
        </tbody>
      </table>
      
      <h4 class="d-inline">Suppliers </h4> <p class="d-inline"> When the supplier is deleted, it is deleted in the relevant records.</p>
      
      <table class="table table-hover">
        <thead>
          <tr>
            <th>Supplier ID</th>
            <th>Company Name</th>
            <th>Phone</th>
            <th>Fax Number</th>
            <th>E-Mail</th>
            <th>Address</th>
            <th style="width: 65px"></th>
          </tr>
        </thead>
        <tbody>
          
          <c:forEach items="${suppliers}" var="supplier">
          	
          <tr>
            <td>${supplier.id}</td>
            <td>${supplier.company}</td>
            <td>${supplier.phone}</td>
            <td>${supplier.faxNumber}</td>
            <td>${supplier.email}</td>
            <td>${supplier.address}</td>
            <td><a href="<c:url value='admin/update/supplier/${supplier.id}' />" class="btn btn-warning custom-width"><i class="fa-solid fa-pen-to-square"></i></a></td>
            <td><a href="<c:url value='admin/delete/supplier/${supplier.id}' />" class="btn btn-danger custom-width" onclick="return confirmDelete();"><i class="fa-solid fa-trash"></i></a></td>
          </tr>
          	
          </c:forEach>
          
        </tbody>
      </table>
      
      <h4 class="d-inline">Customers </h4> <p class="d-inline"> When the customer is deleted, the relevant records are also deleted.</p>
       <table class="table table-hover">
        <thead>
          <tr>
            <th>Customer ID</th>
            <th>Company Name</th>
            <th>Phone</th>
            <th>Fax Number</th>
            <th>E-Mail</th>
            <th>Address</th>
            <th style="width: 65px"></th>
          </tr>
        </thead>
        <tbody>
          
          <c:forEach items="${customers}" var="customer">
          	
          <tr>
            <td>${customer.id}</td>
            <td>${customer.company}</td>
            <td>${customer.phone}</td>
            <td>${customer.faxNumber}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td><a href="<c:url value='admin/update/customer/${customer.id}' />" class="btn btn-warning custom-width"><i class="fa-solid fa-pen-to-square"></i></a></td>
            <td><a href="<c:url value='admin/delete/customer/${customer.id}' />" class="btn btn-danger custom-width" onclick="return confirmDelete();"  ><i class="fa-solid fa-trash"></i></a></td>
          </tr>
          	
          </c:forEach>
          
        </tbody>
      </table>
      

    </div>

    <script type="text/javascript">
      function confirmDelete() {
        return confirm("Are you sure you want to delete this item?");
      }
    </script>
</body>

</html>