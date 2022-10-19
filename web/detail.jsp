<%@page import="DAL.*" %>
<%@page import="controllers.*" %>
<%@page import="models.*" %>
<%@page import="java.util.ArrayList" %>
<%@include file="./template/header.jsp" %>
<div id="content">
    <%
        ArrayList<Category> categoryList = new CategoryDAO().getCategory();
        String productName = request.getParameter("product-name"); 
        int categoryID = Integer.parseInt(request.getParameter("category-id"));
        String productID = request.getParameter("model");
        String categoryName = "";
        for(Category item: categoryList){
            if(item.getCategoryID() == categoryID){
            categoryName = item.getCategoryName();
        }
        }
    %>
    <div id="content-detail">
        <div id="content-title">
            <a href="index.jsp">Home</a> >
            <a href="product-list?category-id=<%=categoryID%>"><%=categoryName%></a> >
            Model: <%=productID%>
        </div>
        <div id="product">
            <div id="product-name">
                <h2><%=productName%></h2>
                <div id="product-detail">
                    <div id="product-detail-left">
                        <div id="product-img">
                            <img src="img/4.jpg"/>
                        </div>
                        <div id="product-img-items">
                            <div><a href="#"><img src="img/6.jpg"/></a></div>
                            <div><a href="#"><img src="img/7.jpg"/></a></div>
                            <div><a href="#"><img src="img/8.jpg"/></a></div>
                            <div><a href="#"><img src="img/9.jpg"/></a></div>
                        </div>
                    </div>
                    <div id="product-detail-right">
                        <div id="product-detail-right-content">
                            <div id="product-price">$ 1000</div>
                            <div id="product-status">In stock</div>
                            <div id="product-detail-buttons">
                                <div id="product-detail-button">
                                    <input type="button" value="BY NOW">
                                    <input type="button" value="ADD TO CART" style="background-color: #fff; color:red;border: 1px solid gray;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="info-detail">
            <div id="info-detail-title">
                <h2>Information detail</h2>
                <div style="margin:10px auto;">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Illum, debitis. Asperiores soluta eveniet eos accusantium doloremque cum suscipit ducimus enim at sapiente mollitia consequuntur dicta quaerat, sunt voluptates autem. Quam!
                    Lorem ipsum dolor, sit amet consectetur adipisicing elit. Rem illum autem veritatis maxime corporis quod quibusdam nostrum eaque laborum numquam quos unde eveniet aut, exercitationem voluptatum veniam fugiat, debitis esse?
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio eligendi ratione vitae nobis numquam dolorum assumenda saepe enim cumque blanditiis, deleniti neque voluptate vel ducimus in omnis harum aut nisi.
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="./template/footer.jsp" %>