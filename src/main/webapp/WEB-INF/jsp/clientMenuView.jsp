<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js" integrity="sha384-lpyLfhYuitXl2zRZ5Bn2fqnhNAKOAaM/0Kr9laMspuaMiZfGmfwRNFh8HlMy49eQ" crossorigin="anonymous"></script>

    <title>Main Menu</title>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">CAR RENTAL</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a action="loginView" class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About Us</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Cars
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Galery</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</head>
<body>
<h1 align="center">WELCOME TO THE CAR RENTAL</h1>
<h4 align="center">${clientWelcomeMessage}</h4>
<hr>
<br/>
<h5>Enter departure and return dates to search for available cars. </h5>
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
    <div>
        <caption>List of cars available</caption>
        <table border="1" class="table table-dark table-striped">
            <thead>
                <tr>
                    <td>LICENSE PLATE</td>
                    <td>BRAND</td>
                    <td>SUB BRAND</td>
                    <td>CLASS</td>
                    <td>YEAR MODEL</td>
                    <td>PRICE PER DAY</td>
                    <td>OVERALL PRICE</td>
                    <td>ACTION</td>
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
                    <td>$${car.overallPrice}</td>
                    <td>
                        <form action="saveReservation">
                            <button type="submit" class="btn btn-success">RESERVE</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <h5 align="center">${noCarsMessage}</h5>

    <div align="center">
        <button type="submit" class="btn btn-primary btn-lg">FIND</button>
    </div>
</form>
<h4 align="center">PAGE FOR ALL THE MENU: RESERVE CAR, VIEW CARS AVAILABLE, VIEW RESERVATION STATUS, VIEW CLIENT DATA</h4>

</body>
</html>