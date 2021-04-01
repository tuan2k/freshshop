<%@page import="models.Role"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daos.RoleDAO"%>
<%@page import="models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Sửa người dùng</h2>
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
                            	if (request.getAttribute("user") != null){
                            		User user = (User)request.getAttribute("user"); 
                                	int id = user.getId();
                                	String username = user.getUsername();
                                	String password = user.getPassword();
                                	String fullname = user.getFullname();
                            	%>
                                <form role="form" method="post" id="form" action="<%=request.getContextPath()%>/admin/user/edit">
                                    <div class="form-group">
                                        <input type="hidden" id="id" value="<%=id %>" name="uid" class="form-control" />
                                        <label for="name">Username</label>
                                        <input type="text" id="name" value="<%=username %>" name="username" class="form-control" required />
                                        <label for="name">Password</label>
                                        <input type="text" id="name" value="<%=password %>" name="password" class="form-control" required/>
                                        <label for="name">Fullname</label>
                                        <input type="text" id="name" value="<%=fullname %>" name="fullname" class="form-control" required/>
                                        <label for="name">Address</label>
                                        <input type="text" id="name" value="<%= user.getAddress() %>" name="address" class="form-control" required />
                                        <label for="name">Phone</label>
                                        <input type="text" id="name" value="<%= user.getPhone() %>" name="phone" class="form-control" required />
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
                                        	if (r.getId() == user.getRole_id()){
                                        		
                                        %>
                                          <option value="<%=r.getId()%>" selected><%=r.getName() %></option>
                                          <% }else {  %>
                                          <option value="<%=r.getId()%>"><%=r.getName() %></option>
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