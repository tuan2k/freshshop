<%@page import="models.User"%>
<%@page import="models.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>Freshshop - Ecommerce Bootstrap 4 HTML Template</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/custom.css">

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!-- ALL JS FILES -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/popper.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    <!-- ALL PLUGINS -->
    
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.superslides.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-select.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/inewsticker.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootsnav.js."></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/images-loded.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/isotope.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/baguetteBox.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/form-validator.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/contact-form-script.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/custom.js"></script>
</head>

<body>
    <!-- Start Main Top -->
    <div class="main-top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="custom-select-box">
                        <select id="basic" class="selectpicker show-tick form-control" data-placeholder="$ USD">
							<option>Â¥ JPY</option>
							<option>$ USD</option>
							<option>â¬ EUR</option>
						</select>
                    </div>
                    <div class="right-phone-box">
                        <p>Call US :- <a href="#"> +11 900 800 100</a></p>
                    </div>
                    <div class="our-link">
                        <ul>
                            <li><a href="#"><i class="fa fa-user s_color"></i> My Account</a></li>
                            <li><a href="#"><i class="fas fa-location-arrow"></i> Our location</a></li>
                            <li><a href="#"><i class="fas fa-headset"></i> Contact Us</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                	<%
                	 if (session.getAttribute("userLogin")!=null){
                		 User u = (User)session.getAttribute("userLogin");
             
                	%>
                	<div class="login-box">
                	<p class="fa fa-user s_color" style="color:blue;">Xin chào <%=u.getFullname() %></p>
                	<div class="login-box">
						<a href="<%= request.getContextPath()%>/logout" class="fa fa-user s_color" style="color:blue;">Log out</a>
					</div>
                	</div>
                	<% }else{ %>
					<div class="login-box">
						<a href="<%= request.getContextPath()%>/login" class="fa fa-user s_color" style="color:blue;">Login</a>
					</div>
					<% } %>
                </div>
            </div>
        </div>
    </div>
    <!-- End Main Top -->

    <!-- Start Main Top -->
    <header class="main-header">
        <!-- Start Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
            <div class="container">
                <!-- Start Header Navigation -->
                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                    <a class="navbar-brand" href="index.html"><img src="<%=request.getContextPath() %>/images/logo.png" class="logo" alt=""></a>
                </div>
                <!-- End Header Navigation -->

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbar-menu">
                    <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                        <li class="nav-item active"><a class="nav-link" href="<%= request.getContextPath()%>/index">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath()%>/view/public/about.jsp">About Us</a></li>
                        <li class="dropdown">
                            <a href="#" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">SHOP</a>
                            <ul class="dropdown-menu">
								<li><a href="<%= request.getContextPath()%>/shop">Sidebar Shop</a></li>
								<li><a href="<%= request.getContextPath()%>/view/public/shop-detail.jsp">Shop Detail</a></li>
                                <li><a href="<%= request.getContextPath()%>/cart">Cart</a></li>
                                <li><a href="<%= request.getContextPath()%>/login">Checkout</a></li>
                                <li><a href="<%= request.getContextPath()%>/view/public/my-account">My Account</a></li>
                                <li><a href="<%= request.getContextPath()%>/view/public/wishlist.jsp">Wishlist</a></li>
                            </ul>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath()%>/view/public/gallery.jsp">Gallery</a></li>
                        <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath()%>/view/public/contact-us.jsp">Contact Us</a></li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->

                <!-- Start Atribute Navigation -->
                <div class="attr-nav" id ="sizecart" >
                    <ul>
                        <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
                        <li class="side-menu">
							<a href="<%= request.getContextPath()%>/cart">
								<i class="fa fa-shopping-bag"></i>
								<%
								 if ( session.getAttribute("listCarts") != null ){
									 List<Cart> listCarts = (List<Cart>) session.getAttribute("listCarts");
									 if (listCarts.size() > 0){
								%>
								<span id="badge" ><%= listCarts.size() %></span>
								<% } } else{ %>
								<span id="badge" >0</span>
								<% } %>
								<p>My Cart</p>
							</a>
						</li>
                    </ul>
                </div>
                <!-- End Atribute Navigation -->
            </div>
            <!-- Start Side Menu -->
            <div class="side">
                <a href="#" class="close-side"><i class="fa fa-times"></i></a>
                <li class="cart-box">
                    <ul class="cart-list">
                        <li>
                            <a href="#" class="photo"><img src="<%=request.getContextPath() %>/images/img-pro-01.jpg" class="cart-thumb" alt="" /></a>
                            <h6><a href="#">Delica omtantur </a></h6>
                            <p>1x - <span class="price">$80.00</span></p>
                        </li>
                        <li>
                            <a href="#" class="photo"><img src="<%=request.getContextPath() %>/images/img-pro-02.jpg" class="cart-thumb" alt="" /></a>
                            <h6><a href="#">Omnes ocurreret</a></h6>
                            <p>1x - <span class="price">$60.00</span></p>
                        </li>
                        <li>
                            <a href="#" class="photo"><img src="<%=request.getContextPath() %>/images/img-pro-03.jpg" class="cart-thumb" alt="" /></a>
                            <h6><a href="#">Agam facilisis</a></h6>
                            <p>1x - <span class="price">$40.00</span></p>
                        </li>
                        <li class="total">
                            <a href="#" class="btn btn-default hvr-hover btn-cart">VIEW CART</a>
                            <span class="float-right"><strong>Total</strong>: $180.00</span>
                        </li>
                    </ul>
                </li>
            </div>
            <!-- End Side Menu -->
        </nav>
        <!-- End Navigation -->
    </header>
    <!-- End Main Top -->