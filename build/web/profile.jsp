<%@include file= "./template/header.jsp" %>
<%
    Customers cus = (Customers) request.getSession().getAttribute("CusSession");
%>
        <div id="content">
            <div id="content-left">
                <h3 style="font-weight: normal;">Welcome, <%=cus.getContactName()%></h3>
                <h3>Account Management</h3>
                <ul>
                    <a href="../profile.jsp"><li>Personal information</li></a>
                </ul>
                <h3>My order</h3>
                <ul>
                    <a href="profile1.jsp"><li>All orders</li></a>
                    <a href="#"><li>Canceled order</li></a>
                </ul>
            </div>
            <div id="content-right">
                <div class="path">Personal information</b></div>
                <div class="content-main">
                    <div id="profile-content">
                        <div class="profile-content-col">
                            <div>Company name: <br/><%=cus.getCompanyName()%></div>
                            <div>Contact name: <br/><%=cus.getContactName()%></div>
                            <a href="<%=path%>/account/edit?CusID=<%=cus.getCustomerID()%> " class="btn btn-primary">Edit Info</a>
                        </div>
                        <div class="profile-content-col">
                            <div>Company title: <br/><%=cus.getContactTitle()%></div>
                            <div>Address: <br/><%=cus.getAddress()%></div>
                        </div>
                        <div class="profile-content-col">
                            <div>Email: <br/><%=cus.getEmail()%></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%@include file="./template/footer.jsp" %>