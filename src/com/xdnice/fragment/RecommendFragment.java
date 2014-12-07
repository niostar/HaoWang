package com.xdnice.fragment;

import java.util.ArrayList;
import java.util.List;

import android.R.anim;
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.xdnice.constans.RecommendConstans;
import com.xdnice.customclass.ApplicationItem;
import com.xdnice.customclass.MyGridView;
import com.xdnice.customclass.MyRecommendGridViewAdapter;
import com.xdnice.customclass.MyViewPagerAdapter;
import com.xdnice.customclass.MyXListViewAdapter;
import com.xdnice.customclass.RecommendGridItem;
import com.xdnice.haowang.R;
import com.xdnice.xlistview.XListView;


public class RecommendFragment extends Fragment implements OnPageChangeListener,OnClickListener{

	private static final String TAG = "RecommendFragment";
	
	private View view;
	private TextView tvSift;  //精选
	private TextView tvClassify; //分类
	private TextView tvRanking;  //排行
	private ImageView imgTabPointer;	//游标
	private int selectPageIndex=0;
	private int currentPager=0;
	private int tabPointerW;
	private int offset;
	private ViewPager mViewPager;
	private List<View> listViews;
	private MyViewPagerAdapter mPagerAdapter;
	private Context context;
	private View viewSift;	//精选viewpager
	private View viewClassify;	//分类Viewpager
	private View viewRanking;	//排行
	private float screenW;
	private float currentPointerX=0.0f;
	private int currentValue;
	private boolean isBtnChose = false;
	
	private XListView xSiftListView;	//xListview
	SlidingMenu sm;
	private MyGridView mGridViewRemenfenlei;
	private MyGridView mGridViewGame;
	private MyGridView mGridViewSoft;
	
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
		mPagerAdapter = new MyViewPagerAdapter(listViews);
		LayoutInflater inflater = LayoutInflater.from(context);
		viewSift = inflater.inflate(R.layout.sift_pager, null);
		viewClassify = inflater.inflate(R.layout.classify_pager, null);
		viewRanking = inflater.inflate(R.layout.ranking_pager, null);
		
		//初始化sift fragment
		initSiftListView();
		//初始化classify fragment
		initClassify();
		//初始化Ranking fragment
		initRankingListView();
		listViews.add(viewSift);
		listViews.add(viewClassify);
		listViews.add(viewRanking);
				
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setCurrentItem(0);
		currentPointerX = 0;
		mViewPager.setOnPageChangeListener(this);
	}
	
	private void initRankingListView(){
		xSiftListView = (XListView) viewRanking.findViewById(R.id.xListViewRanking);
		List<ApplicationItem> list = new ArrayList<ApplicationItem>();
		ApplicationItem item;
		for(int i=0;i<30;i++){
			item = new ApplicationItem();
			list.add(item);
		}
		MyXListViewAdapter adapter = new MyXListViewAdapter(list, LayoutInflater.from(context));
		View header = LayoutInflater.from(context).inflate(R.layout.ranking_header, null);
		xSiftListView.setHeaderFooter(header, null);
		xSiftListView.setAdapter(adapter);
		
		
	}
	
	
	private void initClassify(){
		
		List<RecommendGridItem> lists = generateGridList(6, RecommendConstans.remenfenleiId, RecommendConstans.remenfenleiStr);
		MyRecommendGridViewAdapter adapter = new MyRecommendGridViewAdapter(lists,context,R.layout.gridview_item);
		mGridViewRemenfenlei = (MyGridView) viewClassify.findViewById(R.id.recommend_classify_gridview_remenfenlei);
		mGridViewRemenfenlei.setAdapter(adapter);
		
		lists = generateGridList(10, RecommendConstans.gameId, RecommendConstans.gameStr);
		mGridViewGame = (MyGridView) viewClassify.findViewById(R.id.recommend_classify_gridview_game);
		adapter = new MyRecommendGridViewAdapter(lists, context, R.layout.gridview_item);
		mGridViewGame.setAdapter(adapter);
	
		lists = generateGridList(14, RecommendConstans.softwareId, RecommendConstans.softwareStr);
		mGridViewSoft = (MyGridView) viewClassify.findViewById(R.id.recommend_classify_gridview_soft);
		adapter = new MyRecommendGridViewAdapter(lists, context, R.layout.gridview_item);
		mGridViewSoft.setAdapter(adapter);
	}
	
	
	
	private List<RecommendGridItem> generateGridList(int count,int[] id, String[] str){
		
		List<RecommendGridItem> lists = new ArrayList<RecommendGridItem>();
		RecommendGridItem item;
		for(int i=0;i<count;i++){
			item = new RecommendGridItem();
			item.imageViewId = id[i];
			item.itemText = str[i];
			lists.add(item);
		}
		
		return lists;
	}
	
	
	
	private void initSiftListView(){
		xSiftListView = (XListView) viewSift.findViewById(R.id.xListViewSift);
		List<ApplicationItem> list = new ArrayList<ApplicationItem>();
		ApplicationItem item;
		for(int i=0;i<30;i++){
			item = new ApplicationItem();
			list.add(item);
		}
		MyXListViewAdapter adapter = new MyXListViewAdapter(list, LayoutInflater.from(context));
		View header = LayoutInflater.from(context).inflate(R.layout.sift_header, null);
		xSiftListView.setHeaderFooter(header, null);
		xSiftListView.setAdapter(adapter);
		
		
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
		screenW = dm.widthPixels;
		offset = 0;
		Matrix matrix = imgTabPointer.getImageMatrix();
		matrix.postScale((float)screenW/3/tabPointerW, 1);
		matrix.postTranslate(0, 0);
		imgTabPointer.setImageMatrix(matrix);
		
		Log.v(TAG, "screenW="+screenW);
		currentPager = 0;


	}
	
	
	/**
	 * 初始化三个标签页的字体颜色
	 */
	private void initTabTextColor(){
		tvSift = (TextView) view.findViewById(R.id.tv_sift);
		tvClassify = (TextView) view.findViewById(R.id.tv_classify);
		tvRanking = (TextView) view.findViewById(R.id.tv_ranking);
		
		tvSift.setTextColor(getResources().getColor(android.R.color.black));
		tvClassify.setTextColor(getResources().getColor(android.R.color.black));
		tvRanking.setTextColor(getResources().getColor(android.R.color.black));
		
		tvSift.setOnClickListener(this);
		tvClassify.setOnClickListener(this);
		tvRanking.setOnClickListener(this);
	}


	/**
	 * @param id
	 * 当某一个tab选中后 设定颜色
	 */
	private void setTabTextColor(int id){
		tvSift.setTextColor(getResources().getColor(android.R.color.black));
		tvClassify.setTextColor(getResources().getColor(android.R.color.black));
		tvRanking.setTextColor(getResources().getColor(android.R.color.black));
		switch (id) {
		case 0:
			tvSift.setTextColor(getResources().getColor(R.color.tab_item_click_text_color));
			break;
		case 1:
			tvClassify.setTextColor(getResources().getColor(R.color.tab_item_click_text_color));
			break;
		case 2:
			tvRanking.setTextColor(getResources().getColor(R.color.tab_item_click_text_color));
		default:
			break;
		}
	}
	
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		
		if(isBtnChose){
			return;
		}
