'use strict'

window.onload = function () {

    const statusText = document.getElementById("status");
    const urlParams = new URLSearchParams(window.location.search);

    const success = ("true" === urlParams.get("success"));

    statusText.innerText = success ? "was a success!" : "was a failure....";

};