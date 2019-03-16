package com.epam.themes.hw_04_03_19;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.epam.cleancodetest.R;

public class Fragment_hw extends Fragment {
    private TextView textView;
    private String multiplier;
    private Button teamOne;
    private Button teamTwo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hw, container, false);
    }

     @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView=view.findViewById(R.id.textView);
        teamOne=view.findViewById(R.id.teamOne);
        teamTwo=view.findViewById(R.id.teamTwo);

        teamOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplier =teamOne.getText().toString();
                textView.setText(multiplier);
            }
        });
        teamTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplier =teamTwo.getText().toString();
                textView.setText(multiplier);
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(multiplier, textView.getText().toString());
    }

    @Override
    public void onViewStateRestored(@Nullable final Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null){
            textView.setText(savedInstanceState.getString(multiplier));
        }
    }
}

