<?php

function deleteButton($id) {
    return "<form action='../app/Models/deleteTask.php' method='post'>
                <input type='hidden' name='DeleteId' value='" . $id . "'>
                <input type='submit' value='Delete'>
            </form>";
}