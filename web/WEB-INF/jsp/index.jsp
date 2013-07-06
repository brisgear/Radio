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
    </head>

    <body>
        <div id="wrapper">
            <c:import url="import/header.jsp"/>
            <div id="main">
                <div class="title_table">Главная</div>
                <p>Тут много важного текста... Что-то про логин, поиск, копирайт, реклама XD.</p>
                <h1>${msg}</h1>
            </div>
            <c:import url="import/footer.jsp"/>
        </div>
    </body>
</html>
