# My-Webview
We have a ``` index.html ``` file in ```assets/html``` folder and also ```myStyle.css``` file inside ```assets/css``` folder. Hare we will show how to load a html file from assets . not only loading html file we also try to show some other cool stufs like using custom font,caught html button click event in java class, showing image form assets,run javascript,jquery...etc

first of all we need a activity class.. here is the xml code
``` xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <WebView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/webview"
        android:text="Hello World!" />
</RelativeLayout>

```
and hare is java code
``` java
@SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView= (WebView)findViewById(R.id.webview);
        
        webView.loadUrl("file:///android_asset/html/index.html");

        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
    }
```

look at very carefully on this line ```href="file:///android_asset/css/myStyle.css"``` we have added a full path
```index.html``` file look like this
``` html
<html>
    <head><LINK href="file:///android_asset/css/myStyle.css" type="text/css" rel="stylesheet"/></head>
    <body>
        <img class="img" src="file:///android_asset/img/ok.png">
        <p > This above image is  shown from assets folder... </p>
        <p>Custom font <span style="color:red">'trado'</span> from asset folder has been applied on this text</p>
    </body>
</html>
```
now we are going to look at the css file and hare again we used full path to locate font from assets 

```css
@font-face {
    font-family: trado;
    src: url('file:///android_asset/fonts/trado.ttf');
}
@font-face {
    font-family: solaimanlipi;
    src: url('file:///android_asset/fonts/SolaimanLipi.ttf');
}
@font-face {
    font-family: noorehira;
    src: url('file:///android_asset/fonts/noorehira.ttf');
}
body {
    background-color: #d0e4fe;
}

p {
    font-family: 'trado';
    font-size: 20px;
    color: green;
}
img{
    position: relative;
    width:150px;
    height:150px;
    left:100px;
    z-index: -1;
}

```
![ok](https://github.com/Jolpai/My-Webview/blob/master/img/htm_css_2015-12-08-13-05-25.png)

To show the response of html button click in java ... we need a little bit more code in onCreate() method and add a button in index.html file.

```html
<button id="h1" type="button" value="Response Form HTML" onclick="ok.performClick(this.value);">Click Me</button>
```

``` java
webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface           // For API 17+
            public void performClick(String strl)
            {
                //stringVariable = strl;
                Toast.makeText (MainActivity.this, strl, Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Wow someone clicked on the button  !!")
                        .setTitle(strl);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }, "ok");
```

![](https://github.com/Jolpai/My-Webview/blob/master/img/button_click_2015-12-08-14-27-33.png)
