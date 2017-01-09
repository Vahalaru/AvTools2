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
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;

/**
 * Created by jerem on 12/2/2016.
 */

public class PlaneUpdate extends BaseActivity {

    private ProgressDialog pDialog;
    private JSONArray json;
    private int success = 0;
    private HTTPURLConnection service;
    private String strpname = "", strptype = "", strpclass = "", strpstyle = "", strpnotes = "", strpjetlo = "", strid = "";
    //Initialize webservice URL
    private String path = "http://www.broprogramming.com/avtoolsapp/update.php";

    String passpid;
    String PlaneName;
    String PlaneType;
    String PlaneClass;
    String PlaneStyle;
    String PlaneNotes;
    String PlaneJetLo;
    String ppllClass;
    private TextView hiddenid;
    private Button savesubmit2;
    private Spinner pclass2;
    private String whatIsThePlane2;
    private String whatIsTheStyle2;
    private EditText pnotes2;
    private TextInputEditText pname2;
    TextInputEditText ptype2;
    public RadioGroup radioGroup3;
    public RadioGroup radioGroup4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planeupdate);

        service=new HTTPURLConnection();

        passpid = getIntent().getStringExtra("id");
        PlaneName = getIntent().getStringExtra("pname");
        PlaneType = getIntent().getStringExtra("ptype");
        PlaneClass = getIntent().getStringExtra("pclass");
        PlaneStyle = getIntent().getStringExtra("pstyle");
        PlaneNotes = getIntent().getStringExtra("pnotes");
        PlaneJetLo = getIntent().getStringExtra("pjetlo");

//pclass
        pclass2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.plane_class_spinner_data, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pclass2.setAdapter(adapter);
        ppllClass=PlaneClass;
        selectSpinnerValue(pclass2,ppllClass);

        //pname, ptype, pstyle, pnotes, pjetlo
        pname2 = (TextInputEditText) findViewById(R.id.input_plane_name2);
        ptype2 = (TextInputEditText) findViewById(R.id.input_plane_type2);
        pnotes2 = (EditText) findViewById(R.id.plane_notes2);
        hiddenid = (TextView) findViewById(R.id.hiddenCardId2);

        radioGroup3 = (RadioGroup)findViewById(R.id.radio3);
        radioGroup4 = (RadioGroup)findViewById(R.id.radio4);
       // radioButtonJ = (RadioButton)findViewById(R.id.radioJet2);
        savesubmit2 = (Button) findViewById(R.id.save_button2);

        hiddenid.setText(passpid);
        pname2.setText(PlaneName);
        ptype2.setText(PlaneType);
        pnotes2.setText(PlaneNotes);

        radioSetter();

        savesubmit2.setOnClickListener(new View.OnClickListener() {

           // RadioGroup radioGroup3 = (RadioGroup)findViewById(R.id.radio3);
          //  RadioGroup radioGroup4 = (RadioGroup)findViewById(R.id.radio4);


            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId3 = radioGroup3.getCheckedRadioButtonId();
                int selectedID4 = radioGroup4.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                RadioButton radioButton3 = (RadioButton) findViewById(selectedId3);
                RadioButton radioButton4 = (RadioButton) findViewById(selectedID4);

                whatIsThePlane2 = radioButton3.getText().toString();
                whatIsTheStyle2 = radioButton4.getText().toString();

                if (!pname2.getText().toString().equals("") && !ptype2.getText().toString().equals("") && !hiddenid.equals("")) {
                    strid = hiddenid.getText().toString();
                    strpname = pname2.getText().toString();
                    strptype = ptype2.getText().toString();
                    strpclass = pclass2.getSelectedItem().toString();
                    strpstyle = whatIsTheStyle2;
                    strpnotes = pnotes2.getText().toString();
                    strpjetlo = whatIsThePlane2;

                    //Call WebService
                    new PostDataTOServer().execute();
                } else {
                    Toast.makeText(getApplicationContext(), "Please Enter all fields", Toast.LENGTH_LONG).show();
                }
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

            pDialog = new ProgressDialog(PlaneUpdate.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
           // protected Void doInBackground(Void... arg0) {
            postDataParams=new HashMap<String, String>();
            postDataParams.put("id", strid);
            postDataParams.put("pname", strpname);
            postDataParams.put("ptype", strptype);
            postDataParams.put("pclass", strpclass);
            postDataParams.put("pstyle", strpstyle);
            postDataParams.put("pnotes", strpnotes);
            postDataParams.put("pjetlo", strpjetlo);

            //Call ServerData() method to call webservice and store result in response
            response= service.ServerData(path,postDataParams);
            try {
                json = new JSONArray(response);
                //Get Values from JSONobject
                System.out.println("success=" + json.get(Integer.parseInt("success")));
                success = json.getInt(Integer.parseInt("success"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

            @Override
            protected void onPostExecute (Void result){
                super.onPostExecute(result);
                if (pDialog.isShowing())
                    pDialog.dismiss();
                if (success == 1) {
                    Toast.makeText(getApplicationContext(), "Plane updated successfully..!", Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(PlaneUpdate.this, MainActivity.class);
                startActivity(i);
            }
        }

    private void selectSpinnerValue(Spinner spinner, String mystring)
    {
        int index = 0;
        for(int i = 0; i < spinner.getCount(); i++){
            if(spinner.getItemAtPosition(i).toString().equals(mystring)){
                spinner.setSelection(i);
                break;
            }
        }
    }

    private void radioSetter(){
        if("Jet".equals(PlaneJetLo)){
            radioGroup3.check(R.id.radioJet2);
        }else{radioGroup3.check(R.id.radioLowLead2);}

        if("Gravity".equals(PlaneStyle)){
            radioGroup4.check(R.id.radioGravity2);
        }else{radioGroup4.check(R.id.radioPressure2);}
    }

    }
