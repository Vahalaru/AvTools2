package com.example.jerem.avtools;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by jerem on 12/2/2016.
 */

public class HTTPURLConnection {

    String response = "";
    URL url;

    public String ServerData(String path, HashMap<String, String> params) {
        try {
            url = new URL(path);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(params));
            writer.flush();
            writer.close();
            os.close();
            int responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;

                while ((line = br.readLine()) != null) {
                    response += line;
                    Log.d("output lines", line);
                }
            } else {
                response = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("tagconvertstr", "["+response+"]");
        return response.toString();//.toString();
    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        try {
            for (Map.Entry<String, String> param : params.entrySet()){
                if (result.toString().length() !=0) {
                    result.append("&");
                }
                result.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(param.getValue(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Log.i("tagconvertstr", "["+result+"]");

        return result.toString();
    }

    private String getUpdateDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        try {
            for (Map.Entry<String, String> param : params.entrySet()){
                if (result.toString().length() !=0) {
                    result.append("&");
                }
                result.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(param.getValue(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Log.i("tagconvertstr", "["+result+"]");

        return result.toString();
    }

}
