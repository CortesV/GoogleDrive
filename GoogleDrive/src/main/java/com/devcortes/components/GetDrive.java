package com.devcortes.components;

import java.io.IOException;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.drive.Drive;

public class GetDrive {
	/**
	 * Build and return an authorized Drive client service.
	 * 
	 * @return an authorized Drive client service
	 * @throws IOException
	 */
	public static Drive getDriveService() throws IOException {
		Credential credential = GoogleAuthorization.authorize();
		return new Drive.Builder(GoogleAuthorization.getHTTP_TRANSPORT(), GoogleAuthorization.getJsonFactory(),
				credential).setApplicationName(GoogleAuthorization.getApplicationName()).build();
	}
}
