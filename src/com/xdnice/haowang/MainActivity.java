package com.xdnice.haowang;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.xdnice.fragment.ClassifyFragment;
import com.xdnice.fragment.DownloadFragment;
import com.xdnice.fragment.ListGameFragment;
import com.xdnice.fragment.ManageFragment;
import com.xdnice.fragment.RecommendFragment;

public class MainActivity extends  SlidingFragmentActivity implements OnClickListener{

	private static final String TAG = "MainActivity";
	
	//customize the SlidingMenu
	SlidingMenu sm;
	
	MenuFragment mFrag;  //slidingMenu
	ImageButton img_btn_menu_left; //left menu btn
	LinearLayout[] ll_footer_btn;
	ImageView[] img_footer_holder;
	TextView[] tv_footer_holder;
	
	Fragment[] footerFragment;
	RecommendFragment mRecommendFragment;  //recommend fragment
	ClassifyFragment mClassifyFragment;
	ListGameFragment mListGameFragment;
	ManageFragment mManageFragment;
	DownloadFragment mDownloadFragment;
	int currentFragmentId = -1;  //标记当前的fragment的id
	
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
		addFragmentForFooter();
		initFooterBtn();
		
	}
   
   
   /**
	*  为下面的菜单选择添加对应的fragment 
	*/
	private void addFragmentForFooter(){
		
		mRecommendFragment = new RecommendFragment(sm);
		mClassifyFragment  = new ClassifyFragment(sm);
		mListGameFragment = new ListGameFragment();
		mManageFragment = new ManageFragment();
		mDownloadFragment = new DownloadFragment();
		
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.add(R.id.ContentFragment, mRecommendFragment, "recommend");
		fragmentTransaction.add(R.id.ContentFragment, mClassifyFragment,"classify");
		fragmentTransaction.add(R.id.ContentFragment, mListGameFragment,"list");
		fragmentTransaction.add(R.id.ContentFragment, mManageFragment,"manage");
		fragmentTransaction.add(R.id.ContentFragment, mDownloadFragment,"download");
		
		fragmentTransaction.hide(mRecommendFragment);
		fragmentTransaction.hide(mClassifyFragment);
		fragmentTransaction.hide(mListGameFragment);
		fragmentTransaction.hide(mManageFragment);
		fragmentTransaction.hide(mDownloadFragment);
		fragmentTransaction.commit();
		
		footerFragment = new Fragment[5];
		footerFragment[0] = mRecommendFragment;
		footerFragment[1] = mClassifyFragment;
		footerFragment[2] = mListGameFragment;
		footerFragment[3] = mManageFragment;
		footerFragment[4] = mDownloadFragment;
		
    }
   
   
	private void choseOneFragment(int id){
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		//Log.v(TAG, "choseOneFragment  --->currentFragmentId="+currentFragmentId);
		if(currentFragmentId != -1){
			fragmentTransaction.hide(footerFragment[currentFragmentId]);
		}
		fragmentTransaction.show(footerFragment[id]);
		currentFragmentId = id;
		fragmentTransaction.commit();
	}
	
   
    /**
     * 初始化底部的按钮 菜单
     */
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
    	choseOneFragment(0);
    	
    }
    
    /**
     * @param id
     * 用于选点某个菜单项被选中
     */
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
   
   

   	/**
   	 * @param savedInstanceState
   	 * 用于初始化 slidingMenu  并且为左上角的按钮添加监听
   	 */
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
		
		sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setMode(SlidingMenu.LEFT);
//		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		//为左上角的按钮添加监听
		img_btn_menu_left = (ImageButton) this.findViewById(R.id.img_btn_menu_left);
		img_btn_menu_left.setOnClickListener(this);
		
		
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
			choseOneFragment(0);
			break;
		case R.id.ll_btn_classify:
			choseFooterBtn(1);
			choseOneFragment(1);
			break;
		case R.id.ll_btn_list:
			choseFooterBtn(2);
			choseOneFragment(2);
			break;
		case R.id.ll_btn_manage:
			choseFooterBtn(3);
			choseOneFragment(3);
			break;
		case R.id.ll_btn_download:
			choseFooterBtn(4);
			choseOneFragment(4);
			break;
			
		default:
			break;
		}
		
		
}
   
   


  
   
}