//		Log.v(TAG, "onPageScrollStateChanged  arg0--->"+arg0 +"currentPager="+currentPager);
//		Log.v(TAG, "onPageScrollStateChanged selectPageIndex-->"+selectPageIndex);
		
		if(arg0==0){  //抬起
			currentPager = selectPageIndex;
			currentPointerX = currentPager*screenW/3;
			imgTabPointer.setX(currentPointerX);
		}
		
	}


	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
		if(isBtnChose){
			return;
		}
		currentValue = arg2;

		if(arg2 == 0){
			return;
		}
		
		if(currentPointerX == currentPager*screenW/3){
			if(currentValue>screenW/2){//右滑动
				currentPointerX = currentPager*screenW/3-(screenW-arg2)/3;
				imgTabPointer.setX(currentPointerX);
			}else{ //左滑动
				currentPointerX = currentPager*screenW/3+(arg2)/3;
				imgTabPointer.setX(currentPointerX);
			}
		}
		
		if(currentPointerX > currentPager*screenW/3){  //viewpager在中心左侧
			currentPointerX = currentPager*screenW/3+arg2/3;
			imgTabPointer.setX(currentPointerX);
		}
		
		if(currentPointerX < currentPager*screenW/3){  ////viewpager在中心右侧
			currentPointerX = currentPager*screenW/3-(screenW-arg2)/3;
			imgTabPointer.setX(currentPointerX);
		}
		
		
		
		
	}


	@Override
	public void onPageSelected(int arg0) {
//		Log.v(TAG, "onPageSelected--->arg0="+arg0);
		selectPageIndex = arg0;
		setTabTextColor(selectPageIndex);
		if(arg0 == 0){
			sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		}else{
			sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		}
		
	}


	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.tv_sift:
				isBtnChose = true;
				ImagePointerAnimation(currentPager,0);
				mViewPager.setCurrentItem(0);
			break;
			case R.id.tv_classify:
				isBtnChose = true;
				ImagePointerAnimation(currentPager,1);
				mViewPager.setCurrentItem(1);
			break;
			case R.id.tv_ranking:
				isBtnChose = true;
				ImagePointerAnimation(currentPager,2);
				mViewPager.setCurrentItem(2);
			break;
		}
		
	}
	
	
	public void ImagePointerAnimation(int currentId, int clickId){
		Animation animation = null;
		isBtnChose = true;
//		Log.v(TAG, "clickId="+clickId);
		
		
		animation = new TranslateAnimation(0, (clickId-currentPager)*screenW/3, 0, 0);
		if(animation == null){
			return;
		}
		//animation.setFillAfter(true);
		animation.setDuration(300);
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
//				Log.v(TAG, "onAnimationEnd-->selectPageIndex="+selectPageIndex);
				imgTabPointer.setVisibility(View.INVISIBLE);
				currentPager = selectPageIndex;
				currentPointerX = currentPager*screenW/3;
				imgTabPointer.setX(currentPointerX);
				imgTabPointer.setVisibility(View.VISIBLE);
				isBtnChose = false;
			}
		});
		imgTabPointer.startAnimation(animation);
	}
	
	
	
}
