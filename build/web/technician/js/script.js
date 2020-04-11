var APP = {

    showTelephone : function () {
        document.getElementById("telephone").style.display = "flex";
        document.getElementById("tv").style.display = "none";
    },

    showTV : function () {
        document.getElementById("telephone").style.display = "none";
        document.getElementById("tv").style.display = "flex";
    },

    init_showTelephone : function () {
        $("#telephoneButton").change(APP.showTelephone);
    },

    init_showTV : function () {
        $("#tvButton").change(APP.showTV);
    }
}

$(document).ready(function () {
    APP.init_showTelephone();
    APP.init_showTV();
});