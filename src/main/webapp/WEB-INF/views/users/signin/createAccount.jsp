<%@page import="org.springframework.security.web.WebAttributes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div>
	<form:form modelAttribute="user">
		<fieldset>
			<legend>Subscription</legend>
			<p>
				<label for="s_username">Username:</label>
				<br/>
				<form:input type="text" name="s_username" id="s_username" path="username"/>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "s_username",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { promptMessage : "Your username", required : true, invalidMessage : "The username should be more than 2-characters long.", regExp : "[a-zA-Z0-9][a-zA-Z0-9]+" }}));
				</script>
				<br/>
				<label for="s_password">Password:</label>
				<br/>
				<form:input type="password" name="s_password" id="s_password" path="password"/>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "s_password",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { promptMessage : "Your password", required : true}}));
				</script>
				<br/>
				<button id="proceed" name="_eventId_proceed" type="submit">Sign In</button>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ValidateAllDecoration({event : 'onclick', elementId : 'proceed'}));
					Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'proceed',event:'onclick',formId:'user',params:{fragments:'body'}}));
				</script>
				<br/>
			</p>
		</fieldset>
	</form:form>
</div>