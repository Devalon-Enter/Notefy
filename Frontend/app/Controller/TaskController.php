<?php

require_once "APIController.php";

/**
 * Returns an array of all the Tasks that can be found in Database
 * @return mixed
 */
function getAllTasks() {
    $allTasks = sendToAPI("", null, "GET");

    return json_decode($allTasks, true);
}

/**
 * Creates a new Task
 *
 * @param array $task Task Element with all the TaskData
 */
function createTask($task) {
    // Daten, welche der API gegeben werden
    $givenPostData = array(
        'title' => $task["title"],
        'priority' => $task["priority"],
        'done' => false,
        'createDate' => date("Y-m-d"),
        'dueDate' => $task["dueDate"],
        'description' => $task["description"]
    );

    sendToAPI("", $givenPostData, "POST");
}

/**
 * Gets values of Task with ID
 * @param int $taskId   ID of requested Task
 * @return mixed
 */
function getTask($taskId) {
    $url = "http://localhost:8080/api/v1/task/{$taskId}";

    // cURL-Initialisierung
    $curl = curl_init($url);

    // cURL-Optionen setzen
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true); // Antwort als String zurückgeben
    curl_setopt($curl, CURLOPT_HTTPHEADER, [
        'Content-Type: application/json' // Optional: Falls der Server JSON erwartet
    ]);

    // Request senden und Antwort empfangen
    $response = curl_exec($curl);

    // cURL schließen
    curl_close($curl);

    // Antwort als Array zurückgeben (geparstes JSON)
    return json_decode($response, true);
}

/**
 * Update a Task using the TaskClass
 *
 * @param   array $task   Task Element with all the TaskData
 *
 */
function updateTask($task) {

    $id = strval($task["id"]);
    $url = "http://localhost:8080/api/v1/task/{$id}";


    // Daten, die du im POST-Request senden möchtest (falls erforderlich)
    $postData = array(
        'title' => $task["title"],
        'priority' => $task["priority"],
        'done' => $task["done"],
        'dueDate' => $task["dueDate"],
        'description' => $task["description"]
    );

    $response = sendToAPI("/{$id}", $postData, "PUT");

    // Antwort ausgeben
    echo $response;
}

/**
 * Deletes the Task with the given ID
 * @param $id
 * @return void
 */
function deleteTask($id) {
    sendToAPI("/{$id}", null, "DELETE");
}

/**
 * Gets a an array of all the Tasks that are marked as 'done'
 * @return array
 */
function getAllDoneTasks() {
    $DoneTasks = [];
    if (empty(getAllTasks())) return $DoneTasks;

    foreach (getAllTasks() as $Task) {
        if ($Task["done"] == 1) {
            array_push($DoneTasks, $Task);
        }
    }

    return $DoneTasks;
}


/**
 * Gets a an array of all the Tasks that are NOT marked as 'done'
 * @return array
 */
function getAllDueTasks() {
    $DueTasks = [];
    if (empty(getAllTasks())) return $DueTasks;

    foreach (getAllTasks() as $Task) {
        if (empty($Task["done"])) {
            array_push($DueTasks, $Task);
        }
    }

    return $DueTasks;
}
