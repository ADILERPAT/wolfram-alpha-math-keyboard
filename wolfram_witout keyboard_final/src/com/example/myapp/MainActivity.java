package com.example.myapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity implements OnClickListener {
	private WebView mWebview ;
	Button log,inst;
	EditText a;
	String s;
	String p;
	TextView r;
	String url;
	String z;
	Button dow;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=(EditText) this.findViewById(R.id.editText1);
        r=(TextView) this.findViewById(R.id.editText3);
        log=(Button) this.findViewById(R.id.button1);
        log.setOnClickListener(this);
        inst=(Button) this.findViewById(R.id.inst);
        inst.setOnClickListener(this);
        dow=(Button) this.findViewById(R.id.but2);
        dow.setOnClickListener(this);
        
        mWebview  = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

      
    }
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		s=(String) (a.getText().toString());
		z="http://m.wolframalpha.com/input/?i="+s+"";
		String y = "https://docs.google.com/file/d/0B40CDQTzYm5kQ1FveTdCUHlUaFk/edit?usp=sharing";
		switch(id)
		{
		case R.id.button1:	r.setText(String.valueOf(z)); 
							setContentView(mWebview ); 
							mWebview .loadUrl(z);
							break;
		case R.id.but2:	    r.setText(String.valueOf(z)); 
							setContentView(mWebview ); 
							mWebview .loadUrl(y);
							mWebview.setDownloadListener(new DownloadListener() {
							@Override
							public void onDownloadStart(String url, String userAgent,
							String contentDisposition, String mimetype,
							long contentLength) {
								// handle download, here we use brower to download, also you can try other approach.
								Uri uri = Uri.parse(url);
								Intent intent = new Intent(Intent.ACTION_VIEW, uri);
								startActivity(intent);
							}
						});
								
		   
		case R.id.inst:		Toast toast=Toast.makeText(this, "Install math keyboard>open android settings>language and input>under keyboard and input methods enable math keyboard>select default as math keyboard", Toast.LENGTH_LONG);  
        					toast.show();  
		
		
		
		
											
		}
		
									
		}
    
}
	
	
	
	
	

