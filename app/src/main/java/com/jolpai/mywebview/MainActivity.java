package com.jolpai.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView webView;

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

                "</body></html>";
        webView.loadDataWithBaseURL("file:///android_asset/", sHtmlTemplate, "text/html", "utf-8",null);

    }
}
