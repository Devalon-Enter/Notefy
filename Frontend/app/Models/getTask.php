<?php
include "../Controller/TaskController.php";

$id = $_POST["id"];


if (!empty($id)) {
    // The file was called from JS File
    echo json_encode(getTask($id));
}
