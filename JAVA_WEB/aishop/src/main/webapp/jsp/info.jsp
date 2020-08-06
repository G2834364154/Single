<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>关于我们</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
	</head>

	<body>
		<div class="container">

			<%--包含导航条 --%>
			<%-- <%@include file="/jsp/header.jsp" %> --%>

			<div class="container">
				<div class="main_con">
					${msg}
					<h1>公司简介</h1>
					<hr/>
						<p>
							<font color="red">途牛旅游网</font>于2006年10月创立于南京，以“让旅游更简单”为使命，为消费者提供由北京、天津、上海、广州、深圳、南京等64个城市出发的旅游产品预订服务，产品全面，价格透明，全年365天24小时400电话预订，并提供丰富的后续服务和保障。
						</p>

						<p>
							途牛旅游网提供8万余种旅游产品供消费者选择，涵盖跟团、自助、自驾、邮轮、酒店、签证、景区门票以及公司旅游等，已成功服务累计超过400万人次出游。
						</p>

						<p>
							以全年业绩来看，途牛2015年的净收入为76亿元人民币(合11.802亿美元)，较2014年增长116.3%。收入增长主要来自于跟团游、自助游及其他收入的增长。2015年总出游人次为4449053，较2014年的2181834人次增长103.9%。
						</p>

						<p>
							售中、售后跟踪服务以及质检，旅途中出现任何质量问题我们帮您维权到底，使您的权益得到切实保障，选择我们您的出游便有了双重保障。
						</p>
					</div>
				</div>
			</div>

		</div>
		<%--页脚 --%>
		<%-- <%@include file="footer.jsp" %> --%>

	</body>

</html>
