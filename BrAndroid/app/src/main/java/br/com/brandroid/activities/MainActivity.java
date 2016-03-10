package br.com.brandroid.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import br.com.brandroid.R;
import br.com.brandroid.fragments.MapFragment;
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

    private void setupNavigationDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int mClickedId = item.getItemId();

                if(mClickedId!=7) {
                    Fragment mFragment = new MapFragment();
                    changeContentFragment(mFragment, item.getTitle().toString());
                    mToolbar.setTitle(item.getTitle());
                }

                switch (mClickedId) {
                    default:
                        break;
                }

                mDrawerLayout.closeDrawers();
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

        // Define first element
        mNavigationView.getMenu().getItem(0).setChecked(true);
        getSupportActionBar().setTitle(mNavigationView.getMenu().getItem(0).getTitle());
    }

    private void changeContentFragment(Fragment mNextFragment, String mNextTitle) {
        if (mNextFragment!=null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_content, mNextFragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(mNextTitle);
        }
    }
}
