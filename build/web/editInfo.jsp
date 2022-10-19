<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAL.*" %>
<%@page import="models.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="template/header.jsp" %>

<%
    Customers cus = (Customers) request.getSession().getAttribute("CusSession");
    int id = (int)request.getSession().getAttribute("accID");
%>

<form action="edit" method="post">
    <div id="content">

        <div id="content-right">
            <div class="path">Personal information</b></div>
            <div class="content-main">

                <div id="profile-content">
                    <div class="profile-content-col">
                        <div>Company name: <br/>
                            <input type="text" name="Companyname" value="<%=cus.getCompanyName()%>"><br>
                        </div>
                        <div>Contact name: <br/>
                            <input type="text" name="ContactName" value="<%=cus.getContactName()%>"><br>
                        </div>
                        <input type="submit" value="SAVE CHANGES" />
                    </div>
                    <div class="profile-content-col">
                        <div>Company title: <br/>
                            <input type="text" name="ContactTitle" value="<%=cus.getContactTitle()%>"><br>
                        </div>
                        <div>Address: <br/>
                            <input type="text" name="Address" value="<%=cus.getAddress()%>"><br>
                        </div>
                    </div>
                    <div class="profile-content-col">
                        <div>Email: <br/>
                            <input type="button" style="width: 300px;" value="<%=cus.getEmail()%>"><br>
                        </div>
                    </div>
                    <div>
                        <input type="hidden" name="AccountID"  value="<%=id%>"><br>
                    </div>
                </div>
            </div>

        </div>

    </div>
</form>

<%@include file="template/footer.jsp" %>