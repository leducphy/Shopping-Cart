<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAL.*" %>
<%@page import="controllers.*" %>
<%@page import="models.*" %>
<%@page import="java.util.ArrayList" %>
<%@include file="./template/header.jsp" %>
<div id="content">
    <c:set var = "p" scope = "application" value = "${product}"></c:set>
        <div id="content-detail">
            <div id="content-title">
                <a href="<%=path%>/category-list">Home</a> >
            <a href="product-list?category-id=${categoryID}">${catName}</a> >  
            <a href="#"> Model: ${pid}</a> 

        </div>
        <div id="product">
            <div id="product-name">

                <div id="product-detail">
                    <div id="product-detail-left">
                        <div id="product-img">
                            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-indicators">
                                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                                </div>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img src="<%=path%>/img/6.jpg" class="d-block w-100" alt="...">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="<%=path%>/img/7.jpg" class="d-block w-100" alt="...">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="<%=path%>/img/8.jpg" class="d-block w-100" alt="...">
                                    </div>
                                </div>
                                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>
                            </div>
                        </div>
                        <div id="product-img-items">
                            <div><a href="#"><img src="img/6.jpg"/></a></div>
                            <div><a href="#"><img src="img/7.jpg"/></a></div>
                            <div><a href="#"><img src="img/8.jpg"/></a></div>
                            <div><a href="#"><img src="img/9.jpg"/></a></div>

                        </div>
                    </div>
                    <div id="product-detail-right">
                        <div id="product-detail-right-content">
                            <h2 style="color: sienna;
                                font-style: oblique;">${pname}</h2>
                            <div id="product-price">$ ${pprice}</div>

                            <c:choose>
                                <c:when test="${pstatus > 0}">
                                    <div id="product-status">
                                        <p style=" ">In Stock</p>
                                    </div>
                                    <div id="product-detail-buttons">
                                        <div id="product-detail-button">
                                            <input onclick="buynow(${pid})" type="button" value="BY NOW">
                                            <input onclick="addToCart(${pid})" type="button" value="ADD TO CART" style="background-color: #fff; color:red;border: 1px solid gray;">
                                        </div>
                                    </div>
                                </c:when>    
                                <c:otherwise>
                                    <div id="product-status">
                                        <p style="color: gray; ">Out Of Stock</p>
                                    </div>
                                    <div id="product-detail-buttons">
                                        <div id="product-detail-button">
<!--                                            <input onclick="buynow(${pid})" type="button" value="BY NOW" disabled>
                                            <input onclick="addToCart(${pid})" type="button" value="ADD TO CART" style="background-color: #fff; color:red;border: 1px solid gray;" disabled>-->
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>



                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="info-detail">
            <div id="info-detail-title">
                <h2>Information detail</h2>
                <div style="margin:10px auto;">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Illum, debitis. Asperiores soluta eveniet eos accusantium doloremque cum suscipit ducimus enim at sapiente mollitia consequuntur dicta quaerat, sunt voluptates autem. Quam!
                    Lorem ipsum dolor, sit amet consectetur adipisicing elit. Rem illum autem veritatis maxime corporis quod quibusdam nostrum eaque laborum numquam quos unde eveniet aut, exercitationem voluptatum veniam fugiat, debitis esse?
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio eligendi ratione vitae nobis numquam dolorum assumenda saepe enim cumque blanditiis, deleniti neque voluptate vel ducimus in omnis harum aut nisi.
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="./template/footer.jsp" %>