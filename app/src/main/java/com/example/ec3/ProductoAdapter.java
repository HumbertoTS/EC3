package com.example.ec3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private ArrayList<ProductoModel> productoModel;

    public ProductoAdapter(ArrayList<ProductoModel> productoModel) {
        this.productoModel = productoModel;
    }

    @NonNull
    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ViewHolder holder, int position) {
        holder.productoName.setText(productoModel.get(position).getProtuctoname());
        holder.productodescrip.setText(productoModel.get(position).getDescription());
        holder.productoprice.setText(productoModel.get(position).getPrice());
        Glide.with(holder.itemView.getContext()).load(productoModel.get(position).getProductophoto()).into(holder.animalPhoto);
    }

    @Override
    public int getItemCount() {
        return productoModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView productoName, productodescrip, productoprice ;
        ImageView animalPhoto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productoName = itemView.findViewById(R.id.producto_name);
            productodescrip = itemView.findViewById(R.id.producto_description);
            productoprice = itemView.findViewById(R.id.producto_price);
            animalPhoto = itemView.findViewById(R.id.producto_photo);
        }
    }
}
