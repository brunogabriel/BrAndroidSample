package br.com.brandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ScaleBarOverlay;

import br.com.brandroid.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by brunosantos on 3/9/16.
 */
public class MapFragment extends Fragment {

    @Bind(R.id.map) protected MapView mMap;
    protected View mRootView;

    protected MapController mMapController;

    public MapFragment() {
        // Empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_map, null, false);
        ButterKnife.bind(this, mRootView);
        IMapController mapController = mMap.getController();
        mapController.setZoom(4);
        GeoPoint startPoint = new GeoPoint(48.8583, 2.2944);
        mapController.setCenter(startPoint);

        return mRootView;
    }

    public void changeMapStyle(OnlineTileSourceBase base) {

        if(base!=null) {
            mMap.setTileSource(base);
        }
    }

}
