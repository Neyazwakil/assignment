package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICallExample {
    public static void main(String[] args) {
        try {

            URL url = new URL("https://api.zippopotam.us/us/33162");


            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();


            System.out.println(response.toString());

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
