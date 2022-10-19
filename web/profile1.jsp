<%@include file="./template/header.jsp" %>
<%
Customers cus = (Customers) request.getSession().getAttribute("CusSession");
%>
<div id="content">
    <div id="content-left">
        <h3 style="font-weight: normal;">Welcome, <%=cus.getContactName()%></h3>
        <h3>Account Management</h3>
        <ul>
            <a href="profile.jsp"><li>Personal information</li></a>
        </ul>
        <h3>My order</h3>
        <ul>
            <a href="profile1.html"><li>All orders</li></a>
            <a href="#"><li>Canceled order</li></a>
        </ul>
    </div>
    <div id="content-right">
        <div class="path">LIST ORDERS</b></div>
        <div class="content-main">
            <div id="profile-content-order">
                <div>
                    <div class="profile-order-title">
                        <div class="profile-order-title-left">
                            <div>Order creation date: 27-9-2022</div>
                            <div>Order: <a href="#">#1</a></div>
                        </div>
                        <div class="profile-order-title-right">
                            <span>Pending</span>
                        </div>
                    </div>
                    <div class="profile-order-content">
                        <div class="profile-order-content-col1">
                            <a href="detail.html"><img src="img/2.jpg" width="100%"/></a>
                        </div>
                        <div class="profile-order-content-col2">Product 12</div>
                        <div class="profile-order-content-col3">Quantity: 1</div>
                        <div class="profile-order-content-col4">1000 $</div>
                    </div>
                    <div class="profile-order-content">
                        <div class="profile-order-content-col1">
                            <a href="detail.html"><img src="img/1.jpg" width="100%"/></a>
                        </div>
                        <div class="profile-order-content-col2">Product 1</div>
                        <div class="profile-order-content-col3">Quantity: 2</div>
                        <div class="profile-order-content-col4">2000 $</div>
                    </div>

                </div>
                <div>
                    <div class="profile-order-title">
                        <div class="profile-order-title-left">
                            <div>Order creation date: 25-9-2022</div>
                            <div>Order: <a href="#">#2</a></div>
                        </div>
                        <div class="profile-order-title-right">
                            <span style="color: blue;">Completed</span>
                        </div>
                    </div>
                    <div class="profile-order-content">
                        <div class="profile-order-content-col1">
                            <a href="detail.html"><img src="img/2.jpg" width="100%"/></a>
                        </div>
                        <div class="profile-order-content-col2">Product 12</div>
                        <div class="profile-order-content-col3">Quantity: 1</div>
                        <div class="profile-order-content-col4">1000 $</div>
                    </div>
                    <div class="profile-order-content">
                        <div class="profile-order-content-col1">
                            <a href="detail.html"><img src="img/1.jpg" width="100%"/></a>
                        </div>
                        <div class="profile-order-content-col2">Product 1</div>
                        <div class="profile-order-content-col3">Quantity: 2</div>
                        <div class="profile-order-content-col4">2000 $</div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="./template/footer.jsp" %>