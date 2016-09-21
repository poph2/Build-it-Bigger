package com.pop.androidjoker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokerActivityFragment extends Fragment {

    public JokerActivityFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_joker, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.joke_textview);

        String joke = getActivity().getIntent().getStringExtra(JokerActivity.JOKE_EXTRA);
        textView.setText(joke);

        return rootView;
    }

}
