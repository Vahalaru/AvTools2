package com.example.jerem.avtools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class AddNewPlane extends BaseActivity {

    private ProgressDialog pDialog;
    private JSONObject json;
    private int success=0;
    private HTTPURLConnection service;
    private String strpname ="", strptype ="", strpclass="", strpstyle="", strpnotes="", strpjetlo="";
    //Initialize webservice URL
    private String path = "http://www.broprogramming.com/avtoolsapp/create_plane.php";
    private String whatIsThePlane;
    private String whatIsTheStyle;

    Button savesubmit;
    Spinner spinner;
    Spinner pclass;
    ArrayAdapter<CharSequence> adapter;
    String pjetlo;
    String pstyle;
    EditText pnotes;
    TextInputEditText pname;
    TextInputEditText ptype;
    RadioButton radioButton;
    RadioButton radioButton2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_plane);

       //pclass
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.plane_class_spinner_data, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //pname, ptype, pstyle, pnotes, pjetlo
        pname = (TextInputEditText) findViewById(R.id.input_plane_name);
        ptype = (TextInputEditText) findViewById(R.id.input_plane_type);
        pnotes = (EditText) findViewById(R.id.plane_notes);
        pclass = (Spinner) findViewById(R.id.spinner);
        pstyle = whatIsTheStyle;
        pjetlo = whatIsThePlane;

        savesubmit = (Button) findViewById(R.id.save_button);

        //Initialize HTTPURLConnection class object
        service=new HTTPURLConnection();

        savesubmit.setOnClickListener(new View.OnClickListener() {
           RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio);
            RadioGroup radioGroup2 = (RadioGroup)findViewById(R.id.radio2);
            @Override
            public void onClick(View v) {
                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();
                int selectedID2 = radioGroup2.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                radioButton2 = (RadioButton) findViewById(selectedID2);
                whatIsThePlane = radioButton.getText().toString();
                whatIsTheStyle = radioButton2.getText().toString();

                if (!pname.getText().toString().equals("") && !ptype.getText().toString().equals("") && !pclass.getSelectedItem().toString().equals("") && !pnotes.getText().toString().equals("")) {
                    // && !pjetlo.equals("")  && !pstyle.equals("")
                    strpname = pname.getText().toString();
                    strptype = ptype.getText().toString();
                    strpclass = pclass.getSelectedItem().toString();
                    strpstyle = whatIsTheStyle;
                            //radioButton2.getText();
                    strpnotes = pnotes.getText().toString();
                    strpjetlo = whatIsThePlane;
                    //Call WebService
                    new PostDataTOServer().execute();
                } else {
                    Toast.makeText(getApplicationContext(), "Please Enter all fields", Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(AddNewPlane.this, MainActivity.class);
                startActivity(i);
            }
        });
    }


    private class PostDataTOServer extends AsyncTask<Void, Void, Void> {

        String response = "";
        //Create hashmap Object to send parameters to web service
        HashMap<String, String> postDataParams;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(AddNewPlane.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            postDataParams=new HashMap<String, String>();
            postDataParams.put("pname", strpname);
            postDataParams.put("ptype", strptype);
            postDataParams.put("pclass", strpclass);
            postDataParams.put("pstyle", strpstyle);
            postDataParams.put("pnotes", strpnotes);
            postDataParams.put("pjetlo", strpjetlo);

            //Call ServerData() method to call webservice and store result in response
            response= service.ServerData(path,postDataParams);
            try {
                json = new JSONObject(response);
                //Get Values from JSONobject
                System.out.println("success=" + json.get("success"));
                success = json.getInt("success");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
            if(success==1) {
                Toast.makeText(getApplicationContext(), "Plane Added successfully..!", Toast.LENGTH_LONG).show();
            }
        }
    }

}









