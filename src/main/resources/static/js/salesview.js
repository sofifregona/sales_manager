$(document).ready(function () {
  var export_button = document.querySelector(".export-button");

  var principal = document.querySelector(".principal");

  var from = document.querySelector("#from-input");
  var to = document.querySelector("#to-input");

  var error_1 = document.querySelector("#error_1");
  var error_2 = document.querySelector("#error_2");
  var error_3 = document.querySelector("#error_3");

  var filter_button = document.querySelector(".filter-product-button");

  var current_date = new Date();

  from.value = current_date.toISOString().split("T")[0];
  to.value = current_date.toISOString().split("T")[0];

  var register = document.querySelector("#register-title");
  var payment = document.querySelector("#payment-title");

  export_button.addEventListener("click", function () {
    var from, to, now;

    now = `${current_date.getFullYear()}-${
      current_date.getMonth() + 1
    }-${current_date.getDate()}T${current_date.toLocaleTimeString()}`;

    if (window.location.search.includes("from")) {
      from = window.location.search.match(/from=(.{10})/)[1];
      to = window.location.search.match(/to=(.{10})/)[1];
      console.log(from);
      console.log(to);
    } else {
      from = `${current_date.getFullYear()}`;
      if ((current_date.getMonth() + 1).toString().length == 1) {
        from += `-0${current_date.getMonth() + 1}`;
      } else {
        from += `-${current_date.getMonth() + 1}`;
      }
      if (current_date.getDate().toString().length == 1) {
        from += `-0${current_date.getDate()}`;
      } else {
        from += `-${current_date.getDate()}`;
      }
      var next_day = new Date(
        current_date.getFullYear(),
        current_date.getMonth(),
        current_date.getDate() + 1
      );
      to = `${next_day.getMonth() + 1}`;
      if ((next_day.getMonth() + 1).toString().length == 1) {
        to += `-0${next_day.getMonth() + 1}`;
      } else {
        to += `-${next_day.getMonth() + 1}`;
      }
      if (next_day.getDate().toString().length == 1) {
        to += `-0${next_day.getDate()}`;
      } else {
        to += `-${next_day.getDate()}`;
      }
    }

    var export_data = document.querySelector(".export-data");
    var anchor = document.createElement("a");

    var csvData = "\uFEFF" + export_data.textContent;
    var blob = new Blob([csvData], { type: "text/csv;charset=utf-8;" });

    // Generar una URL para el Blob
    var url = window.URL.createObjectURL(blob);

    var name = `SUMMARY_no:${now}_from:${from}_to:${to}`;
    console.log(name);

    // Configurar la URL del anclaje
    anchor.setAttribute("href", url);
    anchor.setAttribute("download", name);

    // Simular un clic en el enlace para iniciar la descarga
    anchor.style.display = "none";
    document.body.appendChild(anchor);
    anchor.click();
    document.body.removeChild(anchor);
  });

  if (window.location.search.includes("from")) {
    from_date = window.location.search.match(/from=(.{10})/)[1];
    to_date = window.location.search.match(/to=(.{10})/)[1];

    from.value = window.location.search.match(/from=(.{10})/)[1];
    to.value = window.location.search.match(/to=(.{10})/)[1];

    if (from_date != to_date) {
      payment.textContent += ` desde ${from_date.split("-")[2]}/${
        from_date.split("-")[1]
      }/${from_date.split("-")[0]} hasta ${to_date.split("-")[2]}/${
        to_date.split("-")[1]
      }/${to_date.split("-")[0]}`;
      register.textContent += ` desde ${from_date.split("-")[2]}/${
        from_date.split("-")[1]
      }/${from_date.split("-")[0]} hasta ${to_date.split("-")[2]}/${
        to_date.split("-")[1]
      }/${to_date.split("-")[0]}`;
    } else {
      register.textContent += ` del día ${from_date.split("-")[2]}/${
        from_date.split("-")[1]
      }/${from_date.split("-")[0]}`;
      payment.textContent += ` del día ${from_date.split("-")[2]}/${
        from_date.split("-")[1]
      }/${from_date.split("-")[0]}`;
    }

    var inputEvent = new Event("input", {
      bubbles: true,
      cancelable: true,
    });
    from.dispatchEvent(inputEvent);
    to.dispatchEvent(inputEvent);
  } else {
    register.textContent += ` del día ${
      current_date.toISOString().split("T")[0].split("-")[2]
    }/${current_date.toISOString().split("T")[0].split("-")[1]}/${
      current_date.toISOString().split("T")[0].split("-")[0]
    }`;
    payment.textContent += ` del día ${
      current_date.toISOString().split("T")[0].split("-")[2]
    }/${current_date.toISOString().split("T")[0].split("-")[1]}/${
      current_date.toISOString().split("T")[0].split("-")[0]
    }`;
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
    principal.style = "width: 600px;";
  }
});
