package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChuckNorrisAPI {
    public static void main(String[] args) {
        try {

            URL url = new URL("https://api.chucknorris.io/jokes/random");


            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            connection.setRequestMethod("GET");


            int responseCode = connection.getResponseCode();
            System.out.println( responseCode);


            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();


            System.out.println( response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
