package com.example.carviewCyclerView;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview.ListItem;
import com.example.listview.R;

public class CountryCardViewAdapter extends
		RecyclerView.Adapter<CountryCardViewAdapter.ViewHolder> {

	List<ListItem> itemsList;
	private int rowLayout;
	private Context mContext;

	public CountryCardViewAdapter(List<ListItem> itemsList, int rowLayout,
			Context context) {
		this.itemsList = itemsList;
		this.rowLayout = rowLayout;
		this.mContext = context;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout,
				viewGroup, false);

		return new ViewHolder(v);
	}

	@SuppressLint("NewApi")
	@Override
	public void onBindViewHolder(ViewHolder viewHolder, final int i) {
		// ListItem listItems = (ListItem)
		viewHolder.mTxtName.setText(itemsList.get(i).getItemName());
		viewHolder.mTxtItemPrice.setText(itemsList.get(i).getItemPrice());
		// viewHolder.countryImage.setImageDrawable(mContext.getDrawable(country.getImageResourceId(mContext)));

		viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				Toast.makeText(
						mContext,
						"Recycle Click" + i + "\n"
								+"Item name is"+ itemsList.get(i).getItemName(),
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public int getItemCount() {
		return itemsList == null ? 0 : itemsList.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public TextView mTxtName, mTxtItemPrice;

		public ViewHolder(View itemView) {
			super(itemView);

			mTxtName = (TextView) itemView.findViewById(R.id.txt_name);
			mTxtItemPrice = (TextView) itemView.findViewById(R.id.txt_price);
		}

	}
}