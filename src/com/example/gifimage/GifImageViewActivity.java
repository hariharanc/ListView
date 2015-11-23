package com.example.gifimage;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.example.listview.R;

public class GifImageViewActivity extends Activity {
	private WebView webView;
	private LinearLayout mllProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.gif_image_view);
		initViews();
	}

	private void initViews() {
		mllProgress=(LinearLayout)findViewById(R.id.ll_progress);
		try {
			// give your gif image name here(example.gif).
			GIFView gif = new GIFView(this, "file:///android_asset/example.gif");
			mllProgress.addView(gif);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
