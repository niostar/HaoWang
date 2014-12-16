package com.xdnice.customclass;

import java.util.List;

import com.xdnice.haowang.R;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyClassifyListAdapter extends BaseAdapter {

	private static final String TAG = "MyClassifyListAdapter";
	List<SoftwareClassifyItem> lists;
	LayoutInflater mInflater;
	
	
	public MyClassifyListAdapter(List<SoftwareClassifyItem> lists,LayoutInflater mInflater) {
		super();
		this.lists = lists;
		this.mInflater = mInflater;
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
		SoftwareClassifyItemHolder holder;
		if(convertView == null){
			holder = new SoftwareClassifyItemHolder();
			holder.tvItems = new TextView[8];
			convertView = mInflater.inflate(R.layout.software_classify_item, null);
			holder.imgHolder = (ImageView) convertView.findViewById(R.id.img_classify_item);
			holder.tvTitleHolder = (TextView) convertView.findViewById(R.id.tv_classify_item_title);
			holder.tvMore = (TextView) convertView.findViewById(R.id.tv_classify_item_more);
			holder.tvItems[0] = (TextView) convertView.findViewById(R.id.tv_software_classify_itme1);
			holder.tvItems[1] = (TextView) convertView.findViewById(R.id.tv_software_classify_itme2);
			holder.tvItems[2] = (TextView) convertView.findViewById(R.id.tv_software_classify_itme3);
			holder.tvItems[3] = (TextView) convertView.findViewById(R.id.tv_software_classify_itme4);
			holder.tvItems[4] = (TextView) convertView.findViewById(R.id.tv_software_classify_itme5);
			holder.tvItems[5] = (TextView) convertView.findViewById(R.id.tv_software_classify_itme6);
			holder.tvItems[6] = (TextView) convertView.findViewById(R.id.tv_software_classify_itme7);
			holder.tvItems[7] = (TextView) convertView.findViewById(R.id.tv_software_classify_itme8);
			convertView.setTag(holder);
		}else{
			holder = (SoftwareClassifyItemHolder) convertView.getTag();
		}
		holder.imgHolder.setBackgroundResource(lists.get(position).imgId);
		holder.tvTitleHolder.setText(lists.get(position).title);
		
		for(int i=0;i<lists.get(position).items.length;i++){
		
			holder.tvItems[i].setText(lists.get(position).items[i]);
		}
		
		// TODO Auto-generated method stub
		return convertView;
	}
	
	private class SoftwareClassifyItemHolder{
		ImageView imgHolder;
		TextView tvTitleHolder;
		TextView tvMore;
		TextView tvItems[];
	}

}
