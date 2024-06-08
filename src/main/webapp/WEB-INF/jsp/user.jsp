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
  <link rel="stylesheet" href="css/font.css" >
  <link rel="stylesheet" href="css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/popform.css">
  <link rel="shortcut icon" href="img/favicon.png">
  <link rel="stylesheet" href="css/alert.css">
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
        <a href="stockout"><span class="fa-solid fa-truck-ramp-box"></span> Stock Out</a>
      </li>
      <li>
        <a href="user" id="current1"><span class="fa-solid fa-id-card"></span> Customer & Supplier</a>
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

      <h2 class="mb-4">Customer & Supplier Transactions</h2>

      <button onclick="openned('id01')" style="width:auto;">Add Customer</button>

      <div id="id01" class="modal">

        <form:form cssClass="modal-content animate" action="savecustomer" method="post" modelAttribute="customer">
          <span onclick="closed('id01') " class="close" title="Close">&times;</span>

          <div class="container">
            <h3 style="color: #323131;">Add Customer</h3>
            <label><b>Company Name</b></label>
            <form:input path="company"/>

            <label><b>Phone</b></label>
            <form:input path="phone" type="number"/>

            <label><b>Fax Number</b></label>
            <form:input path="faxNumber" type="number"/>

            <label><b>E-Mail</b></label>
            <form:input path="email"/>

            <label><b>Address</b></label>
            <br>
            <form:textarea path="address"/>

            <button type="submit">Add</button>

          </div>

        </form:form>
      </div>

      <table class="table table-hover text-center">
        <thead>
          <tr>
            <th>Customer ID</th>
            <th>Company Name</th>
            <th>Phone</th>
            <th>Fax Number</th>
            <th>E-Mail</th>
            <th>Address</th>
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
          </tr>

          </c:forEach>

        </tbody>
      </table>

      <button onclick="openned('id02')" style="width:auto;">Add Supplier</button>

      <div id="id02" class="modal">

        <form:form cssClass="modal-content animate" action="savesupplier" method="post" modelAttribute="supplier">
          <span onclick="closed('id02') " class="close" title="Close">&times;</span>


          <div class="container">
            <h3 style="color: #323131;">Add Supplier</h3>
            <label><b>Company Name</b></label>
            <form:input path="company"/>

            <label><b>Phone</b></label>
            <form:input path="phone" type="number"/>

            <label><b>Fax Number</b></label>
            <form:input path="faxNumber" type="number"/>

            <label><b>E-Mail</b></label>
            <form:input path="email"/>

            <label><b>Address</b></label>
            <br>
            <form:textarea path="address"/>

            <button type="submit">Add</button>

          </div>

        </form:form>
      </div>

      <table class="table table-hover text-center">
        <thead>
          <tr>
            <th>Supplier ID</th>
            <th>Company Name</th>
            <th>Phone</th>
            <th>Fax Number</th>
            <th>E-Mail</th>
            <th>Address</th>
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
          </tr>

          </c:forEach>

        </tbody>
      </table>

    </div>
  </div>
  <script>

    var modal = document.getElementById('id01');
    var modal2 = document.getElementById('id02');

    window.onclick = function (event) {
      if (event.target == modal || event.target == modal2) {
        closed('id01');
        closed('id02');
      }
    }


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