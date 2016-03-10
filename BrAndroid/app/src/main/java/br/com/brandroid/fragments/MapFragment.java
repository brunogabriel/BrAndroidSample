package br.com.brandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.brandroid.R;

/**
 * Created by brunosantos on 3/9/16.
 */
public class MapFragment extends Fragment {

    protected View mRootView;

    public MapFragment() {
        // Empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_map, null, false);
        return mRootView;
    }

}
