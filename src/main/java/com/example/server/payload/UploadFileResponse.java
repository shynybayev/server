package com.example.server.payload;

public class UploadFileResponse {
    private String fileUri;

    public UploadFileResponse(String fileUri) {
        this.fileUri = fileUri;
    }
	
	public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }
}