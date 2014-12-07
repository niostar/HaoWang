package com.xdnice.customclass;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xdnice.haowang.R;

public class MyRecommendGridViewAdapter extends BaseAdapter {

	List<RecommendGridItem> lists;
	LayoutInflater inflater;
	int layoutId;
	
	public MyRecommendGridViewAdapter(List<RecommendGridItem> lists,Context context,int layoutId) {
		super();
		this.lists = lists;
		this.layoutId = layoutId;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		GridViewItemHolder holder;
		if(convertView == null){
			convertView = inflater.inflate(this.layoutId, null);
			holder = new GridViewItemHolder();
			holder.imgHolder = (ImageView) convertView.findViewById(R.id.imgGridViewItem);
			holder.tvHolder = (TextView) convertView.findViewById(R.id.tvGridViewItem);
			convertView.setTag(holder);
		}else{
			holder = (GridViewItemHolder) convertView.getTag();
		}
		holder.imgHolder.setImageResource(lists.get(position).imageViewId);
		holder.tvHolder.setText(lists.get(position).itemText);
		return convertView;
	}
	
	private class GridViewItemHolder{
		public ImageView imgHolder;
		public TextView tvHolder;
	}

}
