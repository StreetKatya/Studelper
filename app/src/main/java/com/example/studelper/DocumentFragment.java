package com.example.studelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studelper.databinding.ActivityMainBinding;
import com.example.studelper.databinding.FragmentDocumentBinding;

public class DocumentFragment extends Fragment {

    private FragmentDocumentBinding binding;
    public DocumentFragment() {
        // Required empty public constructor
    }

    public static DocumentFragment newInstance(String param1, String param2) {
        DocumentFragment fragment = new DocumentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDocumentBinding.inflate(getLayoutInflater());
        binding.btnWebref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.yandex.ru/cloud/66d812f690fa7bcabed1880e/"));
                startActivity(browserIntent);
            }
        });
        binding.btnWebtable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://forms.yandex.ru/cloud/66d812f690fa7bcabed1880e/")); // Замените на нужный URL
                startActivity(intent);
            }
        });
        //return inflater.inflate(R.layout.fragment_document, container, false);
        return binding.getRoot();
    }
}