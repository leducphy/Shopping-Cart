<%@include file="./template/header_admin.jsp" %> 
<div id="content-right">
    <div class="path-admin">DASHBOARD</b></div>
    <div class="content-main">
        <div id="content-main-dashboard">
            <div id="dashboard-1">
                <div id="dashboard-1-container">
                    <div class="dashboard-item">
                        <div class="dashboard-item-title">Weekly Sales</div>
                        <div class="dashboard-item-content">$47K</div>
                    </div>
                    <div class="dashboard-item">
                        <div class="dashboard-item-title">Total Orders</div>
                        <div class="dashboard-item-content">$1000K</div>
                    </div>
                    <div class="dashboard-item">
                        <div class="dashboard-item-title">Total Customers</div>
                        <div class="dashboard-item-content">5K</div>
                    </div>
                    <div class="dashboard-item">
                        <div class="dashboard-item-title">Total Guest</div>
                        <div class="dashboard-item-content">3K</div>
                    </div>
                </div>
            </div>
            <div id="dashboard-2">
                <div id="chart" style="text-align: center;">
                    <div id="chart1">
                        <h3>Statistic Orders (Month)</h3>
                        <canvas id="myChart1" style="width: 100%;"></canvas>
                    </div>
                    <div id="chart2">
                        <canvas id="myChart2" style="width: 80%;"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%@include file="./template/footer_admin.jsp" %> 




