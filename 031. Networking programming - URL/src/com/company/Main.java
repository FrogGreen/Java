//Networking Programming - Uniform Resource Locator

package com.company;

import java.io.*;
import java.net.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.org");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;

            URL urlWrong = new URL("http://example.org/somethingwentwrong.jpg");
            URLConnection urlConnectionWrong = urlWrong.openConnection();
            HttpURLConnection httpURLConnectionWrong = (HttpURLConnection) urlConnectionWrong;

            Scanner scanner = new Scanner(System.in);
            int number;

            System.out.println("Please decide what you want to do:");
            System.out.println("1. Read contents of web page");
            System.out.println("2. Show headers");
            System.out.println("3. Read contents of web page in another way");
            System.out.println("4. Read contents of web page with wrong address");
            System.out.println("5. To exit");

            try {
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Something went wrong, next time will be better");
                return;
            }

            switch (number) {

                //Read contents of web page
                case 1:
                    urlConnection.setDoOutput(true);
                    urlConnection.connect();

                    System.out.println("Read contents of web page:");
                    readContent(urlConnection);
                    break;

                //Show headers of web page
                case 2:
                    urlConnection.setDoOutput(true);
                    urlConnection.connect();

                    System.out.println("Show headers of web page");
                    readHeaders(urlConnection);
                    break;

                //Read contents of web page
                case 3:
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Cookie", "Firefox");
                    httpURLConnection.setReadTimeout(500);
                    httpURLConnection.connect();

                    System.out.println("La");
                    readContentAnotherMethod(httpURLConnection);
                    break;

                //Read contents of web page with wrong address
                case 4:
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Cookie", "Firefox");
                    httpURLConnection.setReadTimeout(500);

                    System.out.println("Read contents of web page with wrong address");
                    readContentAnotherMethod(httpURLConnectionWrong);
                    break;

                //Exit
                default:
                    break;

            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    public static void readContent(URLConnection urlConnection) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            String string;

            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    public static void readHeaders(URLConnection urlConnection) {
        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            String headers = entry.getKey();
            List<String> content = entry.getValue();
            System.out.println("Headers: " + headers);
            for (String string : content)
                System.out.println("Content: " + string);
            System.out.println("----------");
        }
    }

    public static void readContentAnotherMethod(HttpURLConnection httpURLConnection) {
        try {
            int responseCode = httpURLConnection.getResponseCode();

            System.out.println("Web page response code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("Following web page read error occurs:");
                System.out.println(httpURLConnection.getResponseMessage());
                return;
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String string;

            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
