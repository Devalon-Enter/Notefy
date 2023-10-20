<?php
include "../app/Controller/TaskController.php";

foreach (getAllDoneTasks() as $DueTask) {
    echo "<div class='taskBox'>";
    echo "<p class='taskBoxTitle'>" . $DueTask["title"] ."</p>";
    echo "<p class='taskBoxCreateDate'>Created at: " . $DueTask["createDate"] . "</p>";
    echo "<p class='taskBoxDescription'>" . $DueTask["description"] . "</p>";
    echo "<p class='taskBoxPriority " . $DueTask["priority"] . "'>" . $DueTask["priority"] . "</p>";
    echo "<span class='taskBoxDueDate'>Due to: " . $DueTask["dueDate"] . "</span>";
    echo "<button class='editButton'>Edit</button>";
    echo "<button class='deleteButton'>Delete</button>";
    echo "<button class='doneButton'>✔</button>";
    echo "</div>";
}
