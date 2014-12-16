package com.xdnice.customview;

import com.xdnice.haowang.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TopList extends LinearLayout {

	private TextView tvTitle;
	private TextView tvMore;
	
	
	
	public TopList(Context context, AttributeSet attrs) {
		super(context, attrs);
		View view;
		// TODO Auto-generated constructor stub
		view = LayoutInflater.from(context).inflate(R.layout.toplist, this);
		tvTitle = (TextView) view.findViewById(R.id.tvTopListTitle);
		tvMore = (TextView) view.findViewById(R.id.tvTopListMore);
	}
	
	

}
