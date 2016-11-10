<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Pure CSS Blurred Video Background Login Box. (fork)</title>

        <asset:stylesheet rel="stylesheet" href="css/style.css"/>
  </head>

  <body>

    <div class="vid-container">
  <video id="Video1" class="bgvid back" autoplay="false" muted="muted" preload="auto" loop>
      <source src="http://shortcodelic1.manuelmasiacsasi.netdna-cdn.com/themes/geode/wp-content/uploads/2014/04/milky-way-river-1280hd.mp4.mp4" type="video/mp4">
  </video>
  <div class="inner-container">
    <video id="Video2" class="bgvid inner" autoplay="false" muted="muted" preload="auto" loop>
      <source src="http://shortcodelic1.manuelmasiacsasi.netdna-cdn.com/themes/geode/wp-content/uploads/2014/04/milky-way-river-1280hd.mp4.mp4" type="video/mp4">
    </video>
    <div class="box">
      <h1>Login</h1>
      <form action='${postUrl}' method='POST' role="form" autocomplete="off">
        <input type="text" name='j_username' placeholder="Username"/>
        <input type="text" name='j_password' placeholder="Password"/>
        <div class="checkbox">
          <label>
            <input type="checkbox" name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/> Remember me
          </label>
        </div>
        <button type="submit" class="login-btn"  value='${message(code: "springSecurity.login.button")}'>Login</button>
      </form>
      <p>Not a member?<a href="<g:createLink controller="user" action="register"/> ">SignUp</a></p>

    </div>
  </div>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
  </body>
</html>
