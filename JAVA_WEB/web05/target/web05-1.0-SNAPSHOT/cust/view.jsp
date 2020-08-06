<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看页面</title>
</head>
<body>
<form>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">名字</label>
            <input type="email" class="form-control" id="inputEmail4" value="${cust.name}" readonly>
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4">生日</label>
            <input type="password" class="form-control" id="inputPassword4" value="${cust.birthday}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputAddress">爱好</label>
        <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" value="${cust.hobby}">
    </div>
    <div class="form-group">
        <label>描述</label>
    </div>

    <!-- 加载编辑器的容器 -->
    <script id="container" name="content" type="text/plain">
        ${cust.description}
    </script>
    <!-- 配置文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('container');
    </script>
</form>
</body>
</html>
