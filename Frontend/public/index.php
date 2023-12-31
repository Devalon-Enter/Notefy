<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <link rel="shortcut icon" href="./images/TasksIcon.png" type="image/x-icon">
    <script src="main.js"></script>
    <title>HomePage</title>
</head>
<body>
    <div class="landingScreen">
        <h1 class="pageTitle">Notefy</h1>

        <div class="createTaskBox">
            <div class="createTaskBoxContainer">
                <h2 id="taskBoxTitle">Create a new Task</h2>

                <form action="../app/Models/createTask.php" method="post" id="taskBoxForm">
                    <input type="hidden" name="id" id="id" value="">
                    
                    <label for="title">Title:</label>
                    <input type="text" name="title" id="title" required autofocus>

                    <label for="description" id="descriptionLabel">Description:</label>
                    <textarea name="description" id="description"></textarea>

                    <label for="priority">Priority:</label>
                    <select name="priority" id="priority" required>
                        <option value="CRITICAL">CRITICAL</option>
                        <option value="HIGH">HIGH</option>
                        <option value="MINOR" selected>MINOR</option>
                        <option value="LOW">LOW</option>
                    </select>

                    <label for="dueDate">Due Date:</label>
                    <input type="date" name="dueDate" id="dueDate" required>

                    <input type="submit" id="taskBoxSubmit" value="Submit">
                </form>
            </div>
        </div>

    </div>


    <div class="showTasks">
        <h2 class="pageTitle">All tasks</h2>

        <div id="dueTasks">

            <?php
                require_once '../app/Models/showDueTasks.php';
            ?>
        </div>

        <p onclick="showDoneTasks()" id="showDoneTasksTitle">Show Done Tasks</p>

        <div id="doneTaskVisibility">
            <div id="doneTasks">
                <?php
                require_once '../app/Models/showDoneTasks.php';
                ?>
            </div>
        </div>
    </div>

</body>
</html>
