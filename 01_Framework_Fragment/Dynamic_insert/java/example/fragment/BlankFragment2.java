package example.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlankFragment2 extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("App-Log", "Fragment Attach.");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("App-Log", "Fragment Create.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("App-Log", "Fragment Create View.");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("App-Log", "Fragment on Activity Created.");

        // Modify text view content, show id number
        // Find target view object in activity who have fragment.
        // this.getActivity().findViewById(R.id.Fragment_TextView);
        // Find target view object in current fragment view.
        // this.getView().findViewById(R.id.Fragment_TextView);
        TextView tv = (TextView) this.getView().findViewById(R.id.Fragment_TextView);
        tv.setText("Hello ! It is Fragment 2 ! \n " + this.getId());


    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("App-Log", "The fragment is about to become visible.");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("App-Log", "The fragment has become visible (it is now \"resumed\").");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("App-Log", "Another fragment is taking focus (this activity is about to be \"paused\").");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("App-Log", "The fragment is no longer visible (it is now \"stopped\").");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("App-Log", "Fragment Destroy view.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("App-Log", "The fragment is about to be destroyed.");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("App-Log", "Fragment Detach.");
    }
}
