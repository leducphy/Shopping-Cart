<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./template/header.jsp" %>

<div id="content">
    <div id="content-left">
        <h3 style="font-weight: normal;">Welcome, ${CusSession.getContactName()}</h3>
        <h3>Account Management</h3>
        <ul>
            <a href="<%=path%>/profile.jsp"><li>Personal information</li></a>
        </ul>
        <h3>My order</h3>
        <ul>
            <a href="#"><li>All orders</li></a>
            <a href="#"><li>Canceled order</li></a>
        </ul>
    </div>
    <div id="content-right">
        <div class="path">LIST ORDERS</b></div>
        <div class="content-main">
            <div id="profile-content-order">
                <c:forEach items="${listOrder}" var="o" >
                    <div>
                        <div class="profile-order-title" onclick="show(this)">
                            <div class="profile-order-title-left">
                                <div>Order creation date: ${o.getOrderDate()}</div>
                                <div>Order: <a href="#">#${o.getOrderID()}</a></div>
                            </div>
                            <div class="profile-order-title-right">
                                <span>Pending</span>
                            </div>
                        </div>
                        <div class="profile-order-content" style="display: none;">

                            <c:forEach items="${listOrderDetail}" var="od">
                                <c:if test="${o.getOrderID() == od.getOrderID()}" >
                                    <div class="profile-order-content-col1">
                                        <a href="detail.html"><img src="img/6.jpg" width="100%"/></a>
                                    </div>
                                    <div class="profile-order-content-col2 " style="">${od.getProductName()}</div>
                                    <div class="profile-order-content-col3">Quantity: ${od.getQuantity()}</div>
                                    <div class="profile-order-content-col4">${od.getUnitPrice()} $</div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>
</div>
<%@include file="./template/footer.jsp" %>