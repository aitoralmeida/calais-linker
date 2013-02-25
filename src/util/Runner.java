package util;

import java.io.IOException;

import client.CalaisClient;

public class Runner {

	public static void main(String[] args) {
		CalaisClient client = new CalaisClient();
		try {
			client.getAnalysis();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
