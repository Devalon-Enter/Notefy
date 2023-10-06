<?php


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

// Antwort ausgeben
//echo $response;

$decodedData = json_decode($response, true); // Decodes JSON data into an associative array
foreach ($decodedData as $item) {
    echo "<tr>";
    // Format the HTML Table
    echo "<td>" . $item["title"] . "</td>";
    echo "<td>" . $item["priority"] . "</td>";
    echo "<td>" . $item["done"] . "</td>";      // Somehow does not work yet
    echo "<td>" . $item["createDate"] . "</td>";
    echo "<td>" . $item["dueDate"] . "</td>";
    echo "</tr>";
}