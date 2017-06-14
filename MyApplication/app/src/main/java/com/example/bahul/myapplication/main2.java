package com.example.bahul.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

/**
 * Created by bahul on 6/6/17.
 */

public class main2 extends Activity {

        private WebView mWebView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("http://www.placio.in");
        mWebView.setWebViewClient(new MyAppWebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
//hide loading image

//show webview
                findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);
            }});
    }

        boolean db=false;

        @Override
        public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
        if (db) {
            super.onBackPressed();
            return;
        }


        this.db = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                db= false;
            }
        }, 2000);

    }
        private ShareActionProvider mShareActionProvider;
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
/** Inflating the current activity's menu with res/menu/items.xml */
getMenuInflater().inflate(R.menu.menu_main, menu);
/** Getting the actionprovider associated with the menu item whose id is share */
        mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.share).getActionProvider();
/** Setting a share intent */
        mShareActionProvider.setShareIntent(getDefaultShareIntent());
        return super.onCreateOptionsMenu(menu);
        }
/** Returns a share intent */
private Intent getDefaultShareIntent(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Student Housing");
        intent.putExtra(Intent.EXTRA_TEXT," Vist https://www.placio.in  ");
        return intent;
        }
        }

