<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

    <title>Main Menu</title>
</head>
<body>
<h1 align="center">WELCOME TO THE CAR RENTAL</h1>
<hr>
<h2 align="center">${clientWelcomeMessage}</h2>
<br/>
<h4>Enter departure and return dates to search for available cars. </h4>
<br/>
<form action="getAllCarsAvailable" class="row g-4">
    <div class="col-md-2">
        <label for="startDateInput" class="form-label">From:</label>
        <input type="date" class="form-control" id="startDateInput" name="startDate" required>
    </div>
    <div class="col-md-2">
        <label for="startTimeInput" class="form-label">At:</label>
        <input type="time" class="form-control" id="startTimeInput" name="startTime" required>
    </div>
    <div class="col-md-2">
        <label for="class" class="form-label">Class of car:</label>
        <select class="form-select" id="class" name="carClass" required>
            <option selected disabled value="">Choose...</option>
            <option>....</option>
            <option>Compact</option>
            <option>Mid-size</option>
            <option>Large</option>
            <option>Cargo</option>
            <option>Pick-up</option>
            <option>SUV</option>
            <option>VAN</option>
        </select>
    </div>
    <br/>
    <div class="col-md-2">
        <label for="endDateInput" class="form-label">To:</label>
        <input type="date" class="form-control" id="endDateInput" name="endDate" required>
    </div>
    <div class="col-md-2">
        <label for="endTimeInput" class="form-label">At:</label>
        <input type="time" class="form-control" id="endTimeInput" name="endTime" required>
    </div>
    <hr>
    <h5 align="center">${noCarsMessage}</h5>
    <div>
        <table border="1" class="table caption-top">
            <caption>List of cars available</caption>
            <thead>
                <tr>
                    <td>LICENSE PLATE</td>
                    <td>BRAND</td>
                    <td>SUB BRAND</td>
                    <td>CLASS</td>
                    <td>YEAR MODEL</td>
                    <td>PRICE PER DAY</td>
                    <td>OVERALL PRICE</td>
                </tr>
            </thead>
            <c:forEach var="car" items="${listOfCars}">
                <tr>
                    <td>${car.licensePlate}</td>
                    <td>${car.brand}</td>
                    <td>${car.subBrand}</td>
                    <td>${car.classOfCar}</td>
                    <td>${car.yearModel}</td>
                    <td>$${car.price}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div align="center">
        <button type="submit" class="btn btn-primary" name="btnFind" value="findBtn">Find</button>
    </div>
</form>


<%--<table class="table caption-top">
    <caption>List of users</caption>
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">Handle</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
    </tr>
    <tr>
        <th scope="row">2</th>
        <td>Jacob</td>
        <td>Thornton</td>
        <td>@fat</td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td>Larry</td>
        <td>the Bird</td>
        <td>@twitter</td>
    </tr>
    </tbody>
</table>--%>

<h4 align="center">PAGE FOR ALL THE MENU: RESERVE CAR, VIEW CARS AVAILABLE, VIEW RESERVATION STATUS, VIEW CLIENT DATA</h4>

</body>
</html>