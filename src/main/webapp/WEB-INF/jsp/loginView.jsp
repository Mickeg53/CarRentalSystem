<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <%--Bootstrap CSS--%>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <title>Home</title>
        <%--NAVIGATION BAR--%>
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

            <%--BUTTON RESERVATION STATUS--%>
            <button type="button" class="btn btn-success" style="width: 240px;" data-bs-toggle="modal" data-bs-target="#exampleModal">
                RESERVATION STATUS
            </button>

            <%--MODAL--%>
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Reservation status</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>

                        <div class="modal-body">
                            <form action="getReservationStatus" class="row g-4">
                                <div class="mb-2">
                                    <label for="inputReservID">Reservation number:</label>
                                    <input type="number" class="form-control" id="inputReservID" name="reservationId" required>
                                </div>
                                <div align="center">
                                    <button type="submit" class="btn btn-primary" style="width: 120px;">Show details</button>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    </head>

    <body style="background-color: peru;">
        <div class="container center-block">
            <div class="row justify-content-center">
                <h1 align="center">CAR RENTAL SYSTEM</h1>
                <hr><h4 align="center">${clientMessage}</h4><hr>
                <%--CARD CLASS--%>
                <div class="card" style="width: 18rem;">
                    <%--LOGO IMAGE--%>
                    <div align="center">
                        <img src="car_Rental_Logo.png" class="modal-dialog-centered" alt="carrentallogo" style="width:128px;height:128px;">
                    </div>
                    <%--CARD BODY--%>
                    <div class="card-body">
                        <%--LOGIN FORM--%>
                        <form action="getClient">
                            <%--EMAIL INPUT--%>
                            <div class="form-group">
                                <label for="emailInput"> Email address</label>
                                <input id="emailInput" type="email" class="form-control" name="email" required>
                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                            </div>
                            <%--CLIENT ID INPUT--%>
                            <div class="mb-3">
                                <label for="inputID">Client ID</label>
                                <input id="inputID" type="number" class="form-control" name="clientId" required>
                            </div>
                            <%--RADIO BUTTONS--%>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="user" id="clientUser" checked>
                                <label class="form-check-label" for="clientUser">
                                    Client user
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="user" id="employeeUser">
                                <label class="form-check-label" for="employeeUser">
                                    Employee user
                                </label>
                            </div>
                            <%--LOGIN BUTTON--%>
                            <div align="center">
                                <br/>
                                <button id="btnSubmit" type="submit" class="btn btn-primary" value="Submit">login</button>
                                <br/>
                            </div>
                        </form>
                        <%--REGISTER BUTTON FORM--%>
                        <form action = "SignupView">
                            <div align="center">
                            <br/>
                            <button type="submit" class="btn btn-primary" name="btnRegister" value="Register">Register</button>
                            </div>
                        </form>
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
