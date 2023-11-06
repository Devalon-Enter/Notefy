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
    isDone.type = "checkbox";
    isDone.name = "done";
    isDone.id = "done";
    isDone.checked = Task.done;

    const returnButton = document.createElement("button");
    returnButton.onclick = () => { window.location.replace("/") };
    returnButton.class = "returnButton";
    returnButton.innerHTML = "Return";

    // Fill in the values of the Task
    const form = document.getElementById("taskBoxForm");
    const elementsToUpdate = {
        id: "id",
        title: "title",
        description: "description",
        priority: "priority",
        dueDate: "dueDate",
        saveButton: "taskBoxSubmit"
    };

    for (const key in elementsToUpdate) {
        if (Object.hasOwnProperty.call(elementsToUpdate, key)) {
            const element = document.getElementById(elementsToUpdate[key]);
            if (key === "description") {
                element.innerHTML = TaskData[key];
            } else {
                element.value = TaskData[key];
            }
        }
    }

    form.insertBefore(isDoneLabel, document.getElementById("descriptionLabel"));
    form.insertBefore(isDone, isDoneLabel);
    form.insertBefore(returnButton, document.getElementById("taskBoxSubmit"));

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