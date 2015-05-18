package com.tomsapps.leaflettest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Date;


public class MainActivity extends ActionBarActivity {

    WebView leaflet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        leaflet = (WebView) findViewById(R.id.leaflet);
        //leaflet.setWebChromeClient(new WebChromeClient());
        leaflet.getSettings().setJavaScriptEnabled(true);

    }


    @Override
    public void onResume () {

        super.onResume();

        leaflet.clearCache(true);
        leaflet.loadUrl("file:///android_asset/leaflet.html");
    }


}
