package io.mapping.apps.umcounterpro.umcounterpro;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
	    private static String UM_COUNT = "UM_COUNT";

	    private int mUmCount = 0;

	    private void syncUmCount() {
		    ((TextView) getView().findViewById(R.id.umCount)).setText(String.format("%d", mUmCount));
	    }

	    private void setButtonHandler() {
		    getView().findViewById(R.id.moreButton).setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(final View view) {
				    incrementUms();
			    }
		    });
	    }

	    private void incrementUms() {
		    ((TextView) getView().findViewById(R.id.umCount)).setText(String.format("%d", ++mUmCount));
	    }

        public PlaceholderFragment() {
        }

	    @Override
	    public void onCreate(final Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);

		    mUmCount = (savedInstanceState == null ? 0 : savedInstanceState.getInt(UM_COUNT, 0));
	    }

	    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

	    @Override
	    public void onStart() {
		    super.onStart();

		    setButtonHandler();
		    syncUmCount();
	    }

	    @Override
	    public void onSaveInstanceState(final Bundle outState) {
		    super.onSaveInstanceState(outState);

		    outState.putInt(UM_COUNT, mUmCount);
	    }
    }
}
