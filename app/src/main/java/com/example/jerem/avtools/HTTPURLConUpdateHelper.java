package com.example.jerem.avtools;

import android.util.Log;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jerem on 12/3/2016.
 */

public class HTTPURLConUpdateHelper {
    String response = "";
   // URL url;

    public String ServerDataUpdate(String path, HashMap<String, String> params) {

        try {
            //url = new URL(path);
            URL urlToRequest = new URL(path);
            HttpURLConnection urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            //urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            urlConnection.setFixedLengthStreamingMode(
                    getUpdateDataString(params).getBytes().length);
            PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
            out.print(getUpdateDataString(params));
            out.close();
        } catch (Exception e) {
        e.printStackTrace();
    }
    return response.toString();
        }

    private static final char PARAMETER_DELIMITER = '&';
    private static final char PARAMETER_EQUALS_CHAR = '=';
    private String getUpdateDataString(HashMap<String, String> params) throws
        UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();
            try {
                for (Map.Entry<String, String> param : params.entrySet()){
                    if (result.toString().length() !=0) {
                        result.append(PARAMETER_DELIMITER);
                    }
                    result.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                    result.append(PARAMETER_EQUALS_CHAR);
                    result.append(URLEncoder.encode(param.getValue(), "UTF-8"));
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            Log.i("tagconvertstr", "["+result+"]");

            return result.toString();
        }


}
