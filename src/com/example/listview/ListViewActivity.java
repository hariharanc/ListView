package com.example.listview;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends AppCompatActivity implements
		OnItemClickListener, CallBack {
	ListView mlistview;
	public static final String[] itemName = new String[] { "Idly", "Dosa",
			"Poori", "Pongal" };
	public static final String[] itemPrice = new String[] { "2", "4", "5", "5" };
	List<ListItem> listItems;
	ListItemAdapter listItemAdapter;
	TextView txtTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("List View");
		listItems = new ArrayList<ListItem>();
		for (int i = 0; i < itemName.length; i++) {
			ListItem items = new ListItem(itemName[i], itemPrice[i]);
			listItems.add(items);

		}

		initViews();

	}

	private void initViews() {
		mlistview = (ListView) findViewById(R.id.lstview_item);
		txtTitle = (TextView) findViewById(R.id.txt_title);
		mlistview.setOnItemClickListener(this);
		listItemAdapter = new ListItemAdapter(this, listItems, this);
		mlistview.setAdapter(listItemAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		ListItem itemList = listItems.get(position);
		// Toast.makeText(this,"item name is"+itemList.getItemName(),Toast.LENGTH_SHORT).show();
		Intent i = new Intent(this, PayMentActivity.class);
		i.putExtra("itemName", itemList.getItemName());
		i.putExtra("itemPrice", itemList.getItemPrice());
		startActivity(i);
	}

	@Override
	public void sendData(String data) {
		txtTitle.setText(data);

	}
}
