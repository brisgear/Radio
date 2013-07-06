<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Расчёт дальности радиосвязи</title>
        <c:import url="import/globalResource.jsp"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/calculation1.js"></script>
    </head>

    <body>
        <div id="wrapper">
            <c:import url="import/header.jsp"/>
            <div id="main">
                <div class="title_table">Расчёт дальности радиосвязи</div>
                <form:form action="go" commandName="problem">
                    <div class="border">
                        <table class="form_table">
                            <tr>
                                <th>Исходные данные </td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="first_td_form">Канал для расчёта :</td>
                                <td>
                                    <form:select path="radiostationType.type1">
                                        <option value="-1"> - </option>
                                        <c:forEach items="${typeRadiostation}" var="item" varStatus="itemInfo">
                                    <option value="${itemInfo.index}">${item}</option>
                                </c:forEach>
                            </form:select>
                            </td>
                            </tr>
                            <tr>
                                <td class="first_td_form">Надёжность радиосвязи, % :</td>
                                <td><form:input path="quality" value="95.0"/></td>
                            </tr>
                            <tr>
                                <td class="first_td_form">Тип трассы :</td>
                                <td><form:radiobutton path="trackType" value="0" label="Открытая трасса"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><form:radiobutton path="trackType" value="1" label="Закрытая трасса в городе"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><form:radiobutton path="trackType" value="2" label="Закрытая трасса на ж.д. участке"/></td>
                            </tr>
                        </table>
                    </div>
                    <div class="border">
                        <table class="form_table">
                            <tr>
                                <th>Характеристики радиостанций </td>
                                <td class="from">-</td>
                                <td class="to">-</td>
                            </tr>
                            <tr>
                                <td class="first_td_form">Название в проекте :</td>
                                <td>
                                    <form:select path="config1.id">
                                        <form:option value=" - "/>
                                    </form:select>
                                </td>
                                <td>
                                    <form:select path="config2.id">
                                        <form:option value=" - "/>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td class="first_td_form">Мощность, Вт :</td>
                                <td><form:input path="config1.radiostation.power" disabled="true"/></td>
                                <td><form:input path="config2.radiostation.power" disabled="true"/></td>
                            </tr>
                            <%--<tr>
                                <td class="first_td_form">U2 min, дБ :</td>
                                <td>Первое поле</td>
                                <td>Второе поле</td>
                            </tr>--%>
                            <tr>
                                <td class="first_td_form">Удельное затухание фидера,дБ/м :</td>
                                <td><form:input path="config1.cable.fade" disabled="true"/></td>
                                <td><form:input path="config2.cable.fade" disabled="true"/></td>
                            </tr>
                            <tr>
                                <td class="first_td_form">Длина фидера, м :</td>
                                <td><form:input path="config1.cableLength"/></td>
                                <td><form:input path="config2.cableLength"/></td>
                            </tr>
                            <tr>
                                <td class="first_td_form">Высота антенны, м :</td>
                                <td><form:input path="config1.aerialHeight"/></td>
                                <td><form:input path="config2.aerialHeight"/></td>
                            </tr>
                            <tr>
                                <td class="first_td_form">Коэффициент усиления, дБ :</td>
                                <td><form:input path="config1.aerial.amp" disabled="true"/></td>
                                <td><form:input path="config2.aerial.amp" disabled="true"/></td>
                            </tr>
                        </table>
                    </div>
                    <div class="border">
                        <table class="form_table result_table">
                            <tr>
                                <th>Результаты расчётов    </td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td style="text-align: center">Радиоканал</td>
                                <td><b><span class="from"> </span> -> <span class="to"> </span></b></td>
                                <td><b><span class="to"> </span> <- <span class="from"> </span></b></td>
                            </tr>
                            <tr>
                                <td class="first_td_form">Дальность радиосвязи, км :</td>
                                <td id="td_result1"><div id="result1">&nbsp;</div></td>
                                <td><div id="result2">&nbsp;</div></td>
                            </tr>
                            <tr>
                                <td><div id="ajax_loader" class="hidden"></div></td>
                                <td><input type="button" value="Расчёт" class="submit" id="calculate"></td>
                                <td></td>
                            </tr>
                        </table>
                    </div>
                   <form:hidden path="config1.radiostation.id"/>  
                   <form:hidden path="config1.cable.id"/>
                   <form:hidden path="config1.aerial.id"/>
                </form:form>
            </div>
            <c:import url="import/footer.jsp"/>
        </div>
        
    </body>
</html>
