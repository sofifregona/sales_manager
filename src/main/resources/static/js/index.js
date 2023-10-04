var main_buttons = document.querySelectorAll(".main-button");
var setting_buttons = document.querySelectorAll(".setting-button");

var settings = document.querySelector("#settings");
var go_back = document.querySelector(".return-link");

var title = document.querySelector(".principal-title");

settings.addEventListener("click", () => {
    setting_buttons.forEach((button) => {
        button.style.display = "inline-block";
    });
    main_buttons.forEach((button) => {
        button.style.display = "none";
    });
    go_back.style.display = "flex";
    title.textContent = "CONFIGURACIÓN";
})

go_back.addEventListener("click", () => {
    main_buttons.forEach((button) => {
        button.style.display = "inline-block";
    });
    go_back.style.display = "none";
    setting_buttons.forEach((button) => {
        button.style.display = "none";
    });
    title.textContent = "MENÚ PRINCIPAL";
})
