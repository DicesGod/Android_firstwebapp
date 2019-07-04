package com.minhle.firstwebview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class WebAppInterface {

    private Context context;
    private WebView webView;

    WebAppInterface(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
    }

    @JavascriptInterface
    public void showToast(String toastMessage) {
        Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show();
    }

    @JavascriptInterface
    public void registerUser(String email, String password) {
        Toast.makeText(context, email + " registered!", Toast.LENGTH_LONG).show();
        webView.loadUrl("http://10.0.2.2:8080/register");
    }
}
