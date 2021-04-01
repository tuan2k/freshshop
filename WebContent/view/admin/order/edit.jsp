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
                <h2>Sửa đơn hàng</h2>
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
                                <form role="form" method="post" id="form" action="<%=request.getContextPath()%>/admin/order/edit">
                                    <div class="form-group">
                            <% 
                            	if (request.getAttribute("order") != null){
                            		Order order = (Order)request.getAttribute("order"); 
                            		List<Cart> carts = (List<Cart>) request.getAttribute("carts");
                            		ProductDAO pDao  = new ProductDAO();
                            		Product p = null;
                            		for (Cart c:carts){
                            			int id = c.getId();
                            			p = pDao.getProductById(c.getProduct_id());
                            			String urlDel = request.getContextPath()+ "/admin/cart/del?id="+id;
                            			
                            %>
                            <input type="hidden" id="id"  value="<%=c.getId() %>" name="id" class="form-control" required/>
                             <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Tên sản phẩm</th>
                                        <th>Số lượng</th>
                                        <th>Giá mỗi sản phẩm</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><input type="text" id="name"readonly=”readonly” value="<%=p.getName() %>" name="name" class="form-control" required/></td>
                                        <td>
                                        <input type="text" id="counter" value="<%=c.getCounter() %>" name="counter" class="form-control" required/>
                                        </td>
                                        <td>
                                        <input type="text" id="price"readonly=”readonly” value="$<%=p.getPrice() %>" name="price" class="form-control" required/>
                                        </td>
                                        <td>   
                                        <a href="<%=urlDel %>" title="" onclick="return confirm('Do you want to delete?')" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                        </td>
                                    </tr>
                                    <%
                            			}	
                                	
                                    %>
                                  
                                </tbody>
                            </table>
                            <lable>Trạng thái giao hàng: </lable>
                            <select name="status" class="form-control">
                            <option value="0">Chưa giao</option>
                            <option value="1">Đã giao</option>
                              </select>
                            <% } %>
                                    </div>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Sửa</button>
                                </form>
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