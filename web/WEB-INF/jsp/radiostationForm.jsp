<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Радиостанции</title>
        <c:import url="import/globalResource.jsp"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/edit/radiostation.js"></script>
    </head>
    <body>
        <div id="wrapper">
            <c:import url="import/header.jsp"/>
            <div id="main">
                <div class="title_table">Радиостанции</div>
                <form:form action="add" commandName="radiostation">
                    <table class="form_table">
                        <tr>
                            <td class="first_td_form">Название:</td>
                            <td><form:input path="name" /></td>
                        </tr>

                        <tr>
                            <td class="first_td_form">Мощность, Вт :</td>
                            <td><form:input path="power" /></td>
                        </tr>
                        <tr>
                            <td class="first_td_form">Тип радиостанции:</td>
                            <td><form:radiobutton path="type" value="0" label="Станционная" /> 
                        </tr>
                        <tr>
                            <td></td>
                            <td><form:radiobutton path="type" value="1" label="Возимая" /> 
                        </tr>
                        <tr>
                            <td></td>
                            <td><form:radiobutton path="type" value="2" label="Носимая" /> 
                        </tr>
                        <tr>
                            <td class="first_td_form">Частотный диапазон, МГц :</td>
                            <td><form:input path="cutoff" /></td>
                        </tr>
                        <tr>
                            <td class="first_td_form">Уровень срабатывания шумоподовителя, мкВ :</td>
                            <td><form:input path="frequencyRange" /></td>
                        </tr>
                        <tr>
                            <td class="first_td_form">Чувствительность, мкВ :</td>
                            <td><form:input path="sensitivity" /></td>
                        </tr>
                        <tr>
                            <td class="first_td_form">Двухсигнальная избирательность, Дб :</td>
                            <td><form:input path="selectivity2" /></td>
                        </tr>
                        <tr>
                            <td class="first_td_form">Трёхсигнальная избирательность, Дб :</td>
                            <td><form:input path="selectivity3" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" id="create" value="Создать" class="submit"></td>
                        </tr>
                    </table>
                </form:form>
                <c:if test="${fn:length(radiostationList) > 0}">
                    <table id="resalt_table" cellpadding="5">
                        <tr>
                            <th>Название радиостанции</th>
                            <th>Мощность</th>
                            <th>Тип</th>
                            <th>Частотный диапазон</th>
                            <th>Уровень сраб. шумоподавителя</th>
                            <th>Чувствительность</th>
                            <th>Двухсигнальная избирательность</th>
                            <th>Трёхсигнальная избирательность</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${radiostationList}" var="radiostation" varStatus="status">
                            <tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
                                <td class="hidden">${radiostation.id}</td>
                                <td>${radiostation.name}</td>
                                <td>${radiostation.power}</td>
                                <td>${radiostation.type}</td>
                                <td>${radiostation.cutoff}</td>
                                <td>${radiostation.frequencyRange}</td>
                                <td>${radiostation.sensitivity}</td>
                                <td>${radiostation.selectivity2}</td>
                                <td>${radiostation.selectivity3}</td>
                                <td class="command">
                                    <form:form method="PUT" action=""><input type="button" id="edit" value="Изменить" class="command_edit"></form:form>
                                    <form:form method="DELETE" action="delete/${radiostation.id}"><input type="submit" value="Удалить" class="command_del"></form:form>
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
