<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAL.*" %>
<%@page import="controllers.*" %>
<%@page import="models.*" %>
<%@page import="java.util.*" %>
<%@include file="./template/header.jsp" %>


<div id="content">
    <div id="content-left">
        <h3>CATEGORY</h3>
        <ul>
            <c:forEach items="${categoryList}" var="item">
                <a class="category-item" href="product-list?category-id=${item.getCategoryID()}"><li>${item.getCategoryName()}</li></a>          
                    </c:forEach>
        </ul>
    </div>
    <div id="content-right">
        <div class="path">All Product</b></div>      
        <div class="content-main">

            <c:forEach items="${products}" var="p">
                <div class="product card-body">
                    <a href="detail?model=${p.getProductID()}"><img src="img/4.jpg" width="100%"/></a>
                    <div class="name card-title"><a href="detail?model=${p.getProductID()}">${p.getProductName()}</a></div>
                    <div class="price">Price: ${p.getUnitPrice()}</div>
                    <c:choose>
                        <c:when test="${p.getUnitsInStock() == 0}">
                            <div class="col d-flex justify-content-center">
                                <a href="" class="btn btn-primary buynow" style= "background-color: red;" >Out of stock</a>
                            </div>
                        </c:when>

                        <c:otherwise>
                            <div class="col d-flex justify-content-center">
                                <a href="buy?id=${p.getProductID()}&buy=true" class="btn btn-primary buynow" >Buy now</a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>


            <!--PAGING-->
            <nav aria-label="Page navigation example" style="width: 95%;">
                <c:if test="${numberOfPage > 1}">
                    <ul class="pagination justify-content-end">
                        <c:if test="${page != 1}">
                            <!--<li class="page-item"><a class="page-link" href="category-list?page=${page - 1}">Previous</a></li>-->
                            <li class="page-item">
                                <a class="page-link" href="category-list?page=${page - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach var = "i" begin = "1" end = "3">
                            <c:choose>
                                <c:when test="${i == page}">
                                    <li class="page-item"><a class="page-link" href="category-list?page=${i}"">${i}</a></li>
                                    </c:when>    
                                    <c:otherwise>
                                    <li class="page-item"><a  class="page-link" href="category-list?page=${i}"">${i}</a></li>
                                    </c:otherwise>
                                </c:choose>

                        </c:forEach>
                        <%--For displaying Next link --%>
                        <c:if test="${page lt numberOfPage}">
                            <!--<li class="page-item"><a class="page-link" href="category-list?page=${page + 1}">Next</a></li>-->
                            <li class="page-item">
                                <a class="page-link" href="category-list?page=${page + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </c:if>
            </nav>
            <!--PAGING-->

        </div>


        <div class="path">Hot</b></div>      
        <div class="content-main">
            <c:forEach items="${productHotList}" var="p">
                <div class="product card-body">
                    <a href="detail?model=${p.getProductID()}"><img src="img/4.jpg" width="100%"/></a>
                    <div class="name card-title"><a href="detail?model=${p.getProductID()}">${p.getProductName()}</a></div>
                    <div class="price">Price: ${p.getUnitPrice()}</div>
                    <c:choose>
                        <c:when test="${p.getUnitsInStock() == 0}">
                            <div class="col d-flex justify-content-center">
                                <a href="" class="btn btn-primary buynow" style= "background-color: red;" >Out of stock</a>
                            </div>
                        </c:when>

                        <c:otherwise>
                            <div class="col d-flex justify-content-center">
                                <a href="buy?id=${p.getProductID()}&buy=true" class="btn btn-primary buynow" >Buy now</a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
        </div>
        <div class="path">Best Sale</b></div>
        <div class="content-main">
            <c:forEach items="${productBestSaleList}" var="p">
                <div class="product card-body">
                    <a href="detail?model=${p.getProductID()}"><img src="img/4.jpg" width="100%"/></a>
                    <div class="name card-title"><a href="detail?model=${p.getProductID()}">${p.getProductName()}</a></div>
                    <div class="price">Price: ${p.getUnitPrice()}</div>
                    <c:choose>
                        <c:when test="${p.getUnitsInStock() == 0}">
                            <div class="col d-flex justify-content-center">
                                <a href="" class="btn btn-primary buynow" style= "background-color: red;" >Out of stock</a>
                            </div>
                        </c:when>

                        <c:otherwise>
                            <div class="col d-flex justify-content-center">
                                <a href="buy?id=${p.getProductID()}&buy=true" class="btn btn-primary buynow" >Buy now</a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
        </div>
        <div class="path">New Product</b></div>
        <div class="content-main">
            <c:forEach items="${NEWproductList}" var="p">
                <div class="product card-body">
                    <a href="detail?model=${p.getProductID()}"><img src="img/4.jpg" width="100%"/></a>
                    <div class="name card-title"><a href="detail?model=${p.getProductID()}">${p.getProductName()}</a></div>
                    <div class="price">Price: ${p.getUnitPrice()}</div>
                    <c:choose>
                        <c:when test="${p.getUnitsInStock() == 0}">
                            <div class="col d-flex justify-content-center">
                                <a href="" class="btn btn-primary buynow" style= "background-color: red;" >Out of stock</a>
                            </div>
                        </c:when>

                        <c:otherwise>
                            <div class="col d-flex justify-content-center">
                                <a href="buy?id=${p.getProductID()}&buy=true" class="btn btn-primary buynow" >Buy now</a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
        </div>
    </div>

</div>
</div>
<script src="js/main.js"></script>
<%@include file="./template/footer.jsp" %>

