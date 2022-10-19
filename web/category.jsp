<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./template/header.jsp" %>
<%
    String categoryName = (String)request.getAttribute("input-category-name");
    ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("input-product-list");
%>
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
        <div class="path"><%=categoryName%></br></div> 
        <div class="content-main">
            
            <c:forEach items="${cateListByID}" var="p">
                <div class="product card-body">
                    <a href="detail.jsp?product-name=${p.getProductName()}&category-id=${p.getCategoryID()}&model=${p.getProductID()}"><img src="img/1.jpg" width="100%"/></a>
                    <div class="name card-title"><a href="detail.jsp?product-name=${p.getProductName()}&category-id=${p.getCategoryID()}>&model=${p.getCategoryID()}">${p.getProductName()}</a></div>
                    <div class="price">Price: ${p.getUnitPrice()}</div>
                    <div class="col d-flex justify-content-center"><a href="" class="btn btn-primary buynow">Buy now</a></div>
                </div>
            </c:forEach>


        </div>
    </div>
</div>

<%@include file="./template/footer.jsp" %>
