package com.example.jerem.avtools;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class listviewmain extends AppCompatActivity implements SearchView.OnQueryTextListener{


    // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    private RecyclerView recyclerView;
    private Recycler_View_Adapter madapter;
    List<MyData> data;
    List<MyData> filterData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewmain);




        //Make call to AsyncTask
        new AsyncFetch().execute();
    }



    private class AsyncFetch extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(listviewmain.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();
        }

        @Override
        protected String doInBackground(String... params) {
             try {
                // Enter URL address where your json file resides
                url = new URL("http://www.broprogramming.com/avtoolsapp/get_all_planes.php");
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return e.toString();
            }
            try {
                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("GET");
                // setDoOutput to true as we recieve data from json file
                conn.setDoOutput(true);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return e1.toString();
            }
            try {
                int response_code = conn.getResponseCode();
                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    // Pass data to onPostExecute method
                    return (result.toString());
                } else {
                    return ("unsuccessful");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }
        }

        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread

                data=new ArrayList<>();
                filterData = new ArrayList<>();

            pdLoading.dismiss();
            try {
               // JSONArray jArray = new JSONArray(result);
                JSONObject Jasonobject = new JSONObject(result);
                JSONArray jArray = Jasonobject.getJSONArray("result");

                // Extract data from json and store into ArrayList as class objects
                for(int i=0;i<jArray.length();i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    MyData planeData = new MyData();
                    planeData.id= json_data.getInt("id");
                    planeData.pname= json_data.getString("pname");
                    planeData.ptype= json_data.getString("ptype");
                    planeData.pclass= json_data.getString("pclass");
                    planeData.pstyle= json_data.getString("pstyle");
                    planeData.pnotes= json_data.getString("pnotes");
                    planeData.pjetlo= json_data.getString("pjetlo");
                    data.add(planeData);
                }


                // Setup and Handover data to recyclerview
                recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
                madapter = new Recycler_View_Adapter(listviewmain.this, data);
                recyclerView.setAdapter(madapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(listviewmain.this));


            } catch (JSONException e) {
                Toast.makeText(listviewmain.this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.listviewmenu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        List<MyData> filteredData = filter(data, newText);
        if (filteredData.size()>0){
            Recycler_View_Adapter adapter = new Recycler_View_Adapter(listviewmain.this, filteredData);
            adapter.setFilter(filteredData);
            recyclerView.setLayoutManager(new LinearLayoutManager(listviewmain.this));

            return true;
        }else{
            return false;
        }

       // return false;
    }

    private List<MyData> filter(List<MyData> data, String query){
        query = query.toLowerCase();

        List<MyData> filteredData = new ArrayList<>();
        for (MyData data1:data){
           String text =  data1.getPname().toLowerCase();
            String text2 = data1.getPtype().toLowerCase();
            if (text.contains(query)|text2.contains(query)){
                filteredData.add(data1);
            }
        }
        data.clear();
        data.addAll(filteredData);
        madapter.notifyDataSetChanged();
        return data;
    }


}

