function showDoneTasks() {
    var showDoneTasksDOMElement = document.getElementById("doneTaskVisibility");
    showDoneTasksDOMElement.style.display = "inline";

    var buttonText = document.getElementById("showDoneTasksTitle");
    buttonText.innerHTML = "Hide Done Tasks";
    buttonText.setAttribute("onClick", "hideDownTasks()");
}

function hideDownTasks() {
    var showDoneTasksDOMElement = document.getElementById("doneTaskVisibility");
    showDoneTasksDOMElement.style.display = "none";

    var buttonText = document.getElementById("showDoneTasksTitle");
    buttonText.innerHTML = "Show Done Tasks";
    buttonText.setAttribute("onClick", "showDoneTasks()");
}