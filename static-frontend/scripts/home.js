
const optionsButton = document.getElementById("options-button");
const sidebarOptions = document.getElementById("main-sidebar");

optionsButton.addEventListener("click", () => {
    const currentDisplay = sidebarOptions.style.display;
    if(currentDisplay == "block"){
        sidebarOptions.style.display = "none";
    } else {
        sidebarOptions.style.display = "block";
    }
});