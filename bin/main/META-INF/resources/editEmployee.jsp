<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:actionURL name="updateEmployee" var="editEmployeeAction">
</portlet:actionURL>

<%
	long empId = ParamUtil.getLong(renderRequest, "id");
	Employee emp = EmployeeLocalServiceUtil.getEmployee(empId);
%>
<h3>
	Edit Employee:
	<%=emp.getName()%></h3>

<aui:form action="<%=editEmployeeAction%>" method="POST" name="name">
	<aui:input name="id" type="hidden" value="<%=emp.getId()%>" />
	<aui:input name="name" type="text" value="<%=emp.getName()%>" />
	<aui:input name="number" type="number" value="<%=emp.getNumber()%>" />
	<aui:input type="submit" value="Update" name="update"></aui:input>
</aui:form>