<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

    <title>Home</title>
</head>
<body>
<div class="container center-block">
    <div class="row justify-content-center">
        <h1 align="center">CAR RENTAL SYSTEM</h1>
        <hr>
        <h4 align="center">${clientMessage}</h4>
        <div class="card" style="width: 18rem;">
            <div align="center">
                <img src="LOGO.png" class="rounded" width="150" height="152" alt="carrentallogo"/>
            </div>
            <div class="card-body">

                <form action="getClient">
                <div class="form-group">
                    <label for="emailInput"> Email address</label>
                    <input type="email" class="form-control" id="emailInput" name="email" required>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="mb-3">
                    <label for="inputID">Client ID</label>
                    <input type="number" class="form-control" id="inputID" name="clientId" required>
                </div>
                <div align="center">
                    <br/>
                    <button type="submit" class="btn btn-primary" name="btnSubmit" value="Submit">login</button>
                    <br/>
                </div>
                </form>

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
