<%@page import="org.springframework.security.web.WebAttributes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div>
	<form action="subscribe">
		<fieldset>
			<legend>Subscription</legend>
			<p>
				<label for="s_username">Username:</label>
				<br/>
				<input type="text" name="s_username" id="s_username"/>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "s_username",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { promptMessage : "Your username", required : true, invalidMessage : "The username should be more than 2-characters long.", regExp : "[a-zA-Z0-9][a-zA-Z0-9]+" }}));
				</script>
				<br/>
				<label for="s_password">Password:</label>
				<br/>
				<input type="text" name="s_password" id="s_password"/>
				<br/>
				<button id="submit" type="submit">Sign In</button>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ValidateAllDecoration({event : 'onclick', elementId : 'submit'}));
				</script>
				<br/>
			</p>
		</fieldset>
	</form>
</div>