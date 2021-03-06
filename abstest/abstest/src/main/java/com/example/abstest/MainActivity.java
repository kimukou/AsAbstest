package com.example.abstest;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuInflater;
import android.support.v4.app.FragmentTransaction;


import com.example.lib_yutori.hogeDriven;

import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OptionsMenu;

import android.util.Log;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class MainActivity extends SherlockActivity  implements ActionBar.TabListener{
    final String TAG = "MainActivity";

    //ActionBarSherlock 
    //see http://blog.water-cell.jp/2012/08/abs-replace/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Sherlock);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
	
	//Tabの利用
	final ActionBar mActionBar = getSupportActionBar();
	mActionBar.addTab(mActionBar.newTab().setText("tab1").setTabListener(this));
	mActionBar.addTab(mActionBar.newTab().setText("tab2").setTabListener(this));
	mActionBar.addTab(mActionBar.newTab().setText("tab3").setTabListener(this));
	mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	
	
        hogeDriven a = new hogeDriven();
        a.print();
	
	String json="{aaa}";
	try{
		SampleModel model = SampleModelGererated.get(json);
		Log.v(TAG,"SampleModelGererated::get="+model.getDummyKey());
	}catch(Exception e){
		Log.e(TAG,"SampleModelGererated::get",e);
	}

   }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.main, menu);
	return true;
    }
*/
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
 

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(Tab tab,FragmentTransaction ft){

    }
}
