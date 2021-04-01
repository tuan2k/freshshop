<%@page import="models.Category"%>
<%@page import="daos.CategoryDAO"%>
<%@page import="models.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Sửa bài hát</h2>
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
                                <form role="form" method="post" id="form" action="<%=request.getContextPath()%>/admin/product/edit" enctype="multipart/form-data">
                                    <div class="form-group">
                                    	<% 
                            			if (request.getAttribute("product") != null){
                            			Product product = (Product)request.getAttribute("product"); 
                                		int id = product.getId();
                                		String name = product.getName();
                            			%>
                            			<input type="hidden" id="id" value="<%=id %>" name="id" class="form-control"/>
                                        <label for="name">Tên sản phẩm</label>
                                        <input type="text" id="name" value="<%= name %>" name="name" class="form-control" required/>
                                        <label for="name">Giá</label>
                                        <input type="text" id="price" value="<%= product.getPrice() %>" name="price" class="form-control" required/>
                                        <label for="name">Số lượng</label>
                                        <input type="text" id="price" value="<%= product.getNumber() %>" name="number" class="form-control" required/>
                                        <label for="name">Chi tiết</label>
                                        <textarea id="review" name="review" value="<%= product.getPreview() %>" class="form-control" required></textarea>
                                        <label for="name">Hình ảnh</label>
                                        <input type="file" id="image" value="<%= product.getImage()%>"name="image" class="form-control"/>
                                        <label for="name">Tiêu đề</label>
                                        <select name="catid">
                                        <%
                                        	CategoryDAO categoryDAO = new CategoryDAO();
                                        	List<Category> listcat = categoryDAO.getCategories();
                                        	for (Category c :listcat){
                                        %>
                                        
                                        <% if (c.getId() == product.getCat_id()) {%>
                                        <option value="<%=c.getId()%>" selected="selected"><%=c.getName() %></option>
                                        <% }else{ %>
                                        <option value="<%=c.getId()%>"><%=c.getName() %></option>
                                        <% } } %>
                                        </select>
                                    </div>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Sửa</button>
                                </form>
                                 <% } %>
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