package com.example.meditrackr.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meditrackr.R;


/**
 * Created by Skryt on Nov 4, 2018
 */

public class UserFragment extends Fragment {
    public static UserFragment newInstance(){
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_user, container, false);

        final Bundle bundle = getArguments();

        // set ui definitions
        ImageView user_image = rootView.findViewById(R.id.patient_image);
        TextView username = rootView.findViewById(R.id.patient_username);
        TextView email = rootView.findViewById(R.id.patient_phone);
        TextView phone = rootView.findViewById(R.id.patient_phone);

        username.setText("Orest Cokan");
        email.setText("cokan@ualberta.ca");
        phone.setText("7806666666");


        return rootView;
    }

}