<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

    <title>Signup</title>
</head>
<body>
<h1 align="center">SIGNUP PAGE</h1>
<hr>
<br/>

<form action="saveClient" method="get" class="row g-1">
    <br/>
    <div class="col-md-3">
        <label for="nameInput" class="form-label">Name/s</label>
        <input type="text" class="form-control" id="nameInput" name="name" required>
    </div>
    <div class="col-md-3">
        <label for="lastNameInput" class="form-label">Last name</label>
        <input type="text" class="form-control" id="lastNameInput" name="lastName" required>
    </div>
    <div class="col-md-3">
        <label for="mothersLastNameInput" class="form-label">Mothers Last name</label>
        <input type="text" class="form-control" id="mothersLastNameInput" name="mothersLastName" required>
    </div>
    <br/>
    <div class="col-md-3">
        <label for="emailInput" class="form-label">Email</label>
        <div class="input-group">
            <span class="input-group-text" id="inputGroupPrepend2">@</span>
            <input type="email" class="form-control" id="emailInput" name="email" required>
        </div>
    </div>
    <div class="col-md-2">
        <label for="phoneInput" class="form-label">Phone number</label>
        <input type="number" class="form-control" id="phoneInput" name="phoneNumber" required>
    </div>
    <br/><br/>
    <h5 align="center">ADDRESS</h5>
    <hr>
    <br/>
    <div class="col-md-3">
        <label for="streetInput" class="form-label">Street</label>
        <input type="text" class="form-control" id="streetInput" name="street" required>
    </div>
    <div class="col-md-2">
        <label for="outdoorInput" class="form-label">Outdoor Number</label>
        <input type="number" class="form-control" id="outdoorInput" name="outDoorNumber" required>
    </div>
    <div class="col-md-2">
        <label for="indoorInput" class="form-label">Indoor Number</label>
        <input type="number" class="form-control" id="indoorInput" name="inDoorNumber" required>
    </div>
    <div class="col-md-3">
        <label for="colonyInput" class="form-label">Colony</label>
        <input type="text" class="form-control" id="colonyInput" name="colony" required>
    </div>
    <br/>
    <div class="col-md-2">
        <label for="state" class="form-label">State</label>
        <select class="form-select" id="state" name="state" required>
            <option selected disabled value="">Choose...</option>
            <option>....</option>
            <option>Aguascalientes</option>
            <option>Baja California</option>
            <option>Baja California Sur</option>
            <option>Campeche</option>
            <option>Chiapas</option>
            <option>Chihuahua</option>
            <option>Ciudad de M&eacutexico</option>
            <option>Coahuila de Zaragoza</option>
            <option>Colima</option>
            <option>Durango</option>
            <option>Estado de M&eacutexico</option>
            <option>Guanajuato</option>
            <option>Guerrero</option>
            <option>Hidalgo</option>
            <option>Jalisco</option>
            <option>Michoac&aacuten de Ocampo</option>
            <option>Morelos</option>
            <option>Nayarit</option>
            <option>Nuevo Le&oacuten</option>
            <option>Oaxaca</option>
            <option>Puebla</option>
            <option>Quer&eacutetaro</option>
            <option>Quintana Roo</option>
            <option>San Luis Potos&iacute</option>
            <option>Sinaloa</option>
            <option>Sonora</option>
            <option>Tabasco</option>
            <option>Tamaulipas</option>
            <option>Tlaxcala</option>
            <option>Veracruz</option>
            <option>Yucat&aacuten</option>
            <option>Zacatecas</option>
        </select>
    </div>
    <div class="col-md-3">
        <label for="municipalityInput" class="form-label">Municipality</label>
        <input type="text" class="form-control" id="municipalityInput" name="municipality" required>
    </div>
    <div class="col-md-1">
        <label for="zipInput" class="form-label">Zip</label>
        <input type="number" class="form-control" id="zipInput" name="postalCode" required>
    </div>
    <br/>
    <div class="col-12">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
            <label class="form-check-label" for="invalidCheck2">
                Agree to terms and conditions
            </label>
        </div>
    </div>
    <div align="center" class="col-12">
        <button class="btn btn-primary" type="submit">SUBMIT FORM</button>
    </div>
</form>
<h4 align="center">${messageSignup}</h4>
<h4 align="center">${idMessageSign}</h4>
<form action = "/">
    <div align="center">
        <br/>
        <button type="submit" class="btn btn-primary" name="btnBack" value="Back to login">BACK TO LOGIN</button>
    </div>
</form>
</body>
</html>