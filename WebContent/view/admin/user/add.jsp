<%@page import="models.Role"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daos.RoleDAO"%>
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
                                <form role="form" method="post" id="form" action="<%=request.getContextPath()%>/admin/user/add">
                                    <div class="form-group">
                                         <label for="name">Username</label>
                                         <input type="text" id="name" value="" name="username" class="form-control" required />
                                         <label for="name">Password</label>
                                         <input type="password" id="name" value="" name="password" class="form-control" required/>
                                         <label for="name">Fullname</label>
                                          <input type="text" id="name" value="" name="fullname" class="form-control" required />
                                          <label for="name">Address</label>
                                          <input type="text" id="name" value="" name="address" class="form-control" required />
                                          <label for="name">Phone</label>
                                          <input type="text" id="name" value="" name="phone" class="form-control" required />
                                          <label for="name">Gender</label>
                                          <input type="radio" id="name" value="Nam" name="gender"/>Male
                                          <input type="radio" id="name" value="Nu" name="gender"/>FeMale
                                          <br>
                                          <label for="name">Role</label>
                                          <select name="role">
                                         <%
                                        	RoleDAO roleDAO = new RoleDAO();
                                         	ArrayList<Role> roles = roleDAO.getAllRole();
                                        	for (Role r : roles){
                                        %>
                                          <option value="<%=r.getId()%>"><%=r.getName() %></option>
                                          <% } %>
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