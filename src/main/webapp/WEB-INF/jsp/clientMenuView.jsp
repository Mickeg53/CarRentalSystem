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
                                <li><a class="dropdown-item" href="#">Compact</a></li>
                                <li><a class="dropdown-item" href="#">Mid-size</a></li>
                                <li><a class="dropdown-item" href="#">Large</a></li>
                                <li><a class="dropdown-item" href="#">Cargo</a></li>
                                <li><a class="dropdown-item" href="#">Pick-up</a></li>
                                <li><a class="dropdown-item" href="https://www.autobild.es/reportajes/que-significa-palabra-suv-207808">SUV</a></li>
                                <li><a class="dropdown-item" href="#">VAN</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Dynamics of car rental</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#">Galery</a>
                        </li>
                    </ul>
                </div>
            </div>
            <form action = "/">
                <div align="center">
                    <br/>
                    <button type="submit" class="btn btn-primary" style="width: 240px;" name="btnBack" value="Back to login">BACK TO LOGIN</button>
                </div>
            </form>
        </nav>
    </head>

    <body style="background-color: peru;">
        <h1 align="center"><em>WELCOME TO THE CAR RENTAL</em></h1>
        <h4 align="center"><i>${clientWelcomeMessage}</i></h4>
        <hr>
        <h5 align="center">${sucessMessage}</h5>
        <h5 align="center">${messageId}</h5>
        <hr>
        <br/>
        <h6 align="center">ENTER DEPARTURE AND RETURN DATES TO SEARCH FOR AVAILABLE CARS. </h6>
        <br/>
        <form action="getAllCarsAvailable" class="row g-4">
            <div class="col-md-2">
                <label for="startDateInput" class="form-label">From:</label>
                <input type="date" class="form-control" id="startDateInput" name="startDate" value="<?php if(isset($_POST['startDate'])) ECHO $_POST['startDate']; ?>" required>
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
                <table border="24" class="table table-dark table-striped">
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
                            <td>$${car.overallPrice}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <h5 align="center">${noCarsMessage}</h5>
            <div align="center">
                <button type="submit" class="btn btn-primary btn-lg" style="width: 120px;">FIND</button>
            </div>
            <br/>
        </form>

        <form action="saveReservation" class="row g-lg-4">
            <div align="center">
                <div class="col-md-2">
                    <label for="licensePlateInput" class="form-label">License Plate:</label>
                    <input type="text" class="form-control" id="licensePlateInput" name="licensePlate" required>
                </div>

                <div class="col-md-2">
                    <label for="clientIdInput" class="form-label">Client ID:</label>
                    <input type="number" class="form-control" id="clientIdInput" name="idClient" required>
                </div>
            </div>
            <div align="center">
                <button type="submit" class="btn btn-success" style="width: 120px;" >RESERVE</button>
            </div>
        </form>
        <br/><br/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    </body>
</html>