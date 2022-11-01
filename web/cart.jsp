<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./template/header.jsp" %> 
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<%
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();
    String date = dtf.format(now);
%>
<div id="content">
    <div id="cart">
        <div id="cart-title">
            <h3>SHOPPING CART</h3>
        </div>

        <c:set value="${sessionScope.cart}" var="c"/>
        <c:forEach var="p" items="${c.items}">
            <div id="cart-content">
                <div class="cart-item">

                    <div class="cart-item-infor">
                        <div class="cart-item-img">
                            <img src="img/9.jpg"/>
                        </div>
                        <div class="cart-item-name">
                            <a style="
                               text-decoration: none;
                               color: sienna;
                               font-size: 20px;
                               font-style: oblique;
                               margin: 50px;
                               " 
                               href="detail?model=${p.getProduct().getProductID()}">${p.getProduct().getProductName()}</a>
                        </div>
                        <div class="cart-item-price">
                            ${p.getProduct().getUnitPrice() * p.quantity}$
                        </div>
                        <div class="cart-item-button">
                            <!--<form action="amount" method="post">-->
                            <a href="remove?id=${p.getProduct().getProductID()}">Remove</a>

                            <!--</form>-->
                        </div>
                    </div>
                    <div class="cart-item-function">
                        <a href="change?num=-1&id=${p.getProduct().getProductID()}">-</a>  
                        <input type="text" value="${p.quantity}" disabled/>
                        <a href="change?num=1&id=${p.getProduct().getProductID()}">+</a>
                    </div>
                </div>

            </div>
        </c:forEach>
        <div id="cart-summary">
            <div id="cart-summary-content">
                <c:choose>
                    <c:when test="${t != 0 and sessionScope.cart != null and sessionScope.size != 0}">
                        Total amount: 
                        <span style="color:red">
                            <c:out value="${t}"/> $
                        </span>
                    </c:when>    
                    <c:otherwise>
                        <img src="img/emptycart.png" alt="" class="img-fluid"/>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
        <form method="post" action="cart">

            <c:set value="${sessionScope.CusSession}" var="cus"/>
            <%--<c:out value="${cus.getCustomerID()}"/>--%> 
            <div id="customer-info">
                <div id="customer-info-content">
                    <h3>CUSTOMER INFORMATION:</h3>
                    <div id="customer-info-detail" >
                        <div id="customer-info-left">
                            <input type="text" placeholder="Company name *"  name="txtCompanyName" value="${cus.getCompanyName()} "  required/><br/>
                            <input type="text" placeholder="Contact name *"  name="txtContactName"  value="${cus.getContactName()}" required/><br/>
                            Required Date<br/>
                            <input type="date" name="txtRequiredDate" value="<%=date%>" min="<%=date%>" max="2099-12-30" required />
                        </div>
                        <div id="customer-info-right">
                            <input type="text" placeholder="Contact title *"  name="txtContactTitle"  value="${cus.getContactTitle()}" required/><br/>
                            <input type="text" placeholder="Address *"  name="txtAddress"  value="${cus.getAddress()}" required/><br/>
                        </div>
                    </div>
                </div>
            </div>
            <div id="customer-info">
                <div id="customer-info-content">
                    <h3>PAYMENT METHODS:</h3>
                    <div id="customer-info-payment">
                        <div>
                            <input type="radio" name="rbPaymentMethod" checked/>
                            Payment C.O.D - Payment on delivery
                        </div>
                        <div>
                            <input type="radio" name="rbPaymentMethod" />
                            Payment via online payment gateway
                        </div>
                    </div>
                </div>
            </div>


            <div id="cart-order">
                <input class="type-sub" type="submit" value="ORDER"/>
            </div>
        </form>

    </div>
</div>


<%@include file="./template/footer.jsp" %>