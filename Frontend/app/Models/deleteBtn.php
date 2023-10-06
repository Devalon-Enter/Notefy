<?php

function deleteButton($id) {
    return "<form action='../app/Models/deleteNote.php' method='post'>
                <input type='hidden' name='DeleteId' value='" . $id . "'>
                <input type='submit' value='Delete'>
            </form>";
}