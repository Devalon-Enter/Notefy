<?php
include "../app/Controller/TaskController.php";

$doneTasks = getAllDueTasks();

if (empty($doneTasks)) {
    echo "<p>No tasks were created yet.</p>";
} else {
    foreach (getAllDueTasks() as $DueTask) {
        $id = $DueTask["id"];
        echo "<div class='taskBox'>";
        echo "<p class='taskBoxTitle'>{$DueTask["title"]}</p>";
        echo "<p class='taskBoxCreateDate'>Created at: {$DueTask["createDate"]}</p>";
        echo "<p class='taskBoxDescription'>{$DueTask["description"]}</p>";
        echo "<p class='taskBoxPriority {$DueTask["priority"]}'>{$DueTask["priority"]}</p>";
        echo "<span class='taskBoxDueDate'>Due to: {$DueTask["dueDate"]}</span>";
        echo "<button class='editButton' onclick='showEditTask({$id})' id='EditTask_{$id}'>Edit</button>";
        echo "<button class='deleteButton' onclick='deleteTask({$id})'>Delete</button>";
        echo "<button class='doneButton' onclick='markTaskDone({$id})'>✔</button>";
        echo "</div>";
    }
}
