<%@page import="models.User"%>
<%@page import="daos.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Product"%>
<%@page import="daos.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm danh mục</h2>
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
                                <form role="form" method="post" id="form" action="<%=request.getContextPath()%>/admin/order/add">
                                    <div class="form-group">
                                        
                                        <label for="name">User Name</label>
                                        <select name="userid" class="form-control">
                                         <%
                                        	UserDAO userDAO = new UserDAO();
                                        	ArrayList<User> users = userDAO.getAllUser();
                                        	for (User u : users){
                                        %>
                                          <option value="<%=u.getId()%>"><%=u.getFullname() %></option>
                                          <% } %>
                                         </select>
                                        
                                         <label for="name">Total</label>
                                         <input type="text" id="counter" value="" name="total" class="form-control" required />
                                         <label>Status</label>
                                         <select name="status" class="form-control">
                                         <option value="0">0</option>
                                         <option value="1">1</option>
                                         </select>
                                         
                                    </div>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
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