package com.xdnice.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.xdnice.customclass.MyPagerAdapter;
import com.xdnice.haowang.R;

public class RecommendFragment extends Fragment implements OnPageChangeListener{

	private static final String TAG = "RecommendFragment";
	
	private View view;
	private TextView tvSift;  //精选
	private TextView tvclassify; //分类
	private TextView tvranking;  //排行
	private ImageView imgTabPointer;
	private int tabPointerW;
	private int offset;
	private ViewPager mViewPager;
	private List<View> listViews;
	private MyPagerAdapter mPagerAdapter;
	private Context context;
	//精选viewpager
	private View viewSift;
	//分类Viewpager
	private View viewClassify;
	//排行
	private View viewRanking;
	private float screenW;
	
	SlidingMenu sm;
	
	public RecommendFragment(SlidingMenu sm) {
		// TODO Auto-generated constructor stub
		this.sm = sm;
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(com.xdnice.haowang.R.layout.recommend_fragment, null); 
		context = getActivity().getApplicationContext();
		initTabTextColor();
		initImagePointer();
		initViewPager();
		return view;
	}
	
	
	/**
	 * 初始化viewpager
	 */
	private void initViewPager(){
		mViewPager = (ViewPager) view.findViewById(R.id.tab_pager);
		listViews = new ArrayList<View>();
		mPagerAdapter = new MyPagerAdapter(listViews);
		LayoutInflater inflater = LayoutInflater.from(context);
		viewSift = inflater.inflate(R.layout.sift_pager, null);
		viewClassify = inflater.inflate(R.layout.classify_pager, null);
		viewRanking = inflater.inflate(R.layout.ranking_pager, null);
		
		listViews.add(viewSift);
		listViews.add(viewClassify);
		listViews.add(viewRanking);
				
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setCurrentItem(0);
		mViewPager.setOnPageChangeListener(this);
	}
	
	
	/**
	 * 初始化pointer的大小和位置
	 */
	private void initImagePointer(){
		
		imgTabPointer = (ImageView) view.findViewById(R.id.img_tab_pointer);
		tabPointerW = BitmapFactory.decodeResource(getResources(), R.drawable.title_bar_bg)
				.getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		float screenW = dm.widthPixels;
		offset = 0;
		Matrix matrix = imgTabPointer.getImageMatrix();
		matrix.postScale((float)screenW/3/tabPointerW, 1);
		matrix.postTranslate(0, 0);
		imgTabPointer.setImageMatrix(matrix);
		
		Log.v(TAG, "screenW="+screenW);
	}
	
	
	/**
	 * 初始化三个标签页的字体颜色
	 */
	private void initTabTextColor(){
		tvSift = (TextView) view.findViewById(R.id.tv_sift);
		tvclassify = (TextView) view.findViewById(R.id.tv_classify);
		tvranking = (TextView) view.findViewById(R.id.tv_ranking);
		
		tvSift.setTextColor(getResources().getColor(android.R.color.black));
		tvclassify.setTextColor(getResources().getColor(android.R.color.black));
		tvranking.setTextColor(getResources().getColor(android.R.color.black));
	}


	
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		
		Log.v(TAG, "onPageScrollStateChanged");
		
	}


	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
		Log.v(TAG, "onPageScrolled--->arg0="+arg0+"arg1="+arg1+"arg2="+arg2);
		
	}


	@Override
	public void onPageSelected(int arg0) {
		
		if(arg0 == 0){
			sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		}else{
			sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		}
		
	}
	
	
}
