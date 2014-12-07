 package com.xdnice.xlistview;

import com.xdnice.haowang.R;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class XListView extends ListView implements OnScrollListener{
	private static final String TAG = "MyListView";
	View viewHeader = null;
	View viewFooter = null;
	
	
	
	public XListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initContent(context);
	}

	public XListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initContent(context);
	}

	public XListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initContent(context);
	}

	
	private void initContent(Context context){
		this.setOnScrollListener(this);
	}
	
	
	public void setHeaderFooter(View viewHeader, View viewFooter){
		if(this.viewHeader != null){
			removeHeaderView(viewHeader);
		}
		if(this.viewFooter != null){
			removeFooterView(viewFooter);
		}
		this.viewHeader = viewHeader;
		this.viewFooter = viewFooter;
		if(this.viewHeader != null){
			addHeaderView(viewHeader);
		}
		if(this.viewFooter != null){
			addFooterView(viewFooter);
		}
		
	}
	
	
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
//		Log.v(TAG, "onScrollStateChanged");
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
//		// TODO Auto-generated method stub
//		Log.v(TAG, "onScroll-->firstVisibleItem="+firstVisibleItem+"visibleItemCount="
//				+visibleItemCount+"totalItemCount="+totalItemCount+"last="+getLastVisiblePosition());
//		
	}
	
}
