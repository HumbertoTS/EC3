package com.example.ec3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ArrayList<ProductoModel> listaproductos;

    public ProductoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductoFragment newInstance(String param1, String param2) {
        ProductoFragment fragment = new ProductoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_producto, container, false);

        listaproductos = new ArrayList<>();
        recyclerView=vista.findViewById(R.id.recyclerherramienta);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarlista();

        ProductoAdapter adapter = new ProductoAdapter(listaproductos);
        recyclerView.setAdapter(adapter);

        return vista;
    }

    private void llenarlista() {
        listaproductos.add(new ProductoModel("https://promart.vteximg.com.br/arquivos/ids/635333-1000-1000/121838.jpg?v=637437311891730000","Martillo","sirve para clavar","S/. 20.00"));
        listaproductos.add(new ProductoModel("https://promart.vteximg.com.br/arquivos/ids/568058-1000-1000/111482.jpg?v=637393526889070000","Martillo","sirve para cortar árboles","S/. 150.00"));
        listaproductos.add(new ProductoModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4FlhuRe2sTcJL0Ih-pOqrwREsyrofvV68OOTWtnuW_yV80JtBtIcg9xRzjHL8nTM4jd0&usqp=CAU","Taladro","Sirve para hacer agujeros","S/. 110.00"));
        listaproductos.add(new ProductoModel("https://promart.vteximg.com.br/arquivos/ids/568058-1000-1000/111482.jpg?v=637393526889070000","Martillo"));
        listaproductos.add(new ProductoModel("https://promart.vteximg.com.br/arquivos/ids/568058-1000-1000/111482.jpg?v=637393526889070000","Martillo"));
    }
}