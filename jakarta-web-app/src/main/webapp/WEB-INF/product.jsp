<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
    <title>Jakarta web app</title>
</head>

<body>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="product" items="${requestScope.goods}">

                <tr>
                    <th scope="row">
                        <c:out value="${product.id}"/>
                    </th>

                    <td>
                        <c:out value="${product.name}"/>
                    </td>

                    <td>$
                        <c:out value="${product.price}"/>
                    </td>
                    </c:forEach>
                </tbody>

            </table>

        </div>

    </div>
</div>


</body>
</html>