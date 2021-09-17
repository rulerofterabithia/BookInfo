<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/s/css/bootstrap.min.css">
    <title>书籍新增</title>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand">
                    图书管理系统
                </a>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/book/list">
                                查询所有书籍
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/login">
                                退出登录
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-md-12">
                    <form:form action="${pageContext.request.contextPath}/book/add" modelAttribute="book"
                               enctype="multipart/form-data" method="post">
                        <div class="form-group row">
                            <form:label path="name" cssClass="col-sm-2 col-form-label">
                                书籍名
                            </form:label>
                            <div class="col-sm-10">
                                <form:input path="name" cssClass="form-control"></form:input>
                                <div class="valid-feedback" style="display: block;color: red">
                                    <form:errors path="name"></form:errors>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <form:label path="author" cssClass="col-sm-2 col-form-label">
                                作者
                            </form:label>
                            <div class="col-sm-10">
                                <form:input path="author" cssClass="form-control"></form:input>
                                <div class="valid-feedback" style="display: block;color: red">
                                    <form:errors path="author"></form:errors>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <form:label path="tid" cssClass="col-sm-2 col-form-label">
                                书籍类型
                            </form:label>
                            <div class="col-sm-10">
                                <form:select path="tid" cssClass="form-control" items="${types}"
                                             itemValue="id" itemLabel="name"/>
                                <div class="valid-feedback" style="display: block;color: red">
                                    <form:errors path="tid"></form:errors>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <form:label path="price" cssClass="col-sm-2 col-form-label">
                                价格
                            </form:label>
                            <div class="col-sm-10">
                                <form:input path="price" cssClass="form-control"></form:input>
                                <div class="valid-feedback" style="display: block;color: red">
                                    <form:errors path="price"></form:errors>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <form:label path="descri" cssClass="col-sm-2 col-form-label">
                                书籍描述
                            </form:label>
                            <div class="col-sm-10">
                                <form:textarea path="descri" cssClass="form-control"></form:textarea>
                                <div class="valid-feedback" style="display: block;color: red">
                                    <form:errors path="descri"></form:errors>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <form:label path="photo" cssClass="col-sm-2 col-form-label">
                                图片
                            </form:label>
                            <div class="col-sm-10">
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="inputGroupFile02" name="photox">
                                    <label class="custom-file-label" for="inputGroupFile02"
                                           aria-describedby="inputGroupFileAddon02">选择文件</label>
                                </div>
                                <div class="valid-feedback">
                                    <form:errors path="photo"></form:errors>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <form:label path="pubDate" cssClass="col-sm-2 col-form-label">
                                出版日期
                            </form:label>
                            <div class="col-sm-10">
                                <form:input path="pubDate" cssClass="form-control"></form:input>
                                <div class="valid-feedback" style="display: block;color: red">
                                    <form:errors path="pubDate"></form:errors>
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            新增
                        </button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12 text-center">
            蔡永康版权所有,侵权必究&copy;2021
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>

</body>
</html>
