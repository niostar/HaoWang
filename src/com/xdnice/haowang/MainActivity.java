package com.xdnice.haowang;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class MainActivity extends  SlidingFragmentActivity implements OnClickListener{

	MenuFragment mFrag;
	ImageButton img_btn_menu_left;
	
   @Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		setTitle("HaoWang");
		//set the behind View
		setBehindContentView(R.layout.menu_frame);
		if(savedInstanceState == null){
			//first create this task
			FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
			mFrag = new MenuFragment();
			t.replace(R.id.leftmenu, mFrag);
			t.commit();
		}else{  //application had create 
			FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
			mFrag = (MenuFragment) this.getSupportFragmentManager().findFragmentById(R.id.leftmenu);
			t.replace(R.id.leftmenu, mFrag);
			t.commit();
		}
		
		//customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setMode(SlidingMenu.LEFT);
		
	//	getActionBar().setDisplayHomeAsUpEnabled(true);
		
		img_btn_menu_left = (ImageButton) this.findViewById(R.id.img_btn_menu_left);
		img_btn_menu_left.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.img_btn_menu_left){
			toggle();
		}
	}
   
   


  
   
}
