package com.lujianfei.taobao_alimama;

import com.lujianfei.taobao_alimama.common.CommonUrl;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TabActivity1 extends Activity {

	WebView m_webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m_webview = new WebView(this);
        setContentView(m_webview);
        WebSettings webSettings = m_webview.getSettings();  
//        m_webview = (WebView) findViewById(R.id.webview);
        webSettings.setDomStorageEnabled(true);
      //设置WebView属性，能够执行Javascript脚本    
        webSettings.setJavaScriptEnabled(true);    
        //设置可以访问文件  
        webSettings.setAllowFileAccess(true);  
         //设置支持缩放  
        webSettings.setBuiltInZoomControls(true);  
        //加载需要显示的网页    
        m_webview.loadUrl(CommonUrl.URL_TAOBAO);    
        //设置Web视图    
        m_webview.setWebViewClient(new webViewClient ()); 
    }
    //Web视图    
    private class webViewClient extends WebViewClient {    
        public boolean shouldOverrideUrlLoading(WebView view, String url) {    
            view.loadUrl(url);    
            return true;    
        }    
    }    
	/* (非 Javadoc) 
	* <p>Title: onResume</p> 
	* <p>Description: </p>  
	* @see android.app.Activity#onResume() 
	*/
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		m_webview = null;
	}
    
}
