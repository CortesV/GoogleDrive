package com.devcortes.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.devcortes.components.GetDrive;
import com.devcortes.components.GoogleAuthorization;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

@Service
public class GoogleDriveService extends GoogleAuthorization {

	private static Logger log = Logger.getLogger(GoogleDriveService.class);

	public void showFiles() throws IOException {
		// Build a new authorized API client service.
		Drive service = GetDrive.getDriveService();

		// Print the names and IDs for up to 10 files.
		FileList result = service.files().list().setMaxResults(10).execute();
		List<File> files = result.getItems();
		if (files == null || files.size() == 0) {
			System.out.println("No files found.");
		} else {
			System.out.println("Files:");
			for (File file : files) {
				System.out.printf("\t%s (%s)\n", file.getTitle(), file.getId());
			}
		}
	}

	public void createGoogleDocFile() throws IOException {
		Drive service = GetDrive.getDriveService();

		String mimeType = "application/vnd.google-apps.document";
		String description = "my first test with google docs";

		File createdFile = new File();
		createdFile.setTitle("Hey. Second test");
		createdFile.setMimeType(mimeType);
		createdFile.setDescription(description);

		File file = service.files().insert(createdFile).execute();
		System.out.println("File ID: " + file.getId());

	}

	public void deleteFile() throws IOException {
		Drive service = GetDrive.getDriveService();
		String fileId = "1yvsgdIqeD03pHvypCKeHPePZARWOtwWPwVIR6qHkOVk";
		service.files().delete(fileId).execute();
	}

	public void downloadFile() throws IOException {

		Drive service = GetDrive.getDriveService();
		String fileId = "16UPrL9TK68HyizjOy0us1Tmsflr0aWaEHH4HCN_hIR8";

		String mimeType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		
		InputStream inputStream = service.files().export(fileId, mimeType).executeAsInputStream();
		OutputStream outputStream = new FileOutputStream(new java.io.File("/home/cortes/Test.docx"));
		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}

	

	}

}