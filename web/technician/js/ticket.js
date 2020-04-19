var APP = {

    showCustomers: function () {
        $.ajax({

            url: "/WebApp-TicketAssistance/client/getcustomers.htm",
            method: "GET",
            contentType: "application/json; charset=utf-8",
            accepts: {json: "application/json, text/javascript"},
            cache: false,
            timeout: 1000000,
            success: function (data) {
                var customers = JSON.parse(data);

                var input = document.getElementById("customer");

                for (var i = 0; i < customers.length; i++) {

                    var customer = customers[i];

                    var cont = input.innerHTML;

                    input.innerHTML = cont + "<option value='" + customer.username + "'>";
                }

            },
            error: function () {

            }
        });
    },

    showTelephone: function () {
        document.getElementById("telephone").style.display = "flex";
        document.getElementById("tv").style.display = "none";
    },

    showTV: function () {
        document.getElementById("telephone").style.display = "none";
        document.getElementById("tv").style.display = "flex";
    },

    init_showTelephone: function () {
        $("#telephoneButton").change(APP.showTelephone);
    },

    init_showTV: function () {
        $("#tvButton").change(APP.showTV);
    }
};

$(document).ready(function () {

    APP.init_showTelephone();
    APP.init_showTV();
    APP.showCustomers();
});