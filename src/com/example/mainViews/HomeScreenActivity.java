package com.example.mainViews;

import com.example.cardviewpager.PageViewActivity;
import com.example.carviewCyclerView.RecyclerCardViewActivity;
import com.example.gifimage.GifImageViewActivity;
import com.example.listview.ListViewActivity;
import com.example.listview.R;
import com.example.recyclerview.RecyclerViewActivity;
import com.example.viewpager.ViewPagerActivity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeScreenActivity extends AppCompatActivity implements
		OnClickListener {

	Button btnListview, btnRecyclerView, btnCardView, btnCardViewRecycler,
			btnViewPagers, btnGif;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_screen);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("Home Screen");
		initViews();
	}

	private void initViews() {
		btnListview = (Button) findViewById(R.id.btn_listview);
		btnRecyclerView = (Button) findViewById(R.id.btn_recycler_view);
		btnCardView = (Button) findViewById(R.id.btn_card_view);
		btnCardViewRecycler = (Button) findViewById(R.id.btn_card_view_recycler);
		btnViewPagers = (Button) findViewById(R.id.btn_view_pager);
		btnGif = (Button) findViewById(R.id.btn_gif);
		btnGif.setOnClickListener(this);
		btnViewPagers.setOnClickListener(this);
		btnListview.setOnClickListener(this);
		btnRecyclerView.setOnClickListener(this);
		btnCardView.setOnClickListener(this);
		btnCardViewRecycler.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent i;
		switch (v.getId()) {

		case R.id.btn_listview:
			i = new Intent(HomeScreenActivity.this, ListViewActivity.class);
			startActivity(i);
			break;

		case R.id.btn_recycler_view:
			i = new Intent(HomeScreenActivity.this, RecyclerViewActivity.class);
			startActivity(i);
			break;

		case R.id.btn_card_view:
			i = new Intent(HomeScreenActivity.this, PageViewActivity.class);
			startActivity(i);
			break;

		case R.id.btn_card_view_recycler:
			i = new Intent(HomeScreenActivity.this,
					RecyclerCardViewActivity.class);
			startActivity(i);
			break;

		case R.id.btn_view_pager:
			i = new Intent(HomeScreenActivity.this, ViewPagerActivity.class);
			startActivity(i);
			break;

		case R.id.btn_gif:
			i = new Intent(HomeScreenActivity.this, GifImageViewActivity.class);
			startActivity(i);
			break;

		default:
			break;
		}

	}

}
