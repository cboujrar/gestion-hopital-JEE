<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.min.css">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.min.css">
    <link href="css/animate.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <!-- boxed bg -->
    <link id="bodybg" href="bodybg/bg1.css" rel="stylesheet" type="text/css" />
    <!-- template skin -->
    <link id="t-colors" href="color/default.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="style2.css">


</head>
<style type="text/css">
    .bg-skin {
        background: #0062cc;

    }


    .nav>li>a:hover, .nav>li>a:focus {
        text-decoration: none;
        background-color: #251f1f00;
        padding-bottom: 10px;
        padding-top: 10px;
        /* color: blue; */
    }

    .btn-skin {
        background-color: #0062cc;
        border-color: #0062cc;
    }

    .box h4 {
        font-size: 24px;
        color: white;
        font-family: 'IBM Plex Sans', sans-serif;
    }

    .service-desc h5 {
        margin-bottom: 10px;
        color: white;
        font-family: 'IBM Plex Sans', sans-serif;
    }

    #inputbtn:hover {
        cursor: pointer;
    }

    .card {
        background: #f8f9fa;
        border-top-left-radius: 5% 5%;
        border-bottom-left-radius: 5% 5%;
        border-top-right-radius: 5% 5%;
        border-bottom-right-radius: 5% 5%;
    }

</style>
<body style="background: -webkit-linear-gradient(left, #3931af, #00c6ff); background-size: cover;">
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">

    <a class="navbar-brand js-scroll-trigger" href=# style="margin-top: 0px;font-family: 'IBM Plex Sans', sans-serif;"><h5
                style="color: white;">&nbsp GLOBAL HOSPITALS</h5></a>

</nav>


<div class="container-fluid" style="margin-top:60px;margin-bottom:60px;color:#34495E;">
    <div class="row">


        <div class="col-md-7" style="padding-left: 180px; ">
            <div style="-webkit-animation: mover 2s infinite alternate;
    animation: mover 1s infinite alternate;">
                <img src="images/ambulance1.png" alt=""
                     style="width: 20%;padding-left: 40px;margin-top: 150px;margin-left: 45px;margin-bottom:15px">
            </div>

            <div style="color: white;">
                <h4 style="font-family: 'IBM Plex Sans', sans-serif;"> We are here for you!</h4>
            </div>

        </div>

        <div class="col-md-4" style="margin-top: 5%;right: 8%">
            <div class="card" style="font-family: 'IBM Plex Sans', sans-serif;">
                <div class="card-body">
                    <center>
                        <i class="fa fa-hospital-o fa-3x" aria-hidden="true" style="color:#0062cc"></i>
                        <br>
                        <h3 style="margin-top: 10%">Sign Up</h3><br>
                        <form class="form-group" method="POST" action="inscreption">
                            <div class="row" style="margin-top: 10%">
                                <div class="col-md-4"><label>Nom: </label></div>
                                <div class="col-md-8"><input type="text" name="nom" class="form-control" placeholder="Enter your name" required/></div><br><br>
                                <div class="col-md-4"><label>Prenom: </label></div>
                                <div class="col-md-8"><input type="text" name="prenom" class="form-control" placeholder="Enter your last name" required/></div><br><br>
                                <div class="col-md-4"><label>Email: </label></div>
                                <div class="col-md-8"><input type="email" name="email" class="form-control" placeholder="Enter your email" required/></div><br><br>
                                <div class="col-md-4"><label>Password: </label></div>
                                <div class="col-md-8"><input type="password" name="passs" class="form-control" placeholder="Enter your password" required/></div><br><br><br>
                            </div>
                            <div class="row">
                                <div class="col-md-4"  style="padding-left: 160px;margin-top: 10%">
                                    <center><input type="submit" id="inputbtn" name="signup" value="Sign Up" class="btn btn-primary"></center>
                                </div>
                            </div>
                            <a href="Logine.jsp" color="red">SinUp</a>
                        </form>
                    </center>
                </div>
            </div>
        </div>


    </div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>


</body>
</html>