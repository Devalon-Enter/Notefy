<?php
include "../app/Controller/TaskController.php";

foreach (getAllDoneTasks() as $DueTask) {
    echo "<div class='dueTaskBox'>";
    echo "<p>" . $DueTask["title"] ."</p>";
    echo "<p>" . $DueTask["description"] . "</p>";
    echo "<p>" . $DueTask["priority"] . "</p>";
    echo "<p>" . $DueTask["createDate"] . "</p>";
    echo "<p>" . $DueTask["dueDate"] . "</p>";
    echo "</div>";
}