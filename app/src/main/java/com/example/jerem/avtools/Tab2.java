package com.example.jerem.avtools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jerem on 12/19/2016.
 */

public class Tab2 extends Fragment {

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1,
                container, false);
        final TextView tTx = (TextView) view.findViewById(R.id.numPUsed);
        final TextView tTx2 = (TextView) view.findViewById(R.id.numPleft);


        final EditText etx = (EditText) view.findViewById(R.id.numGal);
        final EditText etx2 = (EditText) view.findViewById(R.id.numPrist);
        final Double[] dbetx = new Double[2];
        final Double[] dbetx2 = new Double[2];
        Button button = (Button) view.findViewById(R.id.btnSolve);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dbetx[1] = Double.parseDouble(String.valueOf(etx.getText()));
                dbetx2[1] = Double.parseDouble(String.valueOf(etx2.getText()));
                // Double dbetx = Double.parseDouble(String.valueOf(etx));
                //Double dbetx2 = Double.parseDouble(String.valueOf(etx2));

                Double numpad1;
                Double numpad2;

                numpad1 = (dbetx[1] *.11)/128;
                numpad2 = dbetx2[1] -numpad1;

                numpad1 = Double.valueOf(String.format("%.3f", numpad1));
                numpad2 = Double.valueOf(String.format("%.3f", numpad2));

                tTx.setText(String.valueOf(numpad1));
                tTx2.setText(String.valueOf(numpad2));

            }
        });
        return view;
    }
}
