package br.com.brandroid.manager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by brunosantos on 3/8/16.
 */
public abstract class BaseActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupToolbar(Toolbar mToolbar) {
        if (mToolbar!=null) {
            setSupportActionBar(mToolbar);
        }
    }

    public abstract void startWidgets();
}
