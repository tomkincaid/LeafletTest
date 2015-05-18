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
        leaflet.setWebChromeClient(new WebChromeClient());
        leaflet.getSettings().setJavaScriptEnabled(true);
        leaflet.setWebViewClient(new BrowserClient());
    }


    @Override
    public void onResume () {

        super.onResume();

        leaflet.clearCache(true);
        leaflet.loadUrl("file:///android_asset/leaflet.html");
    }


    private class BrowserClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, final String url) {

            if (url.indexOf("file://") != -1) {
                return false;

            } else if (url.indexOf("ready://") != -1) {
                onMapReady();
                return true;

            } else {

                return true;
            }
        }
    }


    public void onMapReady() {

        String url = "javascript:addTileLayer('file:///android_asset/map/{z}/{x}/{y}.png',8,14)";
        leaflet.loadUrl(url);

        url = "javascript:fitBounds(41.42,41.33,2.22,2.10)";
        leaflet.loadUrl(url);

        url = "javascript:setCenterZoom(41.38,2.17,13)";
        leaflet.loadUrl(url);

        url = "javascript:addMarker(41.38,2.17,'HEY','0')";
        leaflet.loadUrl(url);
    }


}
