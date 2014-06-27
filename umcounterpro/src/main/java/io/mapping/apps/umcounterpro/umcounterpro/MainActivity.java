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
	    private int mUmCount = 0;

	    private void initUi() {
		    getView().findViewById(R.id.moreButton).setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(final View view) {
				    incrementUms();
			    }
		    });
	    }

	    private void zeroUms() {
		    mUmCount = 0;
	    }

	    private void incrementUms() {
		    ((TextView) getView().findViewById(R.id.umCount)).setText(String.format("%d", ++mUmCount));
	    }

        public PlaceholderFragment() {
        }

	    @Override
	    public void onStart() {
		    super.onStart();

		    initUi();
		    zeroUms();
	    }

	    @Override
	    public void onAttach(final Activity activity) {
		    super.onAttach(activity);


	    }

	    @Override
	    public void onDetach() {
		    super.onDetach();

		    zeroUms();
	    }

	    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
