<%@page import="constants.GlobalConstant"%>
<%@page import="models.Order"%>
<%@page import="daos.OrderDAO"%>
<%@page import="models.Product"%>
<%@page import="daos.ProductDAO"%>
<%@page import="models.Cart"%>
<%@page import="java.util.List"%>
<%@page import="daos.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/header.jsp" %>
    <!-- Start Top Search -->
    <div class="top-search">
        <div class="container">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-search"></i></span>
                <input type="text" class="form-control" placeholder="Search">
                <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
            </div>
        </div>
    </div>
    <!-- End Top Search -->

    <!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Cart</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Shop</a></li>
                        <li class="breadcrumb-item active">Cart</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-main table-responsive">
                    <% if (request.getParameter("msg")!= null){
                            	String msg = request.getParameter("msg");
                            	if (GlobalConstant.SUCCESS.equals(msg)){
                            		%>
                            		<h4 class="alert alert-success" role="alert">Đặt hàng thành công!!!</h4>
                            		<%
                            	}else {
                            		%>
                            		<h4 class="alert alert-danger" role="alert">Đặt hàng thất bại!!!</h4>
                            		<%
                            	}
                            }
                            %>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Images</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<% 
                            		
                            		ProductDAO productDAO = new ProductDAO();
                            		List<Cart> carts = (List<Cart>) session.getAttribute("listCarts");	
                            		if (carts != null && carts.size() > 0){
                            			for (Cart c : carts){
                            				Product p = productDAO.getProductById(c.getProduct_id());
                            	%>
                                <tr>
                                    <td class="thumbnail-img">
                                        <a href="#">
									<img class="img-fluid" src="<%=request.getContextPath() %>/images/<%= p.getImage() %>" alt="" />
								</a>
                                    </td>
                                    <td class="name-pr">
                                        <a href="#">
									<%= p.getName() %>
								</a>
                                    </td>
                                    <td class="price-pr">
                                        <p>$<%= p.getPrice() %></p>
                                    </td>
                                    <td class="cart_quantity text-center">
                                    <div class="cart1-plus-minus-button">
                                    <button onclick="changeNumber(<%= Integer.parseInt(p.getPrice()) %>, <%= p.getId()%>, 1)">+</button>
                                	<input class="cart-plus-minus" type="text" name="qtybutton" id="icounter_<%=p.getId()%>" value="<%=c.getCounter()%>">
                                    <button onclick="changeNumber(<%= Integer.parseInt(p.getPrice()) %>, <%= p.getId()%>, 0)">-</button>
                                    </div>
                                    
                                    </td>
                                    <td class="total-pr" id ="price_<%=p.getId()%>">
                                        <p>$<%= Integer.parseInt(p.getPrice())*c.getCounter()%></p>
                                    </td>
                                    <td class="remove-pr">
                                <a href="javascript:void(0)" onclick="deleteCart(<%=c.getId()%>)">
									<i class="fas fa-times"></i>
								</a>
                                    </td>
                                </tr>
                                <% } } %>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="row my-5">
                <div class="col-lg-8 col-sm-12"></div>
                <div class="col-lg-4 col-sm-12">
                    <div class="order-box">
                        <div class="d-flex gr-total">
                            <h5>Grand Total</h5>
                            <% 
                               	List<Cart> listc = (List<Cart>) session.getAttribute("listCarts");
                            	User u = (User) session.getAttribute("userLogin");
                            	OrderDAO oDao = new OrderDAO();
                            	if ( listc.size() > 0 && listc != null ){
                            		Order o = oDao.getById(listc.get(0).getOrder_id());
                            %>
                            <div class="ml-auto h5" id="total"> $<%= o.getTotal() %> </div>
                            <% } %>
                        </div>
                        <hr> </div>
                </div>
                <div class="col-12 d-flex shopping-box"><a href="<%= request.getContextPath()%>/order" class="ml-auto btn hvr-hover">PLACE ORDER</a> </div>
            </div>

        </div>
    </div>
    <!-- End Cart -->

    <!-- Start Instagram Feed  -->
    <div class="instagram-box">
        <div class="main-instagram owl-carousel owl-theme">
            <div class="item">
                <div class="ins-inner-box">
                    <img src="<%=request.getContextPath() %>/images/instagram-img-01.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="<%=request.getContextPath() %>/images/instagram-img-02.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="<%=request.getContextPath() %>/images/instagram-img-03.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="<%=request.getContextPath() %>/images/instagram-img-04.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="<%=request.getContextPath() %>/images/instagram-img-05.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="<%=request.getContextPath() %>/images/instagram-img-06.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="<%=request.getContextPath() %>/images/instagram-img-07.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="<%=request.getContextPath() %>/images/instagram-img-08.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="<%=request.getContextPath() %>/images/instagram-img-09.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="<%=request.getContextPath() %>/images/instagram-img-05.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Instagram Feed  -->
    <script type="text/javascript">
			function changeNumber(price, idPro, number){
				$.ajax({
					url: '<%=request.getContextPath()%>/cart',
					type: 'POST',
					data: {
						aidPro: idPro, 
						anumber: number
					},
					success: function(data){
						let listNumber = JSON.parse(data);
						if(listNumber.length > 0){
							$("#icounter_"+idPro).val(listNumber[0]);
							$("#price_"+idPro).text(price*listNumber[0]);
							$("#total").text(listNumber[1]);
						}
					},
					error: function (){
						alert('Có lỗi xảy ra');
					}
				})
			}
			function deleteCart(id){
				let check = confirm("Bạn có chắc chắn muốn xóa không?");
				if(check){
					$.ajax({
						url: '<%=request.getContextPath()%>/cart',
						type: 'GET',
						data: {aid: id},
						success: function(){
							$('table').load(' table');
							$('#checkout').load(' #checkout');
							$('#sizecart').load(' #sizecart');
							$('#total').load(' #total');
						},
						error: function (){
							alert('Có lỗi xảy ra');
						}
					})
				}
			}
		</script>
    <%@ include file="/templates/public/footer.jsp" %>
