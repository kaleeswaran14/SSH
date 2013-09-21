<?xml version="1.0" ?>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
<title>Struts 2 + Spring + Hibernate integration example</title>
</head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<sj:head jqueryui="true" locale="en" loadAtOnce="true"
	defaultIndicator="indicator" />
<sb:head includeStylesResponsive="true" />
<body>
	<div class="container-fluid" id="formResult">
		<div class="row-fluid">
			<div class="span12">
				<h3 class="text-center text-info">
					Struts 2 + Spring + Hibernate integration example <img
						id="indicator" src="<s:url value="/img/indicator.gif" />"
						style="display: none;" />
				</h3>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span6">
				<form class="form-search">
					<H4>Search</H4>
					<input type="text" name="phoneNumber"
						placeholder="Enter Phone Number" class="input-medium search-query" />
					<button type="button" class="btn">Search</button>
				</form>
			</div>
			<div class="span6">
				<form class="form-horizontal">
					<H4>Customer</H4>
					<div class="control-group">
						<label class="control-label" for="inputEmail">Name</label>
						<div class="controls">
							<input type="text" id="inputEmail" name="customer.name" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword">PhoneNumber</label>
						<div class="controls">
							<input type="password" id="inputPassword"
								name="customer.address.phoneNumber" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputAddreess">Address</label>
						<div class="controls">
							<textarea cols="50" rows="5" name="customer.address.street"
								id="inputAddreess"></textarea>
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<s:url id="ajaxTest" value="/addCustomerAction.action" />
							<button type="button" class="btn">Register</button>
							<%-- 							<sj:submit id="formSubmit2" href="%{ajaxTest}" targets="formResult" value="Register" indicator="indicator" button="true" /> --%>
						</div>
					</div>
				</form>
				<s:form id="form" action="echo" theme="simple">
					<fieldset>
						<legend>AJAX Form</legend>
						<div class="type-text">
							<label for="echo">Echo: </label>
							<s:textfield id="echo" name="echo" value="Hello World!!!" />
						</div>
						<div class="type-button">
							<sj:submit id="formS" targets="formResult"
								value="AJAXSubmit" indicator="indicator" button="true" />
							<s:url id="simpleecho" value="/simpleecho.action" />
							<sj:submit id="formS2" href="%{simpleecho}"
								targets="formResult" value="AJAXSubmit2" indicator="indicator"
								button="true" />
								
								<sj:submit
									cssClass="btn btn-primary"
									value="Save"
									formIds="todoEditForm"
									targets="todoListContent"
									onCompleteTopics="/todo/dialog/close"
							        validate="true"
							        validateFunction="bootstrapValidation"
							/>
							
							<sj:a id="ajaxlink" 
                href="/" 
                targets="result" 
                indicator="indicator" 
                button="true" 
                buttonIcon="ui-icon-refresh"
        >
                Run AJAX Action
        </sj:a>
							
						</div>
					</fieldset>
				</s:form>

			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<s:if test="customerList.size() > 0">
					<H4>
						Customer Lists
						<button class="btn" type="button" contenteditable="true">Create</button>
					</H4>
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>Name</th>
								<th>Address</th>
								<th>Created Date</th>
								<th>Operation</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="customerList" status="userStatus">
								<tr>
									<td>1</td>
									<td><s:property value="name" /></td>
									<td><s:property value="address.street" /></td>
									<td><s:date name="registrationDate" format="dd/MM/yyyy" />
									</td>
									<td>
										<button class="btn" type="button" contenteditable="true">Edit</button>
										<button class="btn" type="button" contenteditable="true">Delete</button>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</s:if>
				<s:else>
					<h4>
						No customer found for this phone number :
						<s:property value="phoneNumber" />
					</h4>
				</s:else>
			</div>
		</div>
	</div>

</body>
</html>