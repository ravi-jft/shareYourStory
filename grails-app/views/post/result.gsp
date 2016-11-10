<%--
  Created by IntelliJ IDEA.
  User: ravi
  Date: 7/11/16
  Time: 11:52 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
%{--<g:if test="${searchResult?.results}">
    <g:each var="result" in="${searchResult.results}">
        <div class="searchPost">
            <div class="searchFrom">
                <g:link controller="post"
                        action="${result.user.loginId}">
                    ${result.user.loginId}
                </g:link>
            </div>
            <div class="searchContent">
                ${result.content}
            </div>
        </div>
    </g:each>
</g:if>--}%
%{--<g:if test="${searchResult}">--}%
    <g:each var="result" in="${searchResult.results}">
            ${result.content}
    </g:each>
%{--</g:if>--}%
</body>
</html>