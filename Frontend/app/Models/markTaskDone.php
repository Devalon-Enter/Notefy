<?php

require "../Controller/TaskController.php";

$task = getTask($_POST["id"]);

$task["done"] = true;

updateTask($task);

?>
