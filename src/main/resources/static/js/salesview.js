$(document).ready(function () {
  var principal = document.querySelector(".principal");

  var from = document.querySelector("#from-input");
  var to = document.querySelector("#to-input");

  var error_1 = document.querySelector("#error_1");
  var error_2 = document.querySelector("#error_2");
  var error_3 = document.querySelector("#error_3");

  var filter_button = document.querySelector(".filter-product-button");

  from.value = new Date().toISOString().split("T")[0];
  to.value = new Date().toISOString().split("T")[0];
  var current_date = new Date().toISOString().split("T")[0];

  var register = document.querySelector("#register-title");

  if(window.location.search.includes("from") && window.location.search.includes("to")) {
    register.textContent += ` desde ${window.location.search.match(/from=(.{10})/)[1]} hasta ${window.location.search.match(/to=(.{10})/)[1]}`
  }

  from.addEventListener("input", () => {
    if (from.value > current_date) {
      error_2.style = "display: block;";
      filter_button.disabled = true;
    } else {
      error_2.style = "display: none;";
      if (from.value > to.value) {
        error_1.style = "display: block;";
        filter_button.disabled = true;
      } else {
        error_1.style = "display: none;";
        filter_button.disabled = false;
      }
    }
  });

  to.addEventListener("input", () => {
    if (to.value > current_date) {
      error_3.style = "display: block;";
      filter_button.disabled = true;
    } else {
      error_3.style = "display: none;";
      if (from.value > to.value) {
        error_1.style = "display: block;";
        filter_button.disabled = true;
      } else {
        error_1.style = "display: none;";
        filter_button.disabled = false;
      }
    }
  });

  if (window.location.search.includes("units")) {
    document.querySelector("#select-order").value = "desc_units";
  }

  if (
    window.location.search.includes("category") ||
    window.location.search.includes("brand")
  ) {
    principal.style = "width: 600px;"
  }
});
