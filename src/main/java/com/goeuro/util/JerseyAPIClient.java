package com.goeuro.util;

import com.sun.jersey.api.client.Client;

public class JerseyAPIClient {

	private static Client client;

	private JerseyAPIClient() {

	}

	public static Client getInstance() {
		if (client == null) {
			synchronized (JerseyAPIClient.class) {
				if (client == null) {
					client = Client.create();
				}
			}
		}
		return client;
	}

}
