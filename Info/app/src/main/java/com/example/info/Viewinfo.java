package com.example.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Viewinfo extends AppCompatActivity {
    TextView viewit;
    static String nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_viewinfo);
        viewit=findViewById(R.id.info);
        Intent it = getIntent();
        nm = (it.getStringExtra(Login.name));
        FileInputStream fis=null;
        String u="";
        try {
            fis=openFileInput(nm);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            String text;
            while((text=br.readLine())!=null) {
                u=u+"\n"+text;
            }

            fis.close();

        }
        catch(Exception e)
        {}
        viewit.setText(u);
        viewit.setMovementMethod(new ScrollingMovementMethod());
    }
}
