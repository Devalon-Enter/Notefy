<?php

/**
 * Sends an API Request to the provided API
 * @param string $urlAddition If needed an Adittion to the API URL
 * @param array $postData  Data that is being transmittet with the API
 * @param string $requestMethod Method that is needed to run API Request. Options: POST, PUT, GET, ...
 * @return bool|string
 */
function sendToAPI($urlAddition = "", $postData, $requestMethod) {
    // Ziel-URL
    $url = 'http://localhost:8080/api/v1/task' . $urlAddition;

    // cURL-Initialisierung
    $curl = curl_init($url);

    // cURL-Optionen setzen
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true); // Antwort als String zurückgeben
    curl_setopt($curl, CURLOPT_CUSTOMREQUEST, $requestMethod); // POST-Request verwenden
    curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($postData)); // Daten im JSON-Format senden
    curl_setopt($curl, CURLOPT_HTTPHEADER, [
        'Content-Type: application/json', // JSON-Format für die Daten
    ]);

    // Request senden und Antwort empfangen
    $response = curl_exec($curl);

    // cURL schließen
    curl_close($curl);

    return $response;
}