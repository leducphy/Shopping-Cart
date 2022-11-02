<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAL.*" %>
<%@page import="controllers.*" %>
<%@page import="models.*" %>
<%@page import="java.util.*" %>
<%@include file="./template/header_admin.jsp" %> 
<div id="content-right">
    <div class="path-admin">PRODUCTS LIST</b></div>
    <div class="content-main">
        <div id="content-main-dashboard">
            <div id="product-title-header">
                <div id="product-title-1" style="width: 25%;">
                    <b>Filter by Category:</b>
                    <form action="SearchAdmin" method="post">
                        <select name="ddlCategory" class="selectCat">
                            <option value="0">All</option>
                            <c:forEach items="${categories}" var="item">
                                <option value="${item.getCategoryID()}" ${CatID == item.getCategoryID() ? "selected" : ""}>${item.getCategoryName()}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="Filter" class="btn btn-outline-success search-btn">
                    </form>
                </div>
                <div id="product-title-2" style="width: 55%;" class="container-fluid">
                    <form action="SearchAdmin" method="get" class="d-flex">
                        <input  class="form-control me-2"type="text" name="txtSearch" placeholder="Enter product name to search" value="${nameSearch}"/>
                        <input type="hidden" name="CatID" value="${CatID}">
                        <input class="btn btn-outline-success search-btn" type="submit" value="Search"/>
                    </form>
                </div>
                <div id="product-title-3" style="width: 20%;">
                    <a href="AddProduct">Create a new Product</a>
                    <form action="">
                        <label for="upload-file">Import .xls or .xlsx file</label>
                        <input type="file" name="file" id="upload-file" />
                    </form>
                </div>
            </div>
            <div id="order-table-admin">
                <table id="orders">
                    <th>ProductID</th>
                    <th>ProductName</th>
                    <th>UnitPrice</th>
                    <th>Unit</th>
                    <th>UnitsInStock</th>
                    <th>Category</th>
                    <th>Discontinued</th>
                    <th>Action</th>

                    <c:forEach items="${products}" var="i">
                        <tr>
                            <td><a href="order-detail.html?id=5">#${i.getProductID()}</a></td>
                            <td>${i.getProductName()}</td>
                            <td>${i.getUnitPrice()}</td>
                            <td>${i.getQuantityPerUnit()}</td>
                            <td>${i.getUnitsInStock()}</td>
                            <td>${i.getCategoryID()}</td>
                            <td>${i.isDiscontinued()}</td>
                            <td style="display: flex;">
                                <a class="nav-link siennaa" href="update?pid=${i.getProductID()}"> Edit</a> 
                                <a class="nav-link siennaa" onclick="showMess(${i.getProductID()})">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <!--PAGING-->
            <nav aria-label="Page navigation example" style="width: 95%;">
                <c:if test="${numberOfPage > 1}">
                    <ul class="pagination justify-content-end">
                        <c:if test="${page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="ManageProduct?page=${page - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach var = "i" begin = "1" end = "3">
                            <c:choose>
                                <c:when test="${i == page}">
                                    <li class="page-item"><a class="page-link active" href="ManageProduct?page=${i}">${i}</a></li>
                                    </c:when>    
                                    <c:otherwise>
                                    <li class="page-item"><a  class="page-link" href="ManageProduct?page=${i}"">${i}</a></li>
                                    </c:otherwise>
                                </c:choose>

                        </c:forEach>
                        <%--For displaying Next link --%>
                        <c:if test="${page lt numberOfPage}">
                            <li class="page-item">
                                <a class="page-link" href="ManageProduct?page=${page + 1}" aria-label="Next">
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
</div>
<%@include file="./template/footer_admin.jsp" %> 