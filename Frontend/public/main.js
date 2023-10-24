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

    console.log(Task)

    // Change the taskBoxTitle
    document.getElementById("taskBoxTitle").innerHTML = "Edit Task";

    // Change the form action
    const taskBoxForm = document.getElementById("taskBoxForm");
    taskBoxForm.action = "../app/Models/editTask.php";

    // Create the additional elements
    const isDoneLabel =document.createElement("label");
    isDoneLabel.htmlFor = "done";
    isDoneLabel.innerHTML = "Is the Task done?";

    const isDone = document.createElement("input");
    isDone.checked = Task.done;
    isDone.type = "checkbox";
    isDone.name = "done";
    isDone.id = "done";

    const br = document.createElement("br");

    const returnButton = document.createElement("button");
    returnButton.onclick = function () { window.location.replace("/") };
    returnButton.innerHTML = "Return";

    // Fill in the values of the Task
    document.getElementById("id").value = Task.id;
    document.getElementById("title").value = Task.title;
    const description = document.getElementById("description");
    description.innerHTML = Task.description
    document.getElementById("taskBoxForm").insertBefore(isDone, description);
    document.getElementById("taskBoxForm").insertBefore(isDoneLabel, isDone);
    document.getElementById("taskBoxForm").insertBefore(br, isDoneLabel);
    document.getElementById("priority").value = Task.priority;
    document.getElementById("dueDate").value = Task.dueDate;
    const saveButton = document.getElementById("taskBoxSubmit");
    saveButton.value = "Save"
    document.getElementById("taskBoxForm").insertBefore(returnButton, saveButton);
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