package com.example.eliseo.usandodisplaywebpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    WebView visor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visor = (WebView) findViewById(R.id.WebView01);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.tgbtn);
        toggle.setOnCheckedChangeListener(new Oidor());


        visor.setWebViewClient(new Callback());

        WebSettings preferencias = visor.getSettings();
        preferencias.setBuiltInZoomControls(true);

        visor.loadUrl("https://www.wikipedia.org/");

    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView wv, String url) {
            return false;
        }
    }

    private class Oidor implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean estaChequeado) {
            if (estaChequeado)
                visor.loadUrl("https://www.wikipedia.org/");
            else
                visor.loadUrl("about:blank");
        }
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
}
