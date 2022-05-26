package com.example.application;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
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
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.notificationManagerCompat = NotificationManagerCompat.from(getContext());
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

    private void sendOnChannel1()  {
        String title = "MIREA Freshman";
        String message = "5 минут до начала пары!";

        Notification notification = new NotificationCompat.Builder(getContext(), NotificationApp.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.paw1)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        int notificationId = 1;
        this.notificationManagerCompat.notify(notificationId, notification);
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
            whats_week_View.setText("Сейчас идет II (четная) неделя");


        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        getActivity().runOnUiThread(new Runnable() {

                            Date currentTime = Calendar.getInstance().getTime();
                            String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);

                            String[] splitDate = formattedDate.split(",");
                            String[] splitDate1 = currentTime.toString().split(" ");

                            String[] splitDate2 = splitDate1[3].split(":");

                            TextView when_n_l = (TextView)view.findViewById(R.id.when_next_lesson);
                            String currentDay = splitDate[0];

                            void startPar(int m) {
                                when_n_l.setText("Пара началась!\nПерерыв через " + m + " minutes");
                                when_n_l.setTextColor(Color.parseColor("#9C2A2A"));
                            }

                            void endPar(int m) {
                                when_n_l.setText("Перерыв.\nПара через " + m + " minutes");
                                when_n_l.setTextColor(Color.parseColor("#388E3C"));
                                if (m == 5) sendOnChannel1();
                            }

                            @Override
                            public void run() {
                                //splitDate2[0]="20";
                                //splitDate2[1]="11";


                                if (currentDay == "Sunday") {
                                    when_n_l.setText("Сегодня пар нет.\nОтдыхайте :)");
                                    when_n_l.setTextColor(Color.parseColor("#1F2655"));
                                }
                                else {
                                    int hourss = Integer.parseInt(splitDate2[0]);
                                    int minss = Integer.parseInt(splitDate2[1]);
                                    if (hourss<8) {
                                        when_n_l.setText("ZzZ\nОтдыхайте ;)");
                                        when_n_l.setTextColor(Color.parseColor("#1F2655"));
                                    }
                                    else if (hourss<9) {
                                        int m = 59-minss;
                                        when_n_l.setText("Доброе утро!\nПары через " + m + " minutes");
                                        when_n_l.setTextColor(Color.parseColor("#1F2655"));
                                    }
                                    else if (hourss<10) startPar(89-minss);

                                    else if (hourss==10 && minss<30) startPar(29-minss);

                                    else if (hourss==10 && minss<40) endPar(39-minss);

                                    else if (hourss<12) startPar((12-hourss) * 60 + 9 - minss);

                                    else if (hourss==12 && minss<10) startPar(9 - minss);

                                    else if (hourss==12 && minss<40) endPar(39 - minss);

                                    else if (hourss<14) startPar((14-hourss) * 60 + 9 - minss);

                                    else if (hourss==14 && minss<10) startPar(9 - minss);

                                    else if (hourss==14 && minss<20) endPar(19 - minss);

                                    else if (hourss<15) startPar((15-hourss) * 60 + 49 - minss);

                                    else if (hourss==15 && minss<50) startPar(49 - minss);

                                    else if (hourss<16) endPar(79 - minss);

                                    else if (hourss==16 && minss<20) endPar(19 - minss);

                                    else if (hourss<17) startPar((17-hourss) * 60 + 49 - minss);

                                    else if (hourss==17 && minss<50) startPar(49 - minss);

                                    else if (hourss<18) endPar(59 - minss);

                                    else if (hourss<19) startPar(89 - minss);

                                    else if (hourss==19 && minss<30) startPar(29 - minss);

                                    else if (hourss<24) {
                                        when_n_l.setText("Пары закончились!\nХорошего отдыха...");
                                        when_n_l.setTextColor(Color.parseColor("#1F2655"));
                                    }
                                }
                            }
                        });
                        Thread.sleep(60000);
                    }
                }
                catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }
}