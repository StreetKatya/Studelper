package com.example.studelper.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.studelper.R;
import com.example.studelper.databinding.ActivityMainBinding;
import com.example.studelper.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        Button about = view.findViewById(R.id.about);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);

        binding.btnAbout.setOnClickListener(new View.OnClickListener() { //О Вузе
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_navigation_dashboard_to_aboutVUZ);
            }
        });
        binding.btnDocuments.setOnClickListener(new View.OnClickListener() { //Документы
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_navigation_dashboard_to_documentFragment);
            }
        });
        binding.btnScheme.setOnClickListener(new View.OnClickListener() { //Схема этажей
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_navigation_dashboard_to_floorPlanFragment);
            }
        });
        binding.btnSchedule.setOnClickListener(new View.OnClickListener() { //Расписание
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_navigation_dashboard_to_scheduleFragment);
            }
        });
//        binding.btnDB.setOnClickListener(new View.OnClickListener() { //База данных
//            @Override
//            public void onClick(View view) {
//                NavController navController = Navigation.findNavController(view);
//                navController.navigate(R.id.action_navigation_dashboard_to_addToDb);
//            }
//        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}