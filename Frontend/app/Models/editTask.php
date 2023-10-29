<?php
require "../Controller/TaskController.php";

$TaskArray = $_POST;

// Check if the Done Checkbox is checked
if ($TaskArray["done"] == "on") {
    $TaskArray["done"] = true;
}

updateTask($TaskArray);

header('Location: /');
