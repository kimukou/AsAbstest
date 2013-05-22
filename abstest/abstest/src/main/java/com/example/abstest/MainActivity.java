package com.example.abstest;

import android.os.Bundle;
import com.actionbarsherlock.app.SherlockActivity;
import com.example.lib_yutori.hogeDriven;

public class MainActivity extends SherlockActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Sherlock);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hogeDriven a = new hogeDriven();
        a.print();
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    
}
