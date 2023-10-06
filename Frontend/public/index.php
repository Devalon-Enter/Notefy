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
    <title>Landing Page</title>
</head>
<body>
    <h1>This is my landing Page</h1>
    <p>Create a note!!</p>

    <form action="../app/Models/createNote.php" method="post">
        <label for="title">Title:</label>
        <input type="text" name="title" id="title" required autofocus>
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

    <h2>All Notes</h2>
    <table>
        <tr>
            <th>Title</th>
            <th>Priority</th>
            <th>Status</th>
            <th>Creation Date</th>
            <th>Due Date</th>
            <th></th>
        </tr>
        <?php
        include '../app/Models/getAllNotes.php';
        ?>
    </table>
</body>
</html>





