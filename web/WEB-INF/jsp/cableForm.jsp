<%-- 
    Document   : aerialForm
    Created on : Mar 31, 2012, 12:00:22 PM
    Author     : Bris
--%>
<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Фидеры</title>
        <c:import url="import/globalResource.jsp"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/edit/cable.js"></script>
    </head>
    <body>
        <div id="wrapper">
            <c:import url="import/header.jsp"/>
            <div id="main">
                <div class="title_table">Фидеры</div>
                <form:form action="add" commandName="cable">
                    <table class="form_table">
                        <tr>
                            <td class="first_td_form">Название :</td>
                            <td><form:input path="name" /></td>
                        </tr>
                        <tr>
                            <td class="first_td_form">Затухание, дБ\м :</td>
                            <td><form:input path="fade" /></td>
                        </tr>

                        <tr>
                            <td></td>
                            <td><input type="submit" id="create" value="Создать" class="submit"></td>
                        </tr>
                    </table>
                </form:form>
                <c:if test="${fn:length(cableList) > 0}">
                    <table id="resalt_table" cellpadding="5">
                        <tr>
                            <th>Название</th>
                            <th>Затухание</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${cableList}" var="cable" varStatus="status">
                            <tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
                                <td class="hidden">${cable.id}</td>
                                <td>${cable.name}</td>
                                <td>${cable.fade}</td>

                                <td class="command">
                                    <form:form method="PUT" action=""><input type="button" id="edit" value="Изменить" class="command_edit"></form:form>
                                    <form:form method="DELETE" action="delete/${cable.id}"><input type="submit" value="Удалить" class="command_del"></form:form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </div>
            <c:import url="import/footer.jsp"/>
        </div>
    </body>
</html>
