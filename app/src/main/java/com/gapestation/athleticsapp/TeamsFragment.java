package com.gapestation.athleticsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TeamsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle bundle) {
        super.onCreateView(inflater, view, bundle);

        View rootView = inflater.inflate(R.layout.fragment_teams, view, false);

        return rootView;
    }
}
