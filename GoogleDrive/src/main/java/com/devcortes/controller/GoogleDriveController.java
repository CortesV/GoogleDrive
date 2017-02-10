package com.devcortes.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devcortes.service.GoogleDriveService;
import com.google.api.services.drive.model.File;

@RestController
@RequestMapping(value = "/google")
public class GoogleDriveController {

	@Autowired
	GoogleDriveService googleDriveService;

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public void showFiles() throws IOException {
		googleDriveService.showFiles();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createGoogleDocFile() throws IOException {
		googleDriveService.createGoogleDocFile();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteFile() throws IOException {
		googleDriveService.deleteFile();
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downloadFile() throws IOException {
		googleDriveService.downloadFile();
	}
}
