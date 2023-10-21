<?php
include "../app/Controller/TaskController.php";

$doneTasks = getAllDoneTasks();

if (empty($doneTasks)) {
    echo "<p>No tasks were completed yet.</p>";
} else {
    foreach ($doneTasks as $DoneTask) {
        echo "<div class='taskBox'>";
        echo "<p class='taskBoxTitle'>" . $DoneTask["title"] ."</p>";
        echo "<p class='taskBoxCreateDate'>Created at: " . $DoneTask["createDate"] . "</p>";
        echo "<p class='taskBoxDescription'>" . $DoneTask["description"] . "</p>";
        echo "<p class='taskBoxPriority " . $DoneTask["priority"] . "'>" . $DoneTask["priority"] . "</p>";
        echo "<span class='taskBoxDueDate'>Due to: " . $DoneTask["dueDate"] . "</span>";
        echo "<button class='editButton'>Edit</button>";
        echo "<button class='deleteButton'>Delete</button>";
        echo "<button class='doneButton'>✔</button>";
        echo "</div>";
    }
}
