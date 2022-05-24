package com.example.application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.application.databinding.FragmentContact2Binding;


public class ContactFragment2 extends Fragment {
    private FragmentContact2Binding fragmentContact2Binding;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentContact2Binding = FragmentContact2Binding.inflate(inflater, container, false);

        fragmentContact2Binding.imageViewMireaLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mirea.ru"));
                startActivity(intent);
            }
        });

        fragmentContact2Binding.imageViewVkLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://vk.com/mirea_official"));
                startActivity(intent);
            }
        });

        fragmentContact2Binding.imageViewInstagramLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/rtu_university_official"));
                startActivity(intent);
            }
        });

        fragmentContact2Binding.imageViewTikTokLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tiktok.com/@rtu.mirea"));
                startActivity(intent);
            }
        });

        fragmentContact2Binding.imageViewFacebookLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com/mireaofficial"));
                startActivity(intent);
            }
        });

        fragmentContact2Binding.imageViewTelegramLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/rtumirea_official"));
                startActivity(intent);
            }
        });

        fragmentContact2Binding.imageViewYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/c/MireaRu/videos"));
                startActivity(intent);
            }
        });

        fragmentContact2Binding.imageViewYouTubeLogo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vk.cc/89kZ3J"));
                startActivity(intent);
            }
        });

        fragmentContact2Binding.imageViewInstagramLogo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/life.mirea"));
                startActivity(intent);
            }
        });

        return fragmentContact2Binding.getRoot();
    }
}