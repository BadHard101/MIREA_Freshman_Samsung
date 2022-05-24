package com.example.application;

import android.os.Bundle;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.navigation.fragment.NavHostFragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

import com.example.application.databinding.FragmentContactBinding;


public class ContactFragment extends Fragment {
    private FragmentContactBinding fragmentContactBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentContactBinding = FragmentContactBinding.inflate(inflater, container, false);

        fragmentContactBinding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ContactFragment.this).navigate(R.id.action_ContactFragment_to_ContactFragment2);
            }
        });

        return fragmentContactBinding.getRoot();

    }
}