package ru.kpfu.itis.terletskiy.weatherspringboot.utils;

import java.nio.charset.*;
import java.util.*;
import java.net.URLEncoder;

public class MapQueryUtil {

    static String urlEncodeUTF8(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
    }

    static String urlEncodeUTF8(Map<?,?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?,?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }

            sb.append(urlEncodeUTF8(entry.getKey().toString()))
                    .append("=")
                    .append(urlEncodeUTF8(entry.getValue().toString()));
        }

        return sb.toString();
    }
}
