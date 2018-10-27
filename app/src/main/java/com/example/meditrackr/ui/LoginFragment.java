package com.example.meditrackr.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meditrackr.Doctor;
import com.example.meditrackr.Patient;
import com.example.meditrackr.Profile;
import com.example.meditrackr.R;
import com.example.meditrackr.Record;
import com.example.meditrackr.SaveLoadController;

public class LoginFragment extends Fragment {
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_login, container, false);


        // set ui definitions
        final EditText username = (EditText) rootView.findViewById(R.id.username);
        final Button login = (Button) rootView.findViewById(R.id.login_button);
        final TextView signup = (TextView) rootView.findViewById(R.id.not_member);

        // onclick listener for login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Doctor doctor = SaveLoadController.loadDoctor(getContext(), username.getText().toString());
                if(doctor == null){
                    Patient patient = SaveLoadController.loadPatient(getContext(), username.getText().toString());
                    if(patient == null){
                        Toast toast = Toast.makeText(getContext(), "Username doesn't exist!", Toast.LENGTH_LONG);
                        toast.show();
                        return;
                    }
                    else{
                        bundle.putSerializable("patient", patient);
                    }
                }
                else{
                    bundle.putSerializable("doctor", doctor);
                }

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        // onclick listener for signup
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.addToBackStack(null);
                RegisterFragment fragment = RegisterFragment.newInstance();
                transaction.replace(R.id.content, fragment);
                transaction.commit();
            }
        });

        return rootView;
    }

}
