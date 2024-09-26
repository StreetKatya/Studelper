package com.example.studelper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studelper.databinding.FragmentAddToDbBinding;
import com.example.studelper.databinding.FragmentDashboardBinding;

import java.util.LinkedList;

public class AddToDb extends Fragment {

    private FragmentAddToDbBinding binding;
    DBHelper dbHelper;

    public AddToDb() {
        // Required empty public constructor
    }

    public static AddToDb newInstance(String param1, String param2) {
        AddToDb fragment = new AddToDb();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DBHelper(requireContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddToDbBinding.inflate(inflater, container, false);

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int T_ID = Integer.parseInt(binding.editTextText.getText().toString());
                int G_ID = Integer.parseInt(binding.editTextText2.getText().toString());
                String SUB_NAME = binding.editTextText3.getText().toString();
                String T_START = binding.editTextText4.getText().toString();
                String T_END = binding.editTextText5.getText().toString();
                String CLASS = binding.editTextText6.getText().toString();
                int C_V = Integer.parseInt(binding.editTextText7.getText().toString());
                String DAY = binding.editTextText8.getText().toString();
                DataTime dt = new DataTime(SUB_NAME,T_ID,G_ID,DAY,T_START,T_END,CLASS,C_V);

                dbHelper.Add(dt);
            }
        });
        binding.buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinkedList<DataTime> list = dbHelper.GetAll();
                String text = "";
                for(DataTime d : list){
                    text = text + d.TIME_START+"-"+d.TIME_END+" Group: "+d.GROUP_ID+" Lesson: "
                            +d.SUBJECT_NAME+" in "+d.CLASSROOM+"\n";
                }
            }
        });
//        return inflater.inflate(R.layout.fragment_add_to_db, container, false);
        return binding.getRoot();
    }
}