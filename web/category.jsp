<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./template/header.jsp" %>
<%
    String categoryName = (String)request.getAttribute("input-category-name");
//    int catID = Integer.parseInt(req.getParameter("category-id"));
%>
<div id="content">
    <div id="content-left">
        <h3>CATEGORY</h3>
        <ul>
            <c:forEach items="${categoryList}" var="item">
                <a class="category-item" href="product-list?category-id=${item.getCategoryID()}">
                    <li <c:if test="${categoryID eq item.getCategoryID() }"> style="background-color: sienna;color: white;"</c:if> >${item.getCategoryName()}</li>
                </a>      
            </c:forEach>
        </ul>
    </div>
    <div id="content-right">
        <div class="path"><%=categoryName%></br></div> 
        <div class="content-main">

            <c:forEach items="${cateListByID}" var="p">
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
            <c:set var = "catID" scope = "application" value = "${categoryID}"></c:set>
                <nav aria-label="Page navigation example" style="width: 95%;">
                <c:if test="${numberOfPage > 1}">
                    <ul class="pagination justify-content-end">
                        <c:if test="${page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="product-list?category-id=${catID}&page=${page - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach var = "i" begin = "1" end = "${numberOfPage}">
                            <c:choose>
                                <c:when test="${i == page}">
                                    <li class="page-item"><a class="page-link" href="product-list?category-id=${catID}&page=${i}"">${i}</a></li>
                                    </c:when>    
                                    <c:otherwise>
                                    <li class="page-item"><a  class="page-link" href="product-list?category-id=${catID}&page=${i}"">${i}</a></li>
                                    </c:otherwise>
                                </c:choose>

                        </c:forEach>
                        <%--For displaying Next link --%>
                        <c:if test="${page lt numberOfPage}">
                            <li class="page-item">
                                <a class="page-link" href="product-list?category-id=${catID}&page=${page + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </c:if>
            </nav>
            <!--PAGING-->
        </div>
    </div>
</div>

<%@include file="./template/footer.jsp" %>
