<?php
require "../Controller/TaskController.php";

$TaskArray = $_POST;
updateTask($TaskArray);

header('Location: /');
