package com.github.sorinstanila.webviewtestap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MainActivityFragment placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        placeholder = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
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

    public void onClickHandlerGoToUrl(View inflatedView) {
        Button buttonSearch = (Button) inflatedView.findViewById(R.id.searchButton);
        EditText editTextSearch = (EditText) placeholder.editTextSearch;

        //progressBar.setVisibility(View.VISIBLE);
        String searchUrl = null;
        if (editTextSearch != null && !editTextSearch.getText().toString().isEmpty()) {
            searchUrl = editTextSearch.getText().toString();
        } else {
            searchUrl = getString(R.string.searchBoxText);
            editTextSearch.setHint(R.string.searchBoxText);
        }

        if (searchUrl != null && !searchUrl.isEmpty()) {
            placeholder.updateUrlContent(searchUrl);
        }
    }


}
