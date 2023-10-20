<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <title>HomePage</title>
</head>
<body>
    <div class="landingScreen">
        <h1 class="pageTitle">Notefy</h1>

        <div class="createTaskBox">
            <div class="createTaskBoxContainer">
                <h2>Create a new Task</h2>

                <form action="../app/Models/createTask.php" method="post">
                    <label for="title">Title:</label><br>
                    <input type="text" name="title" id="title" required autofocus>
                    <br>

                    <label for="description">Description:</label><br>
                    <textarea name="description" id="description"></textarea>
                    <br>

                    <label for="priority">Priority:</label><br>
                    <select name="priority" id="priority" required>
                        <option value="CRITICAL">CRITICAL</option>
                        <option value="HIGH">HIGH</option>
                        <option value="MINOR" selected>MINOR</option>
                        <option value="LOW">LOW</option>
                    </select>
                    <br>

                    <label for="dueDate">Due Date:</label><br>
                    <input type="date" name="dueDate" id="dueDate" required>
                    <br>

                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>

    </div>


    <div class="showTasks">
        <h2 class="pageTitle">All tasks</h2>

        <div class="dueTasks">

            <?php
                include '../app/Models/showDueTasks.php';
            ?>
        </div>

        <div class="doneTasks">

            <?php
                //include '../app/Models/showDoneTasks.php';
            ?>
        </div>
    </div>

</body>
</html>





