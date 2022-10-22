<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./template/header_admin.jsp" %> 
<div id="content-right">
    <div class="path-admin">CREATE A NEW PRODUCT</b></div>
    <div class="content-main">
        <form id="content-main-product" action="AddProduct" method="post">
            <div class="content-main-1">
                <label>Product name (*):</label><br/>
                <input type="text" name="txtProductName" id=""><br/>
                <span class="msg-error">Product name is required.</span><br/>
                <label>Unit price:</label><br/>
                <input type="text" name="txtUnitPrice" id=""><br/>
                <label>Quantity per unit:</label><br/>
                <input type="text" name="txtQuantityPerUnit" id=""><br/>
                <label>Units in stock (*):</label><br/>
                <input type="text" name="txtUnitsInStock" id=""><br/>
                <span class="msg-error">Units in stock is required.</span><br/>
            </div>
            <div class="content-main-1">
                <label>Category (*):</label><br/>
                <select name="ddlCategory">
                    <c:forEach items="${categories}" var="item">
                        <option value="${item.getCategoryID()}">${item.getCategoryName()}</option>
                    </c:forEach>
                </select>
                <br/>
                <span class="msg-error">Product name is required.</span><br/>
                <label>Reorder level:</label><br/>
                <input type="text" name="txtReorderLevel" id=""><br/>
                <label>Units on order:</label><br/>
                <input type="text" name="txtUnitsOnOrder" id=""><br/>
                <label>Discontinued:</label><br/>
                <input type="radio" name="chkDiscontinued" checked value="true">TRUE
                <input type="radio" name="chkDiscontinued" value="false"> FALSE<br/>
                <input type="submit" value="Save"/>
            </div>
        </form>
    </div>
</div>
</div>
<%@include file="./template/footer_admin.jsp" %> 