package com.example.parkin.ui.home;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkin.R;
import com.example.parkin.databinding.FragmentHomeBinding;
import com.example.parkin.models.Vehiculo;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        ListView listView = root.findViewById(R.id.listViewVehiculos);
        String[] from = new String[]{"vehiculomarca","vehiculomodelo"};
        int[] hasta = new int[]{android.R.id.text1};
        Cursor cursor = Vehiculo.getCursor(getContext());
        CursorAdapter cursorAdapter = new SimpleCursorAdapter(
          getContext(), android.R.layout.simple_list_item_1,
          cursor, from, hasta, 0
        );

        listView.setAdapter(cursorAdapter);
        /*final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}