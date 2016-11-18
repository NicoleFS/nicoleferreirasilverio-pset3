package com.example.nicole.nicoleferreirasilverio_pset3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nicole on 18-11-2016.
 */
public class HttpRequestHelper {

    // make string for URL
    private static final String url1 = "http://omdbapi.com/?s=";
    private static final String url2 = "/";

    // method to download from server
    protected static synchronized String downloadFromServer(String... params) {
        // declare return string result
        String result = "";

        // get chose tag from argument
        String chosenTag = params[0];

        // complete string for url
        String completeUrl = url1 + chosenTag + url2;

        // turn string into URL
        URL url = null;

        try {
            url = new URL(completeUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // make the connection
        HttpURLConnection connection;
        if (url != null) {
            try {
                //open connection, set request method
                connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("GET");

                // get response code
                Integer responseCode = connection.getResponseCode();

                // if 200-300, read inputstream
                if (200 <= responseCode && responseCode <= 299) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = br.readLine()) != null) {
                        result = result + line;
                    }
                } else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    // communicate correct error, aan de hand van de error message die je krijgt
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
}
