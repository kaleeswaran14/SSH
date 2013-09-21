<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>
 
<body>
<h1>Struts 2 + Spring + Hibernate integration example</h1>

<h2>Add Customer</h2>
<s:form action="addCustomerAction" >
<s:hidden name="customer.uid" theme="simple"/>
  <s:textfield name="customer.name" label="Name" />
  <s:textfield name="customer.address.phoneNumber" label="Phone" />
  <s:textfield name="customer.address.street" label="Street" />
  <s:textfield name="customer.address.city" label="City" />
  <s:textfield name="customer.address.country" label="Country" />
<%--   <s:textfield name="customer.tickets[0].ticketId" label="TicketId" /> --%>
<%--   <s:textarea name="customer.address" label="Address" value="" cols="50" rows="5" /> --%>
  <s:submit />
</s:form>

<h2>All Customers</h2>

<s:if test="customerList.size() > 0">
<table border="1px" cellpadding="8px">
	<tr>
		<th>Customer Id</th>
		<th>Name</th>
		<th>Address</th>
		<th>Created Date</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<s:iterator value="customerList" status="userStatus">
		<tr>
			<td><s:property value="uid" /></td>
			<td><s:property value="name" /></td>
			<td><s:property value="address.street" /></td>
			<td><s:date name="registrationDate" format="dd/MM/yyyy" /></td>
			<td><a href="editCustomerAction?uid=<s:property value="uid"/>">edit</a></td>
			<td><a href="deleteCustomerAction?uid=<s:property value="uid"/>">delete</a></td>
		</tr>
	</s:iterator>
</table>
</s:if>
<br/>
<br/>

</body>
</html>