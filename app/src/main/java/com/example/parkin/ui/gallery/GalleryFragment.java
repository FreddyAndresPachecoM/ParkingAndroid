package com.example.parkin.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkin.R;
import com.example.parkin.databinding.FragmentGalleryBinding;
import com.example.parkin.models.Vehiculo;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    View root;
    EditText editTextMarcaRV, editTextColorRV, editTextMatriculaRV, editTextModeloRV, editTextDefinicionRV;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        /*final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        editTextMarcaRV = root.findViewById(R.id.editTextMarcaRC);
        editTextColorRV = root.findViewById(R.id.editTextColorRC2);
        editTextMatriculaRV = root.findViewById(R.id.editTextMatriculaRC);
        editTextModeloRV = root.findViewById(R.id.editTextModeloRC);
        editTextDefinicionRV = root.findViewById(R.id.editTextDefinicionRC);

        Button buttonRegistraV = root.findViewById(R.id.buttonRegistraV);

        buttonRegistraV.setOnClickListener(crearV);

        return root;
    }

    View.OnClickListener crearV = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setMarca(editTextMarcaRV.getText().toString());
            vehiculo.setColor(editTextColorRV.getText().toString());
            vehiculo.setMatricula(editTextMatriculaRV.getText().toString());
            vehiculo.setModelo(editTextModeloRV.getText().toString());
            vehiculo.setDefinicion(editTextDefinicionRV.getText().toString());
            vehiculo.setClienteid(1);

            vehiculo.guardar(getContext());
            Toast.makeText(v.getContext(), "Vehiculo agregado correctamente!", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}