package com.example.admin.assignment_preference;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.admin.assignment_preference.R.id.edit_query;
import static com.example.admin.assignment_preference.R.id.spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {
    EditText ed1, ed2, ed3;
    Button b1;
    Spinner s;
    TextView tv;
    ArrayAdapter<String> aa;
    String sdetails[] = {"Name", "Subject", "Email"};


    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        ed1 = (EditText) view.findViewById(R.id.et1);
        ed2 = (EditText) view.findViewById(R.id.et2);
        ed3 = (EditText) view.findViewById(R.id.et3);
        b1 = (Button) view.findViewById(R.id.button1);
        s = (Spinner) view.findViewById(R.id.spinner);
        tv = (TextView) view.findViewById(R.id.textview1);
        aa = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, sdetails);
        s.setAdapter(aa);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("credentials", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();//open editor
                editor.putString("name", ed1.getText().toString());//write name
                editor.putString("sub", ed2.getText().toString());
                editor.putString("email", ed3.getText().toString());
                editor.commit();//save into preference file
                Toast.makeText(getActivity(), "store data", Toast.LENGTH_SHORT).show();

               String  value1 = sharedPreferences.getString("name", null);
                String value2 = sharedPreferences.getString("sub", null);
                String value3 = sharedPreferences.getString("email", null);
                tv.setText(" Name : " + value1 + "\n Subject : " + value2 + "\n Email : " + value3);

                return;


            }
        });
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "click:" + position, Toast.LENGTH_SHORT).show();
                // int j=spinner.getSelectedItemPosition();
                int j = position;
                if (j == 0) {
                    ed1.setText("");
                    ed1.requestFocus();
                    SharedPreferences sp = getActivity().getSharedPreferences("credentials", 0);
                    SharedPreferences.Editor et = sp.edit();
                    et.putString("name", ed1.getText().toString());


                } else if (j == 1) {
                    ed2.setText("");
                    ed2.requestFocus();
                    SharedPreferences sp = getActivity().getSharedPreferences("credentials", 0);
                    SharedPreferences.Editor et = sp.edit();
                    et.putString("sub", ed2.getText().toString());

                } else if (j == 2) {
                    ed3.setText("");
                    ed3.requestFocus();
                    SharedPreferences sp = getActivity().getSharedPreferences("credentials", 0);
                    SharedPreferences.Editor et = sp.edit();
                    et.putString("email", ed3.getText().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }
}