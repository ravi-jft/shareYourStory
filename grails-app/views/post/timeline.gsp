
<%@ page import="loginWithMail.Likepost" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>
       %{-- Timeline for ${user.fullName :
                user.firstname }--}%
    </title>
    <meta name="layout" content="myLayout"/>
</head>
<body>
Share Your Story
<div id="newPost">
    <h3>
        What is ${sec.loggedInUserInfo(field: 'username')} thinking right now?
        <br><br>
    </h3>
    <p>
        <g:form action="addPost">
            <g:textArea id='postContent' name="content"
                        rows="3" cols="50"/><br/>
            <g:submitButton name="post" value="Post"/>
        </g:form>
    </p>
</div>

<h4>Show All global Post........</h4>
<br><br>
<div id="allPosts">
    <g:each in="${post}" var="posts">
        <div class="postEntry">
            <div class="postText">
                ${posts.content}
            </div>
            <div class="postDate">
                ${post.dateCreated}
            </div>
        </div>
        <table>
            <tr>
                <td><a class="btn btn-default" href="<g:createLink controller="post" action="postlike" id="${posts.id}"/>" role="button" id="${posts.id}">Like</a>
                <a class="btn btn-default" href="#" role="button">Comment</a></td>
            </tr>
        </table><br/>
         ${Likepost.countByPost(posts)} Like
    </g:each>
    <g:paginate controller="post" action="timeline" next="Forward" prev="Back"  total = "${postCount}"/>
</div>

</body>
</html>