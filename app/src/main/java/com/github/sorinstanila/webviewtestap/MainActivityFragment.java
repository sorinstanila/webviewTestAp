package com.github.sorinstanila.webviewtestap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    EditText editTextSearch;
    WebView webView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflatedView = inflater.inflate(R.layout.fragment_main, container, false);
        editTextSearch = (EditText) inflatedView.findViewById(R.id.editText);
        webView = (WebView) inflatedView.findViewById(R.id.webView);
        webView.setWebViewClient(new MyClientBrowser());
        updateUrlContent(getString(R.string.searchBoxText));
        return inflatedView;
    }

    public void updateUrlContent(String url) {
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url.trim());
    }

    private class MyClientBrowser extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
       /* @Override
        public void onPageFinished(WebView view, String url) {
            view.setVisibility(View.VISIBLE);
            //you might need this
            view.bringToFront();
        }
        @Override
        public void onPageStarted(WebView view, String url,  Bitmap favicon) {
            view.setVisibility(View.GONE);//hide the webview that will display your dialog
        }*/

    }
}
