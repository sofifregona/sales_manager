$(document).ready(function () {
  $("#select-menu").selectize({
    sortField: "text",
  });

  var go_back = document.querySelector(".go-back");
  var return_back = document.querySelector(".return-link");

  var principal = document.querySelector(".principal");

  var button = document.querySelector("#add-button");
  var select_input = document.querySelector(".selectize-input");

  var units = document.querySelector("#units-input");
  var prices = document.querySelectorAll(".price-hidden");
  var subtotal = document.querySelector("#subtotal");
  
  var checkbox = document.querySelector("#checkbox");
  var subtotals = document.querySelectorAll("#subtotal-td");
  var total = document.querySelector(".total-list");
  var close_button = document.querySelector(".close-sale-button");
  var payments = document.querySelectorAll(".payment-option");

  var unit_error = document.querySelector("#unit-error");
  var product_error = document.querySelector("#product-error");

  if (window.location.pathname.length > 5) {
    select_input.focus();
    return_back.style = "display: none;";
    go_back.style = "display: flex;";
    principal.style = "width: 800px;";
    units.onfocus = () => {
      if (select_input.classList.contains("full")) {
        product_error.style = "display: none;"
        var id = document.querySelector(".item").getAttribute("data-value");
        units.addEventListener("input", () => {
          console.log(units.value)
          if (units.value < 0 || units.value % 1 !== 0) {
            unit_error.style = "display: block;"
            button.disabled = true;
          } else {
            button.disabled = false;
            unit_error.style = "display: none;"
            prices.forEach((element) => {
              if (id === element.id.split("_")[1]) {
                subtotal.value = units.value * element.value;
              }
            });
          }
        });
      } else {
        button.disabled = true;
        product_error.style = "display: block;"
      }
    };

    select_input.addEventListener("click", () => {
      units.value = 0;
      subtotal.value = 0;
      button.disabled = true;
      product_error.style = "display: none;"
    });

    checkbox.addEventListener("input", () => {
      if (checkbox.checked) {
        total.textContent = total.textContent * 0.8;
        subtotals.forEach((subtotal) => {
          subtotal.textContent = subtotal.textContent * 0.8;
        });
      } else {
        total.textContent = total.textContent / 0.8;
        subtotals.forEach((subtotal) => {
          subtotal.textContent = subtotal.textContent / 0.8;
        });
      }
    });

    close_button.addEventListener("click", () => {
      var payment_mth;
      payments.forEach((payment) => {
        if (payment.selected) {
          payment_mth = payment.textContent;
        }
      });
      alert(
        `** CIERRE DE MESA **\n Total a cobrar ${
          total.textContent
        } con ${payment_mth.toLowerCase()}.`
      );
    });
  } else {
    return_back.style = "display: flex;";
    go_back.style = "display: none;";
    principal.style = "width: 400px;";
  }
});
