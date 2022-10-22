<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./template/header_admin.jsp" %> 
<div id="content-right">
    <c:set value="${sessionScope.product}" var="p"/>
    <div class="path-admin">EDIT PRODUCT #${pid}</b></div>
    <div class="content-main">
        <form id="content-main-product" action="update" method="post">
                <input type="hidden" name="pid" value="${pid}"><br/>
            <div class="content-main-1">
                <label>Product name :</label><br/>
                <input type="text" name="txtProductName" id="" value="${txtProductName}"><br/>
                <label>Unit price:</label><br/>
                <input type="text" name="txtUnitPrice" id="" value="${txtUnitPrice}"><br/>
                <label>Quantity per unit:</label><br/>
                <input type="text" name="txtQuantityPerUnit" id="" value="${txtQuantityPerUnit}"><br/>
                <label>Units in stock :</label><br/>
                <input type="text" name="txtUnitsInStock" id="" value="${txtUnitsInStock}"><br/>
            </div>
            <div class="content-main-1">
                <label>Category :</label><br/>
                <select name="ddlCategory">
                    <c:forEach items="${categories}" var="item">
                        <option value="${item.getCategoryID()}" ${ddlCategory eq item.getCategoryID() ? "selected" : ""}>${item.getCategoryName()}</option>
                    </c:forEach>
                </select>
                <br/>
                <label>Reorder level:</label><br/>
                <input type="text" name="txtReorderLevel" id="" value="${txtReorderLevel}"><br/>
                <label>Units on order:</label><br/>
                <input type="text" name="txtUnitsOnOrder" id="" value="${txtUnitsOnOrder}"><br/>
                <label>Discontinued:</label><br/>
                <input type="radio" name="chkDiscontinued" ${chkDiscontinued eq "true" ? "checked" : ""}  value="true">TRUE
                <input type="radio" name="chkDiscontinued" ${chkDiscontinued eq "false" ? "checked" : ""} value="false"> FALSE<br/>
                <input type="submit" value="Save"/>
            </div>
        </form>
    </div>
</div>
</div>
<%@include file="./template/footer_admin.jsp" %> 