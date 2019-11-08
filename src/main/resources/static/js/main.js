'use strict';

var uploadForm = document.querySelector('#uploadForm');
var fileUploadInput = document.querySelector('#fileUploadInput');
var fileUploadError = document.querySelector('#fileUploadError');
var fileUploadSuccess = document.querySelector('#fileUploadSuccess');

function uploadFile(file) {
    var formData = new FormData();
    formData.append("file", file);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/uploadFile");

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {
            fileUploadError.style.display = "none";
			uploadForm.innerHTML = "";
            fileUploadSuccess.innerHTML = "<p><a href='" + response.fileUri + "' target='_blank'>" + response.fileUri + "</a></p>";
            fileUploadSuccess.style.display = "block";
        } else {
            fileUploadSuccess.style.display = "none";
            fileUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
        }
    }

    xhr.send(formData);
}

uploadForm.addEventListener('submit', function(event){
    var files = fileUploadInput.files;
    if(files.length === 0) {
        fileUploadError.innerHTML = "Please select a file";
        fileUploadError.style.display = "block";
    }
    uploadFile(files[0]);
    event.preventDefault();
}, true);
