<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <title>Reservation status</title>

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
        <div class="container center-block">
            <div class="row justify-content-center">

                <h1 align="center">RESERVATION STATUS</h1>
                <hr>
                <h5 align="center">${inexistentReservation}</h5>
                <h5 align="center">${verifFailedMessage}</h5>
                <h5 align="center">${deleteSucessfulMessage}</h5>
                <hr>

                <div>
                    <caption>Reservation details</caption>
                    <table border="24" class="table table-dark table-striped">
                        <thead>
                            <tr>
                                <td>START DATE</td>
                                <td>RETURN DATE</td>
                                <td>LICENSE PLATE</td>
                                <td>BRAND</td>
                                <td>SUB BRAND</td>
                                <td>CLASS</td>
                                <td>YEAR MODEL</td>
                                <td>PRICE PER DAY</td>
                                <td>OVERALL PRICE</td>
                            </tr>
                        </thead>

                        <tr>
                            <td>${reservationStatus.startDate}</td>
                            <td>${reservationStatus.returnDate}</td>
                            <td>${carReserved.licensePlate}</td>
                            <td>${carReserved.brand}</td>
                            <td>${carReserved.subBrand}</td>
                            <td>${carReserved.classOfCar}</td>
                            <td>${carReserved.yearModel}</td>
                            <td>$${carReserved.price}</td>
                            <td>$${reservationStatus.overallPrice}</td>
                        </tr>
                    </table>
                </div>

                <!-- Button trigger modal -->
                <button type="button" class="btn btn-warning" style="width: 340px;" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    RETURN CAR
                </button>

                <form action = "deleteReservation">
                    <div align="center">
                        <br/>
                        <button type="submit" class="btn btn-danger" style="width: 800px;" name="btnBack" value="Back to login">${verifSucessful}</button>
                    </div>
                </form>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Reservation status</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>

                            <div class="modal-body">
                                <form action="employeeVerification" class="row g-4">
                                    <div class="mb-2">
                                        <label for="inputReservID">Employee ID:</label>
                                        <input type="number" class="form-control" id="inputReservID" name="employeeId" required>
                                    </div>
                                    <div class="mb-2">
                                        <label for="employeeEmail">Employee email:</label>
                                        <input type="email" class="form-control" id="employeeEmail" name="email" required>
                                    </div>
                                    <div align="center">
                                        <button type="submit" class="btn btn-danger" style="width: 120px;">Verify</button>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js" integrity="sha384-lpyLfhYuitXl2zRZ5Bn2fqnhNAKOAaM/0Kr9laMspuaMiZfGmfwRNFh8HlMy49eQ" crossorigin="anonymous"></script>
        -->
    </body>
</html>
