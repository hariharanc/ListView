package com.example.listview;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListItemAdapter extends BaseAdapter {
	Context context;
	List<ListItem> itemsList;
	CallBack callBack;

	public ListItemAdapter(Context context, List<ListItem> items,
			CallBack callBack) {
		this.context = context;
		itemsList = items;
		this.callBack = callBack;
		callBack.sendData("Listview");
	}

	@Override
	public int getCount() {
		return itemsList.size();
	}

	@Override
	public Object getItem(int position) {
		return itemsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return itemsList.indexOf(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder = new ViewHolder();
			holder.mTxtItemName = (TextView) convertView
					.findViewById(R.id.txt_name);
			holder.mTxtItemPrice = (TextView) convertView
					.findViewById(R.id.txt_price);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		ListItem listItems = (ListItem) getItem(position);
		holder.mTxtItemName.setText(listItems.getItemName());
		holder.mTxtItemPrice.setText(listItems.getItemPrice());

		return convertView;
	}

	/* private view holder class */
	private class ViewHolder {
		TextView mTxtItemName, mTxtItemPrice;

	}

}
