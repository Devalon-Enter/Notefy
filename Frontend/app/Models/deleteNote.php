<?php

// Ziel-URL
$url = 'http://localhost:8080/api/v1/task/' . $_POST["DeleteId"];

// cURL-Initialisierung
$curl = curl_init($url);

// cURL-Optionen setzen
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true); // Antwort als String zurückgeben
curl_setopt($curl, CURLOPT_CUSTOMREQUEST, 'DELETE'); // DELETE-Request verwenden
curl_setopt($curl, CURLOPT_HTTPHEADER, [
    'Content-Type: application/json', // Optional: Falls der Server JSON erwartet
]);

// Request senden und Antwort empfangen
$response = curl_exec($curl);

// cURL schließen
curl_close($curl);

// Antwort ausgeben
//echo $response;

header('Location: /');