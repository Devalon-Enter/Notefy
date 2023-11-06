<?php

include "../Controller/TaskController.php";

deleteTask($_POST["deleteId"]);

header('Location: /');