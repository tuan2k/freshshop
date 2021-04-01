
<%@page import="models.User"%>
<%@page import="daos.UserDAO"%>
<%@page import="daos.ProductDAO"%>
<%@page import="models.Product"%>
<%@page import="models.Order"%>
<%@page import="constants.GlobalConstant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý Giao hàng</h2>
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
                                    <a href="<%=request.getContextPath()%>/view/admin/order/add.jsp" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="">
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" class="form-control input-sm" placeholder="Nhập tên bài hát" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
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
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            	
                                <thead>
                                    <tr>
                                       <th>ID</th> 
                                       <th>Tên khách hàng</th>
                                       <th>Tổng tiền</th> 
                                       <th>Ngày mua</th> 
                                       <th>Trạng thái</th>
                                       <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                               
                                <tbody>
                                	 <%
                            		if (request.getAttribute("orders")!=null){
                            			@SuppressWarnings("unchecked")
                            			List<Order> orders = (List<Order>)request.getAttribute("orders");
                            			ProductDAO pDao = new ProductDAO();
                            			UserDAO userDAO = new UserDAO();
                            			if  ( orders != null){
                            				for (Order o : orders){
                            					int id = o.getId();
                            					User u = userDAO.getById(o.getUser_id());
                            					String urlView = request.getContextPath()+ "/admin/order/view?id="+id;
                            					String urlEdit = request.getContextPath()+ "/admin/order/edit?id="+id;
                                				String urlDel  = request.getContextPath()+ "/admin/order/del?id="+id;                            					
                            	
                            		%>
                                    <tr>
                                        <td><%= id %></td>
                                        <td class="center"><%= u.getFullname() %></td>
                                        <td class="center"><%= o.getTotal()%></td>
                                        <td class="center"><%= o.getDate()%></td>
                                        <td class ="center">
                                        <% if (o.getStatus() == 1){ %>
                                        <p>Đã giao</p>
                                        <% }else{ %>
                                        <p>Chưa giao</p>
                                        <% } %>
                                        </td>
                                        <td class="center">
                                        	<a href="<%= urlView%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i>Xem</a>
                                            <a href="<%= urlEdit %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <a href="<%=urlDel %>" title="" onclick="return confirm('Do you want to delete?')" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                        </td>
                                    </tr>
                                    <%  } } }%>
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
											<li class="paginate_button active"
												aria-controls="dataTables-example" tabindex="0"><a
												href="<%=request.getContextPath()%>/admin/contact/index?page=1"></a></li>
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
<%@ include file="/templates/admin/inc/footer.jsp" %>