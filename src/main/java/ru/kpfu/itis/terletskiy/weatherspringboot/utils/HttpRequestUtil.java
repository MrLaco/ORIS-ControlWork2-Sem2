package ru.kpfu.itis.terletskiy.weatherspringboot.utils;

import java.io.*;
import java.net.*;
import java.util.*;

public class HttpRequestUtil {
    public static String get(String url, Map<String, String> headers, Map<String, String> params) {
        try {
            URL urlObject = new URL(url + MapQueryUtil.urlEncodeUTF8(params));

            HttpURLConnection postConnection = (HttpURLConnection) urlObject.openConnection();

            postConnection.setRequestMethod("GET");

            for (Map.Entry<String, String> entry : headers.entrySet()) {
                postConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            postConnection.setConnectTimeout(5000);
            postConnection.setReadTimeout(5000);

            StringBuilder content = new StringBuilder();

            // Принимаем байты, конвертируя их в текст
            try (BufferedReader reader =
                         new BufferedReader(
                                 new InputStreamReader(postConnection.getInputStream())
                         )) {
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
            }
            postConnection.disconnect();

            return content.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String post(String url, Map<String, String> headers, Map<String, String> params) {

        try {
            URL urlObject = new URL(url + MapQueryUtil.urlEncodeUTF8(params));

            HttpURLConnection postConnection = (HttpURLConnection) urlObject.openConnection();

            postConnection.setRequestMethod("POST");

            for (Map.Entry<String, String> entry : headers.entrySet()) {
                postConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            postConnection.setConnectTimeout(5000);
            postConnection.setReadTimeout(5000);

            StringBuilder content = new StringBuilder();

            // Принимаем байты, конвертируя их в текст
            try (BufferedReader reader =
                         new BufferedReader(
                                 new InputStreamReader(postConnection.getInputStream())
                         )) {
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
            }
            postConnection.disconnect();

            return content.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}