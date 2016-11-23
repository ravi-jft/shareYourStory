<%@ page import="loginWithMail.NavMenu" %>



<div class="fieldcontain ${hasErrors(bean: navMenuInstance, field: 'category', 'error')} required">
	<label for="category">
		<g:message code="navMenu.category.label" default="Category" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="category" required="" value="${navMenuInstance?.category}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: navMenuInstance, field: 'products', 'error')} ">
	<label for="products">
		<g:message code="navMenu.products.label" default="Products" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${navMenuInstance?.products?}" var="p">
    <li><g:link controller="product" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="product" action="create" params="['navMenu.id': navMenuInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'product.label', default: 'Product')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: navMenuInstance, field: 'parent', 'error')} ">
	<label for="parent">
		<g:message code="navMenu.parent.label" default="Parent" />
		
	</label>
	<g:select id="parent" name="parent.id" from="${loginWithMail.NavMenu.list()}" optionKey="id" value="${navMenuInstance?.parent?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: navMenuInstance, field: 'admin', 'error')} required">
	<label for="admin">
		<g:message code="navMenu.admin.label" default="Admin" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="admin" name="admin.id" from="${loginWithMail.User.list()}" optionKey="id" required="" value="${navMenuInstance?.admin?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: navMenuInstance, field: 'subItems', 'error')} ">
	<label for="subItems">
		<g:message code="navMenu.subItems.label" default="Sub Items" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${navMenuInstance?.subItems?}" var="s">
    <li><g:link controller="navMenu" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="navMenu" action="create" params="['navMenu.id': navMenuInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'navMenu.label', default: 'NavMenu')])}</g:link>
</li>
</ul>


</div>

