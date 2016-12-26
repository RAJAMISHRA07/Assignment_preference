package com.example.admin.assignment_preference;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentOne fragmentOne=new FragmentOne();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,fragmentOne);
        fragmentTransaction.commit();
        Dialog_Fragment dialog_fragment=new Dialog_Fragment();
        dialog_fragment.show(getSupportFragmentManager(),null);
    }
}
