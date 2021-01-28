<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:actionURL var="addEmployeee" name="addEmployee">
</portlet:actionURL>

<h2>Add Employee !</h2>
<aui:form action="<%=addEmployeee%>" name="addEmployee" method="POST">
	<!--	<aui:input name="id" >
 		<aui:validator name="required"/>
 		<aui:validator name="alphanum"/>
	</aui:input> -->
	<aui:input name="name">
		<aui:validator name="required" />
		<aui:validator name="alpha" />
	</aui:input>
	<aui:input name="number">
		<aui:validator name="required" />
		<aui:validator name="string" />
	</aui:input>
	<aui:button type="submit" name="" value="addEmployee"></aui:button>
</aui:form>






