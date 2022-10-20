<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./template/header.jsp" %> 

<div id="content">
    <div id="cart">
        <div id="cart-title">
            <h3>SHOPPING CART</h3>
        </div>
        <c:choose >
            <c:when test="${sessionScope.AccSession == null}">
                <c:set value="${sessionScope.cart}" var="c"/>
                <c:forEach var="p" items="${c.items}">
                    <div id="cart-content">
                        <div class="cart-item">

                            <div class="cart-item-infor">
                                <div class="cart-item-img">
                                    <img src="img/1.jpg"/>
                                </div>
                                <div class="cart-item-name">
                                    <a style="
                                       text-decoration: none;
                                       color: sienna;
                                       font-size: 20px;
                                       font-style: oblique;
                                       margin: 50px;
                                       " 
                                       href="detail?product-name=${p.getProduct().getProductName()}&category-id=${p.getProduct().getCategoryID()}&model=${p.getProduct().getProductID()}">${p.getProduct().getProductName()}</a>
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
                                <a href="amount?num=-1&id=${p.getProduct().getProductID()}">-</a>  
                                <input type="text" value="${p.quantity}"/>
                                <a href="amount?num=1&id=${p.getProduct().getProductID()}">+</a>
                            </div>
                        </div>

                    </div>
                </c:forEach>
            </c:when>

            <c:when test="${sessionScope.AccSession != null}">

                <c:set value="${sessionScope.cart}" var="c"/>
                <c:forEach var="p" items="${c.items}">
                    <div id="cart-content">
                        <div class="cart-item">

                            <div class="cart-item-infor">
                                <div class="cart-item-img">
                                    <img src="img/1.jpg"/>
                                </div>
                                <div class="cart-item-name">
                                    <a style="
                                       text-decoration: none;
                                       color: sienna;
                                       font-size: 20px;
                                       font-style: oblique;
                                       margin: 50px;
                                       " 
                                       href="detail?product-name=${p.getProduct().getProductName()}&category-id=${p.getProduct().getCategoryID()}&model=${p.getProduct().getProductID()}">${p.getProduct().getProductName()}</a>
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
                                <a href="amount?num=-1&id=${p.getProduct().getProductID()}">-</a>  
                                <a href="amount?num=1&id=${p.getProduct().getProductID()}">+</a>
                                <input type="text" value="${p.quantity}"/>
                            </div>
                        </div>

                    </div>
                </c:forEach>
            </c:when>

        </c:choose>
        <div id="cart-summary">
            <div id="cart-summary-content">Total amount: <span style="color:red">
                    <c:out value="${t}"/> $
                </span></div>
        </div>
        <form action="signup_temporary" method="post">
            <div id="customer-info">
                <div id="customer-info-content">
                    <h3>CUSTOMER INFORMATION:</h3>
                    <div id="customer-info-detail">
                        <c:choose >
                            <c:when test="${sessionScope.AccSession != null}">
                                <%
                           
                            String cid = "";

                            String CompanyName = "";
                            String ContactName = "";
                            String ContactTitle = "";
                            String Address = "";

                             if(request.getSession().getAttribute("AccSession") != null) {
                                  Account acc = (Account)(request.getSession().getAttribute("AccSession"));
                                  cid = acc.getCustomerID();

                            Customers cus = new CustomerDAO().getCustomersByID(cid);

                            CompanyName = cus.getCompanyName();
                            ContactName = cus.getContactName();
                            ContactTitle = cus.getContactTitle();
                            Address = cus.getAddress();
                                %>
                                <div id="customer-info-left">
                                    <input type="text" value="<%=CompanyName%>"/><br/>
                                    <input type="text" value="<%=ContactName%>"/><br/>
                                </div>
                                <div id="customer-info-right">
                                    <input type="text" value="<%=ContactTitle%>"/><br/>
                                    <input type="text" value="<%=Address%>"/><br/>
                                </div>
                                <%
                            }
                                %>
                            </c:when>
                            <c:when test="${sessionScope.AccSession == null}">
                                <div id="customer-info-left">
                                    <input type="text" placeholder="Company name *" name="comName"/><br/>
                                    <input type="text" placeholder="Contact name *" name="contName"/><br/>
                                </div>
                                <div id="customer-info-right">
                                    <input type="text" placeholder="Contact title *" name="cTitle"/><br/>
                                    <input type="text" placeholder="Address *" name="address"/><br/>
                                </div>
                            </c:when>
                        </c:choose>
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
                            <input type="radio" name="rbPaymentMethod" disabled/>
                            Payment via online payment gateway
                        </div>
                    </div>
                </div>
            </div>

            <div id="cart-order">
                <input type="submit" value="ORDER"/>
            </div>
        </form>

    </div>
</div>


<%@include file="./template/footer.jsp" %>