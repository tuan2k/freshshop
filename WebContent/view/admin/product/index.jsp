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
				<h2>Quản lý Sản phẩm</h2>
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
								<div class="col-sm-6">
									<a
										href="<%=request.getContextPath()%>/view/admin/product/add.jsp"
										class="btn btn-success btn-md">Thêm</a>
								</div>
								<div class="col-sm-6" style="text-align: right;">
									<form method="post" action="">
										<input type="submit" name="search" value="Tìm kiếm"
											class="btn btn-warning btn-sm" style="float: right" /> <input
											type="search" class="form-control input-sm"
											placeholder="Nhập tên bài hát"
											style="float: right; width: 300px;" />
										<div style="clear: both"></div>
									</form>
									<br />
								</div>
							</div>
							
							<% if (request.getParameter("msg")!= null){
                            	String msg = request.getParameter("msg");
                            	if (GlobalConstant.SUCCESS.equals(msg)){
                            		%>
                            		<h4 class="alert alert-success" role="alert">OKKK</h4>
                            		<%
                            	}else {
                            		%>
                            		<h4 class="alert alert-danger" role="alert">ERROR</h4>
                            		<%
                            	}
                            }
                            %>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên bài hát</th>
										<th>Hình ảnh</th>
										<th width="160px">Chức năng</th>
									</tr>
								</thead>
								<tbody>

									<%
										@SuppressWarnings("unchecked")
										List<Product> products = (List<Product>) request.getAttribute("products");
										if (products != null && products.size() > 0) {
											for (Product s : products) {
												int id = s.getId();
												String name = s.getName();
												String urlEdit = request.getContextPath() + "/admin/product/edit?id=" + id;
												String urlDel = request.getContextPath() + "/admin/product/del?id=" + id;
									%>

									<tr>
										<td><%=id%></td>
										<td class="center"><%=name%></td>
										<td><img alt="day la image" src="<%= request.getContextPath() %>/images/<%=s.getImage()%>"></td>
										<td class="center"><a href="<%=urlEdit%>" title=""
											class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a> <a
											href="<%=urlDel%>"
											onclick="return confirm('Do you want to delete?')" title=""
											class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a></td>
									</tr>
									<%
										}
										}
									%>

								</tbody>
							</table>
							<div class="row">
								<div class="col-sm-6">
									<div class="dataTables_info" id="dataTables-example_info"
										style="margin-top: 27px">Hiển thị từ 1 đến 5 của 24
										truyện</div>
								</div>
								<div class="col-sm-6" style="text-align: right;">
									<div class="dataTables_paginate paging_simple_numbers"
										id="dataTables-example_paginate">
										<ul class="pagination">
											<li class="paginate_button previous disabled"
												aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_previous"><a href="#">Trang
													trước</a></li>
											<li class="paginate_button next"
												aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_next"><a href="#">Trang tiếp</a></li>
										</ul>
									</div>
								</div>
							</div>
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