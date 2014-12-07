package com.xdnice.customclass;

import java.util.List;

import com.xdnice.haowang.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyXListViewAdapter extends BaseAdapter {

	List<ApplicationItem> lists;
	LayoutInflater mInflater;
	
	
	
	public MyXListViewAdapter(List<ApplicationItem> lists,LayoutInflater inflater) {
		super();
		this.lists = lists;
		this.mInflater = inflater;
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
		ApplicationItemHolder holder = null;
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.applicationitem, null);
			holder = new ApplicationItemHolder();
			holder.imgIcon = (ImageView) convertView.findViewById(R.id.img_item_icon);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_item_title);
			convertView.setTag(holder);
		}else{
			holder = (ApplicationItemHolder) convertView.getTag();
		}
		holder.imgIcon.setBackgroundResource(R.drawable.ic_launcher);
		holder.tvTitle.setText("≤‚ ‘");
		return convertView;
	}
	
	
	private class ApplicationItemHolder{
		ImageView imgIcon;
		TextView tvTitle;
	}

}
