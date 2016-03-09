package br.com.brandroid.activities;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import br.com.brandroid.R;
import br.com.brandroid.manager.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity {

    // Assets Elements Path
    private static final String PROFILE_PATH = "file:///android_asset/images_resources/asset_einstein_profile.jpg";
    private static final String BACKGROUND_PATH = "file:///android_asset/images_resources/blur_effect.png";

    // Binded
    @Bind(R.id.toolbar) protected Toolbar mToolbar;
    @Bind(R.id.navigation_view) protected NavigationView mNavigationView;
    @Bind(R.id.drawer) protected DrawerLayout mDrawerLayout;

    // Elements
    protected ActionBarDrawerToggle mActionBarDrawerToggle;
    protected View mHeaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        startWidgets();
    }

    public void startWidgets() {
        setSupportActionBar(mToolbar);
        setupNavigationDrawer();
        setupHeaderView();
    }

    public void setupHeaderView() {
        if(mHeaderView!=null) {
            CircleImageView mCircleImageView = (CircleImageView) mHeaderView.findViewById(R.id.profile_image);
            ImageView mHeaderBackgroundImage = (ImageView) mHeaderView.findViewById(R.id.background_image);
            Picasso.with(this).load(PROFILE_PATH).into(mCircleImageView);
            Picasso.with(this).load(BACKGROUND_PATH).into(mHeaderBackgroundImage);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void applyBackgroundOnView(View mView, Bitmap mBitmap) {
        if(mView!=null && mBitmap!=null) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                mView.setBackground(new BitmapDrawable(getResources(), mBitmap));
            } else {
                mView.setBackgroundDrawable(new BitmapDrawable(getResources(), mBitmap));
            }
        }
    }

    private void setupNavigationDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int mClickedId = item.getItemId();

                switch (mClickedId) {
                    default:
                        break;
                }
                return true;
            }
        });

        // Obtain headerview
        this.mHeaderView = mNavigationView.getHeaderView(0);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };

        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
    }
}
