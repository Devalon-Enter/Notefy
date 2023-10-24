<?php

if (!function_exists('getAllTasks')) {
    function getAllTasks() {
        // Ziel-URL
        $url = 'http://localhost:8080/api/v1/task';

        // cURL-Initialisierung
        $curl = curl_init($url);

        // cURL-Optionen setzen
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true); // Antwort als String zurückgeben
        curl_setopt($curl, CURLOPT_CUSTOMREQUEST, 'GET'); // GET-Request verwenden
        curl_setopt($curl, CURLOPT_HTTPHEADER, [
            'Content-Type: application/json', // Optional: Falls der Server JSON erwartet
        ]);

        // Request senden und Antwort empfangen
        $response = curl_exec($curl);

        // cURL schließen
        curl_close($curl);

        $decodedData = json_decode($response, true); // Decodes JSON data into an associative array
        return $decodedData;
    }
}

if (!function_exists('getTask')) {
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
}

if (!function_exists('updateTask')) {
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

        // cURL-Initialisierung
        $curl = curl_init($url);

        // cURL-Optionen setzen
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true); // Antwort als String zurückgeben
        curl_setopt($curl, CURLOPT_CUSTOMREQUEST, 'PUT'); // PUT-Request verwenden
        curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($postData)); // Daten im JSON-Format senden
        curl_setopt($curl, CURLOPT_HTTPHEADER, [
            'Content-Type: application/json', // JSON-Format für die Daten
        ]);

        // Request senden und Antwort empfangen
        $response = curl_exec($curl);

        // cURL schließen
        curl_close($curl);

        // Antwort ausgeben
        echo $response;
    }
}

if (!function_exists('getAllDoneTasks')) {
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
}


if (!function_exists('getAllDueTasks')) {
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
}
