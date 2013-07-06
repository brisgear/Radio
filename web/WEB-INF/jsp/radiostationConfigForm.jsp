<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Проект радиостанция-фидер-антенна</title>
        <c:import url="import/globalResource.jsp"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/edit/radiostationConfig.js"></script>
    </head>
    <body>
        <div id="wrapper">
            <c:import url="import/header.jsp"/>
            <div id="main">
                <div class="title_table">Проект радиостанция-фидер-антенна</div>
                <form:form action="add" commandName="radiostationConfig">
                    <table class="form_table">
                        <tr>
                            <td class="first_td_form">Название проекта:</td>
                            <td><form:input path="identity" /></td>
                        </tr>
                        <tr>
                            <td class="first_td_form">Антенна :</td>
                            <td>
                                <form:select path="aerial.id">
                                    <form:options items="${aerialList}" itemValue="id" itemLabel="name" />
                                </form:select>
                            </td>

                        </tr>
                        <tr>
                            <td class="first_td_form">Фидер :</td>
                            <td>
                                <form:select path="cable.id">
                                    <form:options items="${cableList}" itemValue="id" itemLabel="name" />
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td class="first_td_form">Радиостанция :</td>
                            <td>
                                <form:select path="radiostation.id">
                                    <form:options items="${radiostationList}" itemValue="id" itemLabel="name" />
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td class="first_td_form">Длинна фидера, м :</td>
                            <td>
                                <form:input path="cableLength"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="first_td_form">Высота антенны, м :</td>
                            <td>
                                <form:input path="aerialHeight"/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" id="create" value="Создать" class="submit"></td>
                        </tr>
                    </table>
                </form:form>
                <c:if test="${fn:length(radiostationConfigList) > 0}">
                    <table id="resalt_table" cellpadding="5">
                        <tr>
                            <th>Название проекта</th>
                            <th>Антенна</th>
                            <th>Фидер</th>
                            <th>Радиостанция</th>
                            <th>Длинна фидера</th>
                            <th>Высота антенны</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${radiostationConfigList}" var="radiostationConfig" varStatus="status">
                            <tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
                                <td class="hidden">${radiostationConfig.id}</td>
                                <td>${radiostationConfig.identity}</td>
                                <td>${radiostationConfig.aerial.id}</td>
                                <td>${radiostationConfig.cable.id}</td>
                                <td>${radiostationConfig.radiostation.id}</td>
                                <td>${radiostationConfig.cableLength}</td>
                                <td>${radiostationConfig.aerialHeight}</td>
                                <td class="command">
                                    <form:form method="PUT" action=""><input type="button" id="edit" value="Изменить" class="command_edit"></form:form>
                                    <form:form method="DELETE" action="delete/${radiostationConfig.id}"><input type="submit" value="Удалить" class="command_del"></form:form>
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
