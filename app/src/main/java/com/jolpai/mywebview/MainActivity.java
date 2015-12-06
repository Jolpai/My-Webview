package com.jolpai.mywebview;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    WebView webView;
    Button valid;
    Button refuse;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView= (WebView)findViewById(R.id.webview);


        String sHtmlTemplate = "<html><head>" +
                "<LINK href=\"css/myStyle.css\" type=\"text/css\" rel=\"stylesheet\"/></head>" +

                "<body><img src=\"file:///android_asset/img/ok.png\">" +
                     "<h1>My First CSS Example</h1>\n" +
                     "<p>This is a paragraph.</p>" +
                     "<p>B Homa: مخصص</p>" +
                "<button type=\"button\" value=\"someValue\" onclick=\"ok.performClick(this.value);\">OK</button>" +

                "</body></html>";
        webView.loadDataWithBaseURL("file:///android_asset/", sHtmlTemplate, "text/html", "utf-8",null);
       // webView.loadUrl("file:///android_asset/html/index.html");



        valid = new Button(MainActivity.this);
        valid.setOnClickListener(this);
        refuse = new Button(MainActivity.this);
        refuse.setOnClickListener(this);


        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        // Add the interface to record javascript events

        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface           // For API 17+
            public void performClick(String strl)
            {
                //stringVariable = strl;
                Toast.makeText (MainActivity.this, strl, Toast.LENGTH_SHORT).show();
            }
        }, "ok");

        webView.addJavascriptInterface(valid, "valid");
        webView.addJavascriptInterface(refuse, "refuse");
    }

    @Override
    public void onClick(View v) {
        if (v.equals(valid)) {
            Toast.makeText(MainActivity.this,"Valid "+v.getId(),Toast.LENGTH_SHORT).show();
        } else if (v.equals(refuse)) {
            Toast.makeText(MainActivity.this,"Refuse "+v.getId(),Toast.LENGTH_SHORT).show();
        }
    }
}
