<%@page import="constants.GlobalConstant"%>
<%@page import="models.Product"%>
<%@page import="javax.xml.bind.annotation.XmlElementDecl.GLOBAL"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Quản lý thống kê</h2>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Advanced Tables -->
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="table-responsive">
							<div class="row">
								<div class="col-sm-6" style="text-align: right;">
									<form method="post" action="<%=request.getContextPath()%>/admin/chart/total">
										<label>Tính tổng thu nhập theo tháng</label>
										<label>Chọn tháng muốn tính</label>
										<select name="month">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										</select>
										<input type="submit" value="Tính">
									</form>
									<br />
								</div>
							</div>
							<% 
							if (request.getAttribute("allsalary")!=null){ 
								int allsalary = (Integer) request.getAttribute("allsalary");
							%>
							<h3>Tổng thu nhập là: $<%= allsalary %> </h3>
							<% } %>
						</div>
					</div>
				</div>
				<!--End Advanced Tables -->
			</div>
		</div>
	</div>
</div>
<script>
	document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>