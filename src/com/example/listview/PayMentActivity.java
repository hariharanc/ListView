package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class PayMentActivity extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment_layout);
		TextView mTxtItemName=(TextView)findViewById(R.id.txt_sel_item_name);
		TextView mTxtItemPrice=(TextView)findViewById(R.id.item_price);
		Intent i =getIntent();
		String name=i.getExtras().getString("itemName");
		String price=i.getExtras().getString("itemPrice");
		mTxtItemName.setText(name);
		mTxtItemPrice.setText(price);
	}
}
