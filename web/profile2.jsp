<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./template/header.jsp" %>
<%
    Customers cus = (Customers) request.getSession().getAttribute("CusSession");
%>
<div id="content">
    <div id="content-left">
        <h3 style="font-weight: normal;">Welcome, <%=cus.getContactName()%></h3>
        <h3>Account Management</h3>
        <ul>
            <a href="<%=path%>/profile.jsp"><li>Personal information</li></a>
        </ul>
        <h3>My order</h3>
        <ul>
            <a href="<%=path%>/order-detail"><li>All orders</li></a>
            <a href="<%=path%>/CanceledOrderUser"><li>Canceled order</li></a>
        </ul>
    </div>
    <div id="content-right">
        <div class="path">LIST ORDERS CANCELED</b></div>
        <div class="content-main">
            <div id="profile-content-order">
                <div>
                    <c:forEach items="${listOrder}" var="o">
                        <c:if test="${o.getRequiredDate() == null}">
                            <div class="profile-order-title"  onclick="show(this)">              
                                <div class="profile-order-title-left">                            
                                    <div>Order creation date: ${o.getOrderDate()}</div>                          
                                    <div>Order: <a style="text-decoration: none" href="#">#${o.getOrderID()}</a></div>
                                </div>
                                <div class="profile-order-title-right">                               
                                    <span<td style="color: red !important;">Order canceled </span>
                                </div>

                            </div>
                            <div class="profile-order-content" <c:if test="${listOrder.indexOf(o) ne 0}">style="display: none;"</c:if>">
                                <c:forEach items="${listOrderDetail}" var="od">
                                    <c:if test="${o.getOrderID() == od.getOrderID()}" >
                                        <div class="profile-order-content-col1">
                                            <a href="#"><img src="<%=request.getContextPath()%>/img/1.jpg" width="100%"/></a>
                                        </div>   
                                        <div class="profile-order-content-col2">${od.getProductName()}</div>
                                        <div class="profile-order-content-col3">Quantity : ${od.getQuantity()}</div>
                                        <div style="color:saddlebrown" class="profile-order-content-col4">${od.getUnitPrice()}$</div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </c:if>
                    </c:forEach>

                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="./template/footer.jsp" %>