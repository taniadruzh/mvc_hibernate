<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        .dropbtn {
            background-color: #4CAF50;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f1f1f1;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {
            background-color: #ddd;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown:hover .dropbtn {
            background-color: #3e8e41;
        }
    </style>
</head>


<h2>Hoverable Dropdown</h2>
<p>Move the mouse over the button to open the dropdown menu.</p>

<div class="dropdown">
    <button class="dropbtn">Dropdown</button>
    <div class="dropdown-content">
        <c:forEach var="menu" items="${menuList}">
            <a href="#">${menu.title}</a>
        </c:forEach>
    </div>
</div>

<br/>
<br/>


<table class="table table-striped">
    <thead>
    <tr>
        <th>#ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>framework</th>
        <th>Action</th>
    </tr>
    </thead>

    <c:forEach var="menu" items="${menuList}">
        <tr>
            <th>id</th>
            <th>title</th>
        </tr>
        <tr>
            <td>${menu.id}</td>
            <td>${menu.title}</td>

            <td>
                <c:url value="/menu/${menu.id}" var="menuUrl"/>
                <c:url value="/menu/${menu.id}/delete" var="deleteUrl"/>
                <c:url value="/menu/${menu.id}/update" var="updateUrl"/>

                <button class="btn btn-info"
                        onclick="location.href='${menuUrl}'">Show
                </button>
                <button class="btn btn-primary"
                        onclick="location.href='${updateUrl}'">Update
                </button>
                <button class="btn btn-danger"
                        onclick="location.href='${deleteUrl}'">Delete
                </button>
            </td>
        </tr>
    </c:forEach>
</table>


<br/>
<br/>


<form:form method="POST"
           action="add_employee" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">
                Contact Number</form:label></td>
            <td><form:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="add"/></td>
        </tr>
    </table>
</form:form>

<br/><br/>

<form method="POST"
      action="redirect_employee" modelAttribute="employee">
    <input type="text" name="id"/>
    <input type="text" name="name"/>
    <input type="text" name="contactNumber"/>
    <input type="submit" value="redirect"/>
</form>

</body>
</html>
