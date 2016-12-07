<%@ page import="loginWithMail.Product" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Clean Blog</title>

  %{--Add navBar files--}%
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <!-- Bootstrap Core CSS -->
  <asset:stylesheet href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

  <!-- Theme CSS -->
  <asset:stylesheet href="css/clean-blog.min.css" rel="stylesheet"/>

  <!-- Custom Fonts -->
  <asset:stylesheet href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
  <asset:stylesheet href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'/>
  <asset:stylesheet href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'/>

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="http://localhost:8080/delhiShopApp3">Home</a></li>
        <li><a href="<g:createLink controller="product" action="showcart"/>">Your Cart</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
       %{-- <li><a href="<g:createLink controller="login" action="auth"/>"><span class="glyphicon glyphicon-user"></span> Login</a></li>--}%
        <li><a href="<g:createLink controller="user" action="home"/>"><span class="glyphicon glyphicon-user"></span> Login</a></li>
        <li><a href="<g:createLink controller="user" action="register"/>"><span class="glyphicon glyphicon-log-in"></span> Sign UP</a></li>
      </ul>
    </div>
  </div>
</nav>



<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header"  style="background-image:url('${resource(dir: "/images", file: "shop11.jpg")}');">
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <div class="site-heading">
          <h1>Delhi Shopping App</h1>
          <hr class="small">
          <span class="subheading">Shopping Here At Cheapest Price with Good Quality</span>
        </div>
      </div>
    </div>
  </div>
</header>

<!-- Main Content -->

<g:each in="${0..<Product.list().size()/4}">
  <g:each in="${Product.list()}" var="i" >
    <div class="col-md-3" >
      <div class="content"><a href="details.gsp">
        <g:img width="150" height="150" dir="productImages" file="${i.productImage}" class="img-responsive" alt=""/>
      </a>
        <h4><a href="details.html">${i.id}</a></h4>
        <div class="item_add"><span class="item_price"><h6>ONLY $${i.price}</h6></span></div>
        %{--use hidden field--}%
    %{--   <div>
        ---}%%{--<g:form controller="product" action="savecart">--}%%{--
           <g:hiddenField name="${i.id}" value="${i.id}" id="id"/><br>
           <g:hiddenField name="${i.name}" value="${i.name}" id="name"/><br>
           <g:hiddenField name="${i.price}" value="${i.price}" id="price"/><br>
           <g:hiddenField name="${i.productImage}" value="${i.productImage}" id="productImage"/>
           <input type="button" value="Add To Cart" onclick="save()"/>
         --}%%{--</g:form>--}%%{--
        </div>--}%
        <td> <g:link controller="product" action="savelocal" params='[productname:"${i.name}",price:"${i.price}",productimage:"${i.productImage}",id:"${i.id}"]'>Add To Cart</g:link> </td>
      </div>
    </div>
  </g:each>
</g:each>

<!-- Footer -->
<footer>
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <ul class="list-inline text-center">
          <li>
            <a href="#">
              <span class="fa-stack fa-lg">
                <i class="fa fa-circle fa-stack-2x"></i>
                <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
              </span>
            </a>
          </li>
          <li>
            <a href="#">
              <span class="fa-stack fa-lg">
                <i class="fa fa-circle fa-stack-2x"></i>
                <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
              </span>
            </a>
          </li>
          <li>
            <a href="#">
              <span class="fa-stack fa-lg">
                <i class="fa fa-circle fa-stack-2x"></i>
                <i class="fa fa-github fa-stack-1x fa-inverse"></i>
              </span>
            </a>
          </li>
        </ul>
        <p class="copyright text-muted">Copyright &copy; Your Website 2016</p>
      </div>
    </div>
  </div>
</footer>

<!-- jQuery -->
<script src="vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="js/jqBootstrapValidation.js"></script>
<script src="js/contact_me.js"></script>

<!-- Theme JavaScript -->
<script src="js/clean-blog.min.js"></script>

%{--<script>
  function save(){
    var id =    document.getElementById('id').value;
    var name =  document.getElementById('name').value;
    var price = document.getElementById('price').value;
    var image=  document.getElementById('productImage').value;

      objects={
      "name":name,
      "price":price,
      "image":image
    };
    localStorage.setItem(1+i,JSON.stringify(objects));
  };

</script>--}%

</body>

</html>