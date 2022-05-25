package com.example.application;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.application.databinding.FragmentMustHaveBinding;


public class MustHaveFragment extends Fragment {
    private FragmentMustHaveBinding fragmentMustHaveBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_must_have, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final CheckBox checkBox1 = (CheckBox) getActivity().findViewById(R.id.box1);
        final CheckBox checkBox2 = (CheckBox) getActivity().findViewById(R.id.box2);
        final CheckBox checkBox3 = (CheckBox) getActivity().findViewById(R.id.box3);
        final CheckBox checkBox4 = (CheckBox) getActivity().findViewById(R.id.box4);
        final CheckBox checkBox5 = (CheckBox) getActivity().findViewById(R.id.box5);
        final CheckBox checkBox6 = (CheckBox) getActivity().findViewById(R.id.box6);
        final CheckBox checkBox7 = (CheckBox) getActivity().findViewById(R.id.box7);
        final CheckBox checkBox8 = (CheckBox) getActivity().findViewById(R.id.box8);
        final CheckBox checkBox9 = (CheckBox) getActivity().findViewById(R.id.box9);
        final CheckBox checkBox10 = (CheckBox) getActivity().findViewById(R.id.box10);
        final CheckBox checkBox11 = (CheckBox) getActivity().findViewById(R.id.box11);
        final CheckBox checkBox12 = (CheckBox) getActivity().findViewById(R.id.box12);
        final CheckBox checkBox13 = (CheckBox) getActivity().findViewById(R.id.box13);
        final CheckBox checkBox14 = (CheckBox) getActivity().findViewById(R.id.box14);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        final SharedPreferences.Editor editor = preferences.edit();

        if (preferences.getBoolean("checkbox1", false) == true) checkBox1.setChecked(true);
        else checkBox1.setChecked(false);
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox1.isChecked()) {
                    editor.putBoolean("checkbox1", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox1", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox2", false) == true) checkBox2.setChecked(true);
        else checkBox2.setChecked(false);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox2.isChecked()) {
                    editor.putBoolean("checkbox2", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox2", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox3", false) == true) checkBox3.setChecked(true);
        else checkBox3.setChecked(false);
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox3.isChecked()) {
                    editor.putBoolean("checkbox3", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox3", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox4", false) == true) checkBox4.setChecked(true);
        else checkBox4.setChecked(false);
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox4.isChecked()) {
                    editor.putBoolean("checkbox4", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox4", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox5", false) == true) checkBox5.setChecked(true);
        else checkBox5.setChecked(false);
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox5.isChecked()) {
                    editor.putBoolean("checkbox5", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox5", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox6", false) == true) checkBox6.setChecked(true);
        else checkBox6.setChecked(false);
        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox6.isChecked()) {
                    editor.putBoolean("checkbox6", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox6", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox7", false) == true) checkBox7.setChecked(true);
        else checkBox7.setChecked(false);
        checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox7.isChecked()) {
                    editor.putBoolean("checkbox7", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox7", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox8", false) == true) checkBox8.setChecked(true);
        else checkBox8.setChecked(false);
        checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox8.isChecked()) {
                    editor.putBoolean("checkbox8", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox8", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox9", false) == true) checkBox9.setChecked(true);
        else checkBox9.setChecked(false);
        checkBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox9.isChecked()) {
                    editor.putBoolean("checkbox9", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox9", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox10", false) == true) checkBox10.setChecked(true);
        else checkBox10.setChecked(false);
        checkBox10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox10.isChecked()) {
                    editor.putBoolean("checkbox10", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox10", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox11", false) == true) checkBox11.setChecked(true);
        else checkBox11.setChecked(false);
        checkBox11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox11.isChecked()) {
                    editor.putBoolean("checkbox11", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox11", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox12", false) == true) checkBox12.setChecked(true);
        else checkBox12.setChecked(false);
        checkBox12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox12.isChecked()) {
                    editor.putBoolean("checkbox12", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox12", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox12", false) == true) checkBox12.setChecked(true);
        else checkBox12.setChecked(false);
        checkBox12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox12.isChecked()) {
                    editor.putBoolean("checkbox12", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox12", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox13", false) == true) checkBox13.setChecked(true);
        else checkBox13.setChecked(false);
        checkBox13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox13.isChecked()) {
                    editor.putBoolean("checkbox13", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox13", false);
                    editor.apply();
                }
            }
        });

        if (preferences.getBoolean("checkbox14", false) == true) checkBox14.setChecked(true);
        else checkBox14.setChecked(false);
        checkBox14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox14.isChecked()) {
                    editor.putBoolean("checkbox14", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checkbox14", false);
                    editor.apply();
                }
            }
        });
    }
}