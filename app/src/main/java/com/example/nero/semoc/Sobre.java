package com.example.nero.semoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        WebView webView = (WebView) findViewById(R.id.webview);

        webView.loadData(getString(R.string.html),"text/html","UFT-8");
    }
}
