package com.xdnice.haowang;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends  SlidingFragmentActivity implements OnClickListener{

	MenuFragment mFrag;
	ImageButton img_btn_menu_left;
	LinearLayout[] ll_footer_btn;
	ImageView[] img_footer_holder;
	TextView[] tv_footer_holder;
	
	int[] footer_image_normal_id={
			R.drawable.recommend,
			R.drawable.classify,
			R.drawable.list,
			R.drawable.manage,
			R.drawable.download
			};
	int[] footer_image_select_id={
			R.drawable.recommend_select,
			R.drawable.classify_select,
			R.drawable.list_select,
			R.drawable.manage_select,
			R.drawable.download_select
	};
	
	
   @Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initSlidingMenu(savedInstanceState);
		initFooterBtn();
		
		img_btn_menu_left = (ImageButton) this.findViewById(R.id.img_btn_menu_left);
		img_btn_menu_left.setOnClickListener(this);
		
	}
   
   
    private void initFooterBtn(){
    	
    	ll_footer_btn = new LinearLayout[5];
    	img_footer_holder = new ImageView[5];
    	tv_footer_holder = new TextView[5];
    	
    	ll_footer_btn[0] = (LinearLayout) this.findViewById(R.id.ll_btn_recommend);
    	ll_footer_btn[1]  = (LinearLayout) this.findViewById(R.id.ll_btn_classify);
    	ll_footer_btn[2]   	 = (LinearLayout) this.findViewById(R.id.ll_btn_list);
    	ll_footer_btn[3] 	 = (LinearLayout) this.findViewById(R.id.ll_btn_manage);
    	ll_footer_btn[4]  = (LinearLayout) this.findViewById(R.id.ll_btn_download);
    	
    	
    	img_footer_holder[0] = (ImageView) this.findViewById(R.id.img_footer_recommend);
    	img_footer_holder[1]  = (ImageView) this.findViewById(R.id.img_footer_classify);
    	img_footer_holder[2]      = (ImageView) this.findViewById(R.id.img_footer_list);
    	img_footer_holder[3]    = (ImageView) this.findViewById(R.id.img_footer_manage);
    	img_footer_holder[4]  = (ImageView) this.findViewById(R.id.img_footer_download);
    	
    	tv_footer_holder[0] = (TextView) this.findViewById(R.id.tv_footer_recommend);
    	tv_footer_holder[1]  = (TextView) this.findViewById(R.id.tv_footer_classify);
    	tv_footer_holder[2]      = (TextView) this.findViewById(R.id.tv_footer_list);
    	tv_footer_holder[3]    = (TextView) this.findViewById(R.id.tv_footer_manage);
    	tv_footer_holder[4]  = (TextView) this.findViewById(R.id.tv_footer_download);
    	
    	//设置各自的背景颜色 设置各自的图片 设置各自的颜色
    	for(int i=0;i<5;i++){
    		ll_footer_btn[i].setBackgroundResource(R.drawable.bottombaritemback);
    		img_footer_holder[i].setBackgroundResource(footer_image_normal_id[i]);
    		tv_footer_holder[i].setTextColor(getResources().getColor(R.color.footer_text_normal));
    		ll_footer_btn[i].setOnClickListener(this);
    	}
    	
    	//设置默认的开机选择id
    	choseFooterBtn(0);
    	
    }
    
    private void choseFooterBtn(int id){
    	ll_footer_btn[id].setBackgroundResource(R.drawable.bottombaritemback_select);
    	img_footer_holder[id].setBackgroundResource(footer_image_select_id[id]);
    	tv_footer_holder[id].setTextColor(getResources().getColor(R.color.footer_text_selected));
    	for(int i=0;i<5;i++){
    		if(i != id){
    			ll_footer_btn[i].setBackgroundResource(R.drawable.bottombaritemback);
        		img_footer_holder[i].setBackgroundResource(footer_image_normal_id[i]);
        		tv_footer_holder[i].setTextColor(getResources().getColor(R.color.footer_text_normal));
    		}
    	}
    }
   
   

   	private void initSlidingMenu(Bundle savedInstanceState){
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
//		getActionBar().setDisplayHomeAsUpEnabled(true);
   	}
   
   
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_btn_menu_left:
			toggle();
			break;
		case R.id.ll_btn_recommend:
			choseFooterBtn(0);
			break;
		case R.id.ll_btn_classify:
			choseFooterBtn(1);
			break;
		case R.id.ll_btn_list:
			choseFooterBtn(2);
			break;
		case R.id.ll_btn_manage:
			choseFooterBtn(3);
			break;
		case R.id.ll_btn_download:
			choseFooterBtn(4);
			break;
			
		default:
			break;
		}
		
		
}
   
   


  
   
}
