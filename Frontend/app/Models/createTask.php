<?php
include "../Controller/TaskController.php";

createTask($_POST);

header('Location: /');
