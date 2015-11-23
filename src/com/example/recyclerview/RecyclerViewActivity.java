package com.example.recyclerview;

import java.util.ArrayList;
import java.util.List;

import com.example.listview.ListItem;
import com.example.listview.R;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class RecyclerViewActivity extends AppCompatActivity {
	private RecyclerView mRecyclerView;
	private CountryAdapter mAdapter;
	public static final String[] itemName = new String[] { "Idly", "Dosa",
			"Poori", "Pongal" };
	public static final String[] itemPrice = new String[] { "2", "4", "5", "5" };
	List<ListItem> listItems;
	private static final int VERTICAL_ITEM_SPACE = 30;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_country);
		listItems = new ArrayList<ListItem>();
		for (int i = 0; i < itemName.length; i++) {
			ListItem items = new ListItem(itemName[i], itemPrice[i]);
			listItems.add(items);
		}
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("Recycler View");
		mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		
		LinearLayoutManager layoutManager = new LinearLayoutManager(this,
				LinearLayoutManager.VERTICAL, false);
		mRecyclerView.setLayoutManager(layoutManager);
	//	mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));
		    //or
		mRecyclerView.addItemDecoration(
		            new SimpleDividerItemDecoration(getApplicationContext()));
		    //or
		            mRecyclerView.addItemDecoration(
		            new SimpleDividerItemDecoration(this, R.drawable.line_divider));

		
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mAdapter = new CountryAdapter(listItems, R.layout.list_item, this);
		mRecyclerView.setAdapter(mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.country, menu);
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
}
