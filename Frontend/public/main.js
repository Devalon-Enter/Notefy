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

function sendHttpPostRequest(phpFileName, params) {
    fetch(phpFileName, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: params // Your POST data
    })
    .then(response => response.text())
    .then(data => {
        // Handle the response from the PHP file
        console.log(data);
    })
    .catch(error => {
        console.error("Error:", error);
    });
}

function showEditTask(Task) {

}

function deleteTask(deleteId) {
    sendHttpPostRequest("../app/Models/deleteTask.php", "deleteId=" + deleteId);
    location.reload();
}

function markTaskDone(id) {
    sendHttpPostRequest("../app/Models/markTaskDone.php", "id=" + id);
    location.reload();
}