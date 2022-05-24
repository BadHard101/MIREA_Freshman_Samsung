package com.example.application;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import com.example.application.databinding.FragmentRootBinding;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class RootFragment extends Fragment {
    private FragmentRootBinding fragmentRootBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentRootBinding = FragmentRootBinding.inflate(inflater, container, false);

        fragmentRootBinding.buttonAboutApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(RootFragment.this).navigate(R.id.action_rootFragment_to_AboutAppFragment);
            }
        });

        fragmentRootBinding.buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PdfActivity.class);
                startActivity(intent);
            }
        });

        fragmentRootBinding.buttonVict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(RootFragment.this).navigate(R.id.action_rootFragment_to_VictFragment);
            }
        });

        fragmentRootBinding.buttonMusthave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(RootFragment.this).navigate(R.id.action_rootFragment_to_MustHaveFragment);
            }
        });

        fragmentRootBinding.buttonCommunication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(RootFragment.this).navigate(R.id.action_rootFragment_to_ContactFragment);
            }
        });

         return fragmentRootBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Calendar calendar = Calendar.getInstance();
        TextView whats_week_View = (TextView)view.findViewById(R.id.whats_week);
        int whats_week = calendar.get(Calendar.WEEK_OF_YEAR)%2;
        if (whats_week==1)
            whats_week_View.setText("Сейчас идет I (нечетная) неделя");
        else
            whats_week_View.setText("Сейчас идет II(четная) неделя");


        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Date currentTime = Calendar.getInstance().getTime();
                                String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);

                                String[] splitDate = formattedDate.split(",");
                                String[] splitDate1 = currentTime.toString().split(" ");

                                String[] splitDate2 = splitDate1[3].split(":");; //время
                                //Log.d("myLOG", splitDate[0].trim());
                                //Log.d("myLOG", splitDate2[0].trim()); // час
                                //Log.d("myLOG", splitDate2[1].trim()); // минуты

                                //splitDate2[0]="10";
                                //splitDate2[1]="34";

                                TextView when_n_l = (TextView)view.findViewById(R.id.when_next_lesson);
                                String currentDay = splitDate[0];
                                if (currentDay == "Sunday")
                                    when_n_l.setText("Сегодня пар нет.\nОтдыхайте :)");
                                else {
                                    int hourss = Integer.parseInt(splitDate2[0]);
                                    int minss = Integer.parseInt(splitDate2[1]);
                                    if (hourss<8) {
                                        when_n_l.setText("ZzZ Отдыхайте ;)");
                                        when_n_l.setTextColor(Color.parseColor("#1F2655"));
                                    }
                                    else if (hourss<9) {
                                        int m = 59-minss;
                                        when_n_l.setText("Доброе утро!\nПары через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#1F2655"));
                                    }
                                    else if (hourss<10) {
                                        int m = 89-minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss==10 && minss<30) {
                                        int m = 29-minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss==10 && minss<40) {
                                        int m = 39-minss;
                                        when_n_l.setText("Перерыв.\nПара через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#1A5A28"));
                                    }
                                    else if (hourss<12) {
                                        int m = (12-hourss) * 60 + 9 - minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss==12 && minss<10) {
                                        int m = 9 - minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss==12 && minss<40) {
                                        int m = 39 - minss;
                                        when_n_l.setText("Перерыв.\nПара через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#1A5A28"));
                                    }
                                    else if (hourss<14) {
                                        int m = (14-hourss) * 60 + 9 - minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss==14 && minss<10) {
                                        int m = 9 - minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss==14 && minss<20) {
                                        int m = 19 - minss;
                                        when_n_l.setText("Перерыв.\nПара через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#1A5A28"));
                                    }
                                    else if (hourss<15) {
                                        int m = (15-hourss) * 60 + 49 - minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss==15 && minss<50) {
                                        int m = 49 - minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss<16) {
                                        int m = 79 - minss;
                                        when_n_l.setText("Перерыв.\nПара через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#1A5A28"));
                                    }
                                    else if (hourss==16 && minss<20) {
                                        int m = 19 - minss;
                                        when_n_l.setText("Перерыв.\nПара через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#1A5A28"));
                                    }
                                    else if (hourss<17) {
                                        int m = (17-hourss) * 60 + 49 - minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss==17 && minss<50) {
                                        int m = 49 - minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss<18) {
                                        int m = 59 - minss;
                                        when_n_l.setText("Перерыв.\nПара через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#1A5A28"));
                                    }
                                    else if (hourss<19) {
                                        int m = 89 - minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss==19 && minss<30) {
                                        int m = 29 - minss;
                                        when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#531C13"));
                                    }
                                    else if (hourss<24) {
                                        when_n_l.setText("Пары закончились!\nХорошего отдыха...");
                                        when_n_l.setTextColor(Color.parseColor("#1F2655"));
                                    }
                                }
                            }
                        });
                        Thread.sleep(1000);
                    }
                }
                catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }
}