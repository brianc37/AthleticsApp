package com.gapestation.athleticsapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TeamFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle bundle) {
        super.onCreateView(inflater, view, bundle);

        View rootView = inflater.inflate(R.layout.fragment_team_page, view, false);

        TeamsListFragment sport = new TeamsListFragment();
        final TextView helloWorld = (TextView)rootView.findViewById(R.id.schedule);
        TextView title = (TextView)rootView.findViewById(R.id.title);

        title.setText(sport.buttonClicked);

        // START OF LINBURG'S BACKGROUND THREAD CODE
        // This can likely get cleaned up a lot. This just finally got the app working.
        DataDownloadableListener ddl = new DataDownloadableListener() {
            @Override
            public void onDataDownloaded(final ArrayList<String> stringArray) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (String string: stringArray){

                            helloWorld.append(string);
                        }
                    }
                });

            }

        };

        Team team = new Team(sport.buttonClicked);
        team.downloadThread.setup(sport.buttonClicked, ddl);
        team.downloadThread.start();
        //END OF LINBURG'S BACKGROUND THREAD CODE

        return rootView;
    }

    @Override
    public void onStart(){
        super.onStart();

    }
}
