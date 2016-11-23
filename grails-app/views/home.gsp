
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
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">${sec.loggedInUserInfo(field: 'username')}<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<g:createLink controller="user" action="show"/>">Profile</a></li>
            <li><a href="#">Page 1-2</a></li>
                <ul class="right-menu">
                   <li><a href="#">page 1.1</a> </li>
                </ul>
            <li><a href="#">Page 1-3</a></li>
          </ul>
        </li>
        <li><a href="<g:createLink controller="navMenu" action="createCategory"/>">Create Category</a></li>
        <li><a href="<g:createLink controller="product" action="insertProduct"/>">Add Product</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="<g:createLink controller="logout"/>"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
      </ul>
    </div>
  </div>
</nav>



<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header"  style="background-image:url('${resource(dir: "../grails-app/assets/images/img", file: "home-bg.jpg")}');">
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <div class="site-heading">
          <h1>My Story</h1>
          <hr class="small">
          <span class="subheading">Share Your Story With World</span>
        </div>
      </div>
    </div>
  </div>
</header>

<!-- Main Content -->
<div class="container">
  <div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
      <div class="post-preview">
        <a href="post.html">
          <h2 class="post-title">
            Man must explore, and this is exploration at its greatest
          </h2>
          <h3 class="post-subtitle">
            Problems look mighty small from 150 miles up
          </h3>
        </a>
        <p class="post-meta">Posted by <a href="#">Start Bootstrap</a> on September 24, 2014</p>
      </div>
      <hr>
      <div class="post-preview">
        <a href="post.html">
          <h2 class="post-title">
            I believe every human has a finite number of heartbeats. I don't intend to waste any of mine.
          </h2>
        </a>
        <p class="post-meta">Posted by <a href="#">Start Bootstrap</a> on September 18, 2014</p>
      </div>
      <hr>
      <div class="post-preview">
        <a href="post.html">
          <h2 class="post-title">
            Science has not yet mastered prophecy
          </h2>
          <h3 class="post-subtitle">
            We predict too much for the next year and yet far too little for the next ten.
          </h3>
        </a>
        <p class="post-meta">Posted by <a href="#">Start Bootstrap</a> on August 24, 2014</p>
      </div>
      <hr>
      <div class="post-preview">
        <a href="post.html">
          <h2 class="post-title">
            Failure is not an option
          </h2>
          <h3 class="post-subtitle">
            Many say exploration is part of our destiny, but it’s actually our duty to future generations.
          </h3>
        </a>
        <p class="post-meta">Posted by <a href="#">Start Bootstrap</a> on July 8, 2014</p>
      </div>
      <hr>
      <!-- Pager -->
      <ul class="pager">
        <li class="next">
          <a href="#">Older Posts &rarr;</a>
        </li>
      </ul>
    </div>
  </div>
</div>

<hr>

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

</body>

</html>