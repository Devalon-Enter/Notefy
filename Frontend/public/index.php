<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Google fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <!-- Google Fonts end -->
    <link rel="stylesheet" href="style.css">
    <title>HomePage</title>
</head>
<body>
    <div class="landingScreen">
        <h1>Notefy</h1>

        <div class="taskBox">
            <h2>Create a new Task</h2>

            <form action="../app/Models/createTask.php" method="post">
                <label for="title">Title:</label>
                <input type="text" name="title" id="title" required autofocus>
                <br>

                <label for="description">Description:</label>
                <textarea name="description" id="description"></textarea>
                <br>

                <label for="priority">Priority:</label>
                <select name="priority" id="priority" required>
                    <option value="CRITICAL">CRITICAL</option>
                    <option value="HIGH">HIGH</option>
                    <option value="MINOR">MINOR</option>
                    <option value="LOW">LOW</option>
                </select>
                <br>

                <label for="dueDate">Due Date:</label>
                <input type="date" name="dueDate" id="dueDate" required>
                <br>

                <input type="submit" value="Submit">
            </form>
        </div>
    </div>


    <div class="showTasks">
        <div class="dueTasks">
            <h2>All tasks</h2>

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





