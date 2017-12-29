<!DOCTYPE html>
<html lang="en">
<head>
  <title>Docker Customer App</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center">
  <h1>Customer Docker, Microservices App</h1> 
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <h3>Customer Details</h3>
      	Customer Name: <b style="color: red">${customerName}</b>
    </div>
    <div class="col-sm-4">
      <h3>Order Details</h3>
      Product Name: <b style="color: red">${orderDetails}</b>
    </div>
  </div>
</div>

</body>
</html>