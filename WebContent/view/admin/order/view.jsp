<%@page import="models.Cart"%>
<%@page import="java.util.List"%>
<%@page import="models.Order"%>
<%@page import="models.User"%>
<%@page import="daos.UserDAO"%>
<%@page import="models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daos.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thông tin đơn hàng</h2>
                <h2><a href="<%=request.getContextPath()%>/admin/order/index">Back</a></h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                            <% 
                            	if (request.getAttribute("order") != null){
                            		Order order = (Order)request.getAttribute("order"); 
                            		List<Cart> carts = (List<Cart>) request.getAttribute("carts");
                            		ProductDAO pDao  = new ProductDAO();
                            		Product p = null;
                            		for (Cart c:carts){
                            			p = pDao.getProductById(c.getProduct_id());
                            			
                            %>
                             <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Hình ảnh</th>
                                        <th>Số lượng</th>
                                        <th>Giá mỗi sản phẩm</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><%=c.getId() %></td>
                                        <td><%=p.getName() %></td>
                                        <td><img alt="day la image" src="<%= request.getContextPath() %>/images/<%=p.getImage()%>"></td>
                                        <td><%= c.getCounter() %></td>
                                        <td>$<%= p.getPrice() %></td>
                                    </tr>
                                    <%
                            			}	
                                	
                                    %>
                                </tbody>
                            </table>
                            <h3>Tổng tiền: <%= order.getTotal() %></h3>
                            <h3>
                            <% if (order.getStatus() == 0){ %>
                            Trạng thái: Chưa giao
                            <% }else{ %>
                            Trạng thái: Đã giao
                            </h3>
                            <% } }%>
                               
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Form Elements -->
            </div>
        </div>
        <!-- /. ROW  -->
    </div>
    <!-- /. PAGE INNER  -->
</div>
<script>
    document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>