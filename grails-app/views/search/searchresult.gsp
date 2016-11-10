
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
%{--<g:if test="${searchResult?.results}">--}%
    <g:each var="result" in="${searchResult}">
        %{--<div class="searchPost">--}%
            %{--<div class="searchFrom">
                <g:link controller="post"
                        action="${result.user.username}">
                    ${result.user.username}
                </g:link>
            </div>--}%
            %{--<div class="searchContent">--}%
                ${result.content}
           %{-- </div>--}%
        %{--</div>--}%
    </g:each>
%{--</g:if>--}%
</body>
</html>