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
        return JSON.stringify(data);
    })
    .catch(error => {
        console.error("Error:", error);
    });
}

async function sendtoGetTask(phpFileName, params) {
    try {
        let response = await fetch(phpFileName, {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: params // Your POST data
        });

        let data = await response.text();
        return JSON.stringify(data);
    } catch (error) {
        console.error("Error:", error);
        throw error; // Re-throw the error if you want to handle it elsewhere
    }

}

async function showEditTask(taskId) {

    // Get the TaskData from ID
    let params = "taskId=" + taskId;
    let TaskData = await sendtoGetTask("../app/Models/getTask.php", "id=" + taskId);
    let Task = JSON.parse(TaskData);
    Task = JSON.parse(Task);

    // Change the taskBoxTitle
    document.getElementById("taskBoxTitle").innerHTML = "Edit Task";

    // Change the form action
    const taskBoxForm = document.getElementById("taskBoxForm");
    taskBoxForm.action = "../app/Models/editTask.php";

    // Create the additional elements
    const isDoneLabel =document.createElement("label");
    isDoneLabel.htmlFor = "done";
    isDoneLabel.className = "doneLabel";
    isDoneLabel.innerHTML = "  Task done?";

    const isDone = document.createElement("input");
    isDone.checked = Task.done;
    isDone.type = "checkbox";
    isDone.name = "done";
    isDone.id = "done";

    const returnButton = document.createElement("button");
    returnButton.onclick = function () { window.location.replace("/") };
    returnButton.class = "returnButton";
    returnButton.innerHTML = "Return";

    // Fill in the values of the Task
    const form = document.getElementById("taskBoxForm");
    const id = document.getElementById("id");
    const title = document.getElementById("title");
    const descriptionLabel = document.getElementById("descriptionLabel");
    const description = document.getElementById("description");
    const priority = document.getElementById("priority");
    const dueDate = document.getElementById("dueDate");
    const saveButton = document.getElementById("taskBoxSubmit");

    form.insertBefore(isDoneLabel, descriptionLabel);
    form.insertBefore(isDone, isDoneLabel);
    form.insertBefore(returnButton, saveButton);

    id.value = Task.id;
    title.value = Task.title;
    description.innerHTML = Task.description;
    priority.value = Task.priority;
    dueDate.value = Task.dueDate;
    saveButton.value = "Save";

    window.scrollTo(0, 0);
}

function deleteTask(deleteId) {
    sendHttpPostRequest("../app/Models/deleteTask.php", "deleteId=" + deleteId);
    location.reload();
}

function markTaskDone(id) {
    sendHttpPostRequest("../app/Models/markTaskDone.php", "id=" + id);
    location.reload();
}