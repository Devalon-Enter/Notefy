<?php

// Ziel-URL
$url = 'http://localhost:8080/api/v1/task';

// Daten, die du im POST-Request senden möchtest (falls erforderlich)
$postData = array(
    'title' => $_POST["title"],
    'priority' => $_POST["priority"],
    'done' => false,
    'createDate' => date("Y-m-d"),
    'dueDate' => $_POST["dueDate"],
    'description' => $_POST["description"]
);

// cURL-Initialisierung
$curl = curl_init($url);

// cURL-Optionen setzen
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true); // Antwort als String zurückgeben
curl_setopt($curl, CURLOPT_CUSTOMREQUEST, 'POST'); // POST-Request verwenden
curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($postData)); // Daten im JSON-Format senden
curl_setopt($curl, CURLOPT_HTTPHEADER, [
    'Content-Type: application/json', // JSON-Format für die Daten
]);

// Request senden und Antwort empfangen
$response = curl_exec($curl);

// cURL schließen
curl_close($curl);

header('Location: /');
