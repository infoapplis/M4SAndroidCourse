package androidcourse.dev.stateslistproject;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private LocationManager mLocationManager;

    public static String getBestProvider(LocationManager locationManager){
        Criteria criteria = new Criteria();
        criteria.setAccuracy(criteria.ACCURACY_COARSE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setCostAllowed(true);
        return locationManager.getBestProvider(criteria,true);
    }

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        String[] fruits = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
        List<String> fruitAL = new ArrayList<String>(Arrays.asList(fruits));

        ArrayAdapter<String> fruitAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.listviewitem,
                R.id.textviewitem,
                fruitAL);

        ListView lv = (ListView) rootView.findViewById(R.id.listviewstates);
        lv.setAdapter(fruitAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Log.i("hello", "Cick to Lousiana");
                } else if (position == 1) {
                    Log.i("hello", "Cick to Lousiana");
                } else if (position == 16) {
                    Intent intent = new Intent(getActivity(), google_maps_api.class);
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }

}
