<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</div>
</div>
</div>
</div>
</div>
</body>
<footer>
    <!-- jQuery -->
    <script src="<c:url value="../mercado/js/jquery.js" />" ></script>

    <!-- Bootstrap Core JavaScript -->
    <script charset="UTF-8" src="<c:url value="../mercado/js/bootstrap.min.js" />" ></script>
    <script charset="UTF-8" src="<c:url value="../mercado/js/bootstrap.min.js" />" ></script>
    <script charset="UTF-8" src="<c:url value="../mercado/js/datatables/jquery.datatables.min.js" />" ></script>
    <script charset="UTF-8" src="<c:url value="../mercado/js/chart.js" />" ></script>
    <script charset="UTF-8" src="<c:url value="../mercado/js/datatables/datatables.js" />" ></script>

    <!-- Menu Toggle Script -->
    <script>
        $("#menu-toggle").click(function (e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });
    </script>



    <script>
        var chartData = {
            labels: ["Marca1", "Marca2", "Marca3"],
            datasets: [
                {
                    fillColor: "#79D1CF",
                    strokeColor: "#79D1CF",
                    data: [60, 80, 81]
                }
            ]
        };

        var ctx = document.getElementById("myChart2").getContext("2d");
        var myBar = new Chart(ctx).Bar(chartData, {
            showTooltips: false,
            onAnimationComplete: function () {

                var ctx = this.chart.ctx;
                ctx.font = this.scale.font;
                ctx.fillStyle = this.scale.textColor
                ctx.textAlign = "center";
                ctx.textBaseline = "bottom";

                this.datasets.forEach(function (dataset) {
                    dataset.bars.forEach(function (bar) {
                        ctx.fillText(bar.value, bar.x, bar.y - 5);
                    });
                })
            }
        });
    </script>

</footer>
</html>