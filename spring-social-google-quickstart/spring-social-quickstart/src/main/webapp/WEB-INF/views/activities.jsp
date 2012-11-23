<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:form="http://www.springframework.org/tags/form">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <!DOCTYPE html> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<title>Spring Social Google - Activities</title>
<jsp:directive.include file="header.jspf" />
</head>

<body>
	<c:set var="selected" value="plus" />
	<c:set var="subselected" value="activities" />
	<jsp:directive.include file="bar.jspf" />

	<div class="container">
	
		<jsp:directive.include file="plusops.jspf" />
		
		<h1>Activities</h1>
		
		<jsp:directive.include file="activitiesform.jspf"/>
		
		<c:if test="${not empty activities.items}">

			<c:forEach items="${activities.items}" var="activity">
				<div class="activity">
					<jsp:directive.include file="activitycontent.jspf"/>
					<br/>
					<a href="activity?id=${activity.id}">Show activity by itself</a>
				</div>
			</c:forEach>				

			<c:if test="${not empty activities.nextPageToken}">
				<p class="pull-right"><a href="activities?${not empty param.text ? 'text=' : ''}${param.text}&amp;pageToken=${activities.nextPageToken}"><![CDATA[Next Page &rarr;]]></a></p>
			</c:if>
		</c:if>
		<c:if test="${(empty activities.items) and (not empty param.text)}">
			<div>No activities were found for search criteria</div>
		</c:if>
	</div>
</body>
</html>
</jsp:root>