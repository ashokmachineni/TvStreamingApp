package livetvs.android.com.practiceappone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //webview
        mWebView = (WebView)findViewById(R.id.myWebView);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("http://217.199.187.195/livetvs.com/");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public static boolean isXMTVPlayerAvailable(Context context) {
        PackageManager pm = context.getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo("com.xmtvplayer.watch.live.streams",
                    PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    public static int isXMTVPlayerGetVersion(Context context) {
        PackageManager pm = context.getPackageManager();
        int app_installed = -1;
        try {
            app_installed = (pm.getPackageInfo(
                    "com.xmtvplayer.watch.live.streams",
                    PackageManager.GET_ACTIVITIES)).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = -1;
        }
        return app_installed;
    }

    public static void OpenGooglePlayStore(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
                | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        intent.setData(Uri
                .parse("market://details?id=com.xmtvplayer.watch.live.streams"));
        context.startActivity(intent);
    }

    public static void OpenSlideMe(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
                | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        intent.setData(Uri.parse("sam://details?id="
                + "com.xmtvplayer.watch.live.streams"));
        context.startActivity(intent);
    }

    // LinkUrl1 = "sam://details?id=" + "com.xmtvplayer.watch.live.streams";

    private void AmazonApps() {
        Intent intent = new Intent();
        String string_of_uri = "amzn://apps/android?p="
                + "com.xmtvplayer.watch.live.streams";
        intent.setData(Uri.parse(string_of_uri)); // The string_of_uri is an
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_INCLUDE_STOPPED_PACKAGES
                    | Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        } else {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        }
        // The Intent.FLAG_INCLUDE_STOPPED_PACKAGES flag must be added only
        try {
            startActivity(intent);
        } catch (Exception e) {
            //
            intent = new Intent();
            string_of_uri = "http://www.amazon.com/gp/mas/dl/android?p=com.xmtvplayer.watch.live.streams";
            intent.setData(Uri.parse(string_of_uri)); // The string_of_uri is an
            if (android.os.Build.VERSION.SDK_INT >= 11) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_INCLUDE_STOPPED_PACKAGES
                        | Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            } else {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            }
            try {
                startActivity(intent);
            } catch (Exception e1) {
            }

        }

    }

    }
