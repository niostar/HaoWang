//package com.xdnice.fragment;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
//import com.xdnice.customclass.ApplicationItem;
//import com.xdnice.customclass.MyViewPagerAdapter;
//import com.xdnice.customclass.MyXListViewAdapter;
//import com.xdnice.haowang.R;
//import com.xdnice.xlistview.XListView;
//
//import android.content.Context;
//import android.graphics.BitmapFactory;
//import android.graphics.Matrix;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.view.ViewPager;
//import android.support.v4.view.ViewPager.OnPageChangeListener;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class ClassifyFragmentback extends Fragment implements OnClickListener,OnPageChangeListener{
//
//	private static final String TAG = "ClassifyFragment";
//	
//	SlidingMenu sm;
//	private Context context;
//	private View view;
//	private TextView tvSift;  //精选
//	private TextView tvClassify; //分类
//	private TextView tvRanking;  //排行
//	private boolean isBtnChose = false;
//	private ImageView imgTabPointer;	//游标
//	private int tabPointerW;
//	private float screenW;
//	private int offset;
//	private int currentPager=0;
//	private ViewPager mViewPager;
//	private List<View> listViews;
//	private MyViewPagerAdapter mPagerAdapter;
//	private View viewSift;	//精选viewpager
//	private View viewClassify;	//分类Viewpager
//	private View viewRanking;	//排行
//	private float currentPointerX=0.0f;
//	private XListView xSiftListView;	//xListview
//	
//	public ClassifyFragmentback(SlidingMenu sm) {
//		// TODO Auto-generated constructor stub
//		this.sm = sm;
//	}
//	
//	
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		
//		view = inflater.inflate(R.layout.software_classify_fragment, null);
//		context = getActivity().getApplicationContext();
//		initTabTextColor();
//		initImagePointer();
//		initViewPager();
//		return view;
//	}
//	
//	
//
//	/**
//	 * 初始化viewpager
//	 */
//	private void initViewPager(){
//		mViewPager = (ViewPager) view.findViewById(R.id.tab_software_pager);
//		listViews = new ArrayList<View>();
//		mPagerAdapter = new MyViewPagerAdapter(listViews);
//		LayoutInflater inflater = LayoutInflater.from(context);
//		viewSift = inflater.inflate(R.layout.software_sift_pager, null);
//		viewClassify = inflater.inflate(R.layout.software_classify_pager, null);
//		viewRanking = inflater.inflate(R.layout.software_ranking_pager, null);
//		
//		//初始化sift fragment
//		initSiftListView();
//		//初始化classify fragment
//		//initClassify();
//		//初始化Ranking fragment
//		//initRankingListView();
//		listViews.add(viewSift);
//		listViews.add(viewClassify);
//		listViews.add(viewRanking);
//				
//		mViewPager.setAdapter(mPagerAdapter);
//		mViewPager.setCurrentItem(0);
//		currentPointerX = 0;
//		mViewPager.setOnPageChangeListener(this);
//	}
//	
//	
//	
//	
//	private void initSiftListView(){
//		xSiftListView = (XListView) viewSift.findViewById(R.id.xListViewSift);
//		List<ApplicationItem> list = new ArrayList<ApplicationItem>();
//		ApplicationItem item;
//		for(int i=0;i<30;i++){
//			item = new ApplicationItem();
//			list.add(item);
//		}
//		MyXListViewAdapter adapter = new MyXListViewAdapter(list, LayoutInflater.from(context));
//		
//		xSiftListView.setHeaderFooter(null, null);
//		xSiftListView.setAdapter(adapter);
//		
//		
//	}
//	
//	
//	/**
//	 * 初始化pointer的大小和位置
//	 */
//	private void initImagePointer(){
//		
//		imgTabPointer = (ImageView) view.findViewById(R.id.img_software_tab_pointer);
//		tabPointerW = BitmapFactory.decodeResource(getResources(), R.drawable.title_bar_bg)
//				.getWidth();
//		DisplayMetrics dm = new DisplayMetrics();
//		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
//		screenW = dm.widthPixels;
//		offset = 0;
//		Matrix matrix = imgTabPointer.getImageMatrix();
//		matrix.postScale((float)screenW/3/tabPointerW, 1);
//		matrix.postTranslate(0, 0);
//		imgTabPointer.setImageMatrix(matrix);
//		
//		Log.v(TAG, "screenW="+screenW);
//		currentPager = 0;
//
//
//	}
//	
//	
//	
//	/**
//	 * 初始化三个标签页的字体颜色
//	 */
//	private void initTabTextColor(){
//		tvSift = (TextView) view.findViewById(R.id.tv_software_sift);
//		tvClassify = (TextView) view.findViewById(R.id.tv_software_classify);
//		tvRanking = (TextView) view.findViewById(R.id.tv_software_ranking);
//		
//		tvSift.setTextColor(getResources().getColor(android.R.color.black));
//		tvClassify.setTextColor(getResources().getColor(android.R.color.black));
//		tvRanking.setTextColor(getResources().getColor(android.R.color.black));
//		
//		tvSift.setOnClickListener(this);
//		tvClassify.setOnClickListener(this);
//		tvRanking.setOnClickListener(this);
//	}
//
//
//	@Override
//	public void onClick(View v) {
//		switch(v.getId()){
//		case R.id.tv_software_sift:
//			isBtnChose = true;
//			//ImagePointerAnimation(currentPager,0);
//			//mViewPager.setCurrentItem(0);
//		break;
//		case R.id.tv_software_classify:
//			isBtnChose = true;
//		//	ImagePointerAnimation(currentPager,1);
//		//	mViewPager.setCurrentItem(1);
//		break;
//		case R.id.tv_software_ranking:
//			isBtnChose = true;
//		//	ImagePointerAnimation(currentPager,2);
//		//	mViewPager.setCurrentItem(2);
//		break;
//	}
//	}
//
//
//	@Override
//	public void onPageScrollStateChanged(int arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public void onPageScrolled(int arg0, float arg1, int arg2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public void onPageSelected(int arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
