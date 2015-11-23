package com.example.gifimage;

import java.io.IOException;

import android.content.Context;
import android.graphics.Color;
import android.webkit.WebView;

public class GIFView extends WebView {

	public static final String HTML_FORMAT = "<html><body style=\"text-align: center;  vertical-align:                       right;background-color: transparent;\"><img src = \"%s\" /></body></html>";

	public GIFView(Context context, String fileUrl) throws IOException {
		super(context);

		final String html = String.format(HTML_FORMAT, fileUrl);

		setBackgroundColor(Color.TRANSPARENT);
		loadDataWithBaseURL("", html, "text/html", "UTF-8", "");

	}

}