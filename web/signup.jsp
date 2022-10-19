<%@include file="./template/header.jsp" %>
<div id="content">
    <div id="form">
        <div id="form-title">
            <span><a href="signup" style="color: red;">SIGN UP</a></span>
            <span><a href="signin">SIGN IN</a></span>
        </div>
        <div id="form-content">
            <form action="" method="post">
                <label>Company name<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtCopName" value = ${txtCopName}><br/>
                <%
                    if(request.getAttribute("msgCPN") != null) {
                %>  
                <span class="msg-error">
                    <% out.println(request.getAttribute("msgCPN"));%>
                </span><br/><%}%>
                <label>Contact name<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtCName" value = ${txtCName}><br/>
                <%
                    if(request.getAttribute("msgCTN") != null) {
                %>  
                <span class="msg-error">
                    <% out.println(request.getAttribute("msgCTN"));%>
                </span><br/><%}%>                
                <label>Contact title<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtTitle" value = ${txtTitle}><br/>
                <%
                    if(request.getAttribute("msgCTT") != null) {
                %>  
                <span class="msg-error">
                    <% out.println(request.getAttribute("msgCTT"));%>
                </span><br/><%}%>                
                <label>Address<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtAddress" value = ${txtAddress}><br/>
                <%
                    if(request.getAttribute("msgADR") != null) {
                %>  
                <span class="msg-error">
                    <% out.println(request.getAttribute("msgADR"));%>
                </span><br/><%}%>                
                <label>Email<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtEmail" value = ${txtEmail}><br/>
                <%
                    if(request.getAttribute("msgE") != null) {
                %>  
                <span class="msg-error">
                    <% out.println(request.getAttribute("msgE"));%>
                </span><br/><%}%>                
                <label>Password<span style="color: red;">*</span></label><br/>
                <input type="password" name="txtPass"/><br/>
                <%
                    if(request.getAttribute("msgP") != null) {
                %>  
                <span class="msg-error">
                    <% out.println(request.getAttribute("msgP"));%>
                </span><br/><%}%>                
                <label>Re-Password<span style="color: red;">*</span></label><br/>
                <input type="password" name="txtRePass"/><br/>
                <%
                    if(request.getAttribute("msgRP") != null) {
                %>  
                <span class="msg-error">
                    <% out.println(request.getAttribute("msgRP"));%>
                </span><br/><%}%>                
                <div></div>
                <input type="submit" value="SIGN UP" style="margin-bottom: 30px;"/>
            </form>
        </div>
    </div>
</div>
<%@include file="./template/footer.jsp" %>