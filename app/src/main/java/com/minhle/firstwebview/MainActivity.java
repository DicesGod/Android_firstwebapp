package com.minhle.firstwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for web views, most of the browser features are off
        // you don't have caching
        // you don't have java script enabled by default
        // you don't have cookies
        WebView mWV = findViewById(R.id.mainVW);
        mWV.loadUrl("http://10.0.2.2:8080/register");

        WebSettings mWebSettings = mWV.getSettings();
        mWebSettings.setJavaScriptEnabled(true);

        WebAppInterface webAppInterface = new WebAppInterface(this, mWV);
        mWV.addJavascriptInterface(webAppInterface, "Android");

        ApiWebViewClient apiWebViewClient = new ApiWebViewClient();
        mWV.setWebViewClient(apiWebViewClient);
    }
}