<%@ include file="init.jsp"%>
<portlet:defineObjects />
<%
	List<Employee> employee = EmployeeLocalServiceUtil.getEmployees(0,
			EmployeeLocalServiceUtil.getEmployeesCount());
%>

<liferay-portlet:renderURL var="addEmployee">
	<portlet:param name="jspPage" value="/employee.jsp" />
</liferay-portlet:renderURL>
<aui:button type="submit" name="" value="addEmployee"
	onClick="<%=addEmployee%>" />
<br>
<br>
<br>

<table class="myTable3">
	<tr class="myTable3">
		<th class="myTable">Name</th>
		<th class="myTable">Number</th>
		<th class="myTable1">Edit</th>
		<th class="myTable1">Delete</th>
	</tr>
	<%
		for (Employee st : employee) {
	%>
	<tr class="myTable3">
		<td class="myTable"><%=st.getName()%></td>
		<td class="myTable"><%=st.getNumber()%></td>

		<liferay-portlet:renderURL var="editEmployee">
			<portlet:param name="jspPage" value="/employee.jsp" />
			<portlet:param name="id" value="<%=String.valueOf(st.getId())%>" />
		</liferay-portlet:renderURL>

		<portlet:actionURL name="deleteEmployee" var="deleteEmployeeActionURL">
			<portlet:param name="id" value="<%=String.valueOf(st.getId())%>" />
		</portlet:actionURL>

		<td class="myTable1"><aui:button name="" value="Update"
				onClick="<%=editEmployee%>"></aui:button></td>

		<td class="myTable1"><aui:button name="" value="Delete"
				onClick="<%=deleteEmployeeActionURL%>"></aui:button></td>

	</tr>
	<%
		}
	%>
</table>
<br>
<br>

<style>
.myTable {
	border: solid;
	border-width: 1px;
	width: 15%;
	text-align: center;
	"
}

.myTable1 {
	border: solid;
	border-width: 1px;
	width: 10%;
	text-align: center;
	"
}

.myTable3 {
	border: solid;
	border-width: 1px;
	width: 100%;
	text-align: center;
	"
}

.control-group .input-text-wrapper {
	margin-bottom: -1%;
}
</style>
