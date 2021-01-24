package com.jerin.ml.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GoogleFunctionRESTClient {
	
	public static final String GCP_FUNCTION_URL = "https://us-central1-genre-classifier-293000.cloudfunctions.net/process-wav-file-and-predict?wav_audio_file_name=";

	
	public String getPredictionFromCloudFunction(String audioFileName) {
		//String serviceURL = "https://us-central1-genre-classifier-293000.cloudfunctions.net/process-wav-file-and-predict?wav_audio_file_name=";
		//String audioFileName = "classical-mozart.wav";
		String requestUrl = GCP_FUNCTION_URL + audioFileName;
		String prediction = "";
		
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(requestUrl);
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);
			System.out.println("response: " + response);

			if (response.getStatusLine().getStatusCode() != 200) {
				prediction = "Prediction Failed";
				return prediction;
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String serverResponse;
			while ((serverResponse = br.readLine()) != null) {
				prediction = serverResponse;
				break;
			}

			System.out.println("prediction: " + prediction);
			httpClient.getConnectionManager().shutdown();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prediction;
	}
	
	public static void main(String[] args) {
		String audioFileName = "classical-mozart.wav";
		
		GoogleFunctionRESTClient googleFunctionRESTClient = new GoogleFunctionRESTClient();
		String prediction = googleFunctionRESTClient.getPredictionFromCloudFunction(audioFileName);
		
		System.out.println("pred: ***"+prediction+"***");
	}
	
	


}