
<%@ page import="loginWithMail.NavMenu" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'navMenu.label', default: 'NavMenu')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-navMenu" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-navMenu" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="category" title="${message(code: 'navMenu.category.label', default: 'Category')}" />
					
						<th><g:message code="navMenu.parent.label" default="Parent" /></th>
					
						<th><g:message code="navMenu.admin.label" default="Admin" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${navMenuInstanceList}" status="i" var="navMenuInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${navMenuInstance.id}">${fieldValue(bean: navMenuInstance, field: "category")}</g:link></td>
					
						<td>${fieldValue(bean: navMenuInstance, field: "parent")}</td>
					
						<td>${fieldValue(bean: navMenuInstance, field: "admin")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${navMenuInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
