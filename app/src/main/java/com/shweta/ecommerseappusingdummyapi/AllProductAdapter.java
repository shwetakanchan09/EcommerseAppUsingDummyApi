package com.shweta.ecommerseappusingdummyapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllProductAdapter extends RecyclerView.Adapter<AllProductAdapter.ViewHolder> {

    Context context;
    ArrayList<AllProductModel> productList;

    public AllProductAdapter(Context context, ArrayList<AllProductModel> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public AllProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_products, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllProductAdapter.ViewHolder holder, int position) {
      /*  AllProductModel getProducts = productList.get(position);
        holder.title.setText(getProducts.getTitle());
        holder.desc.setText(getProducts.getDescription());
        holder.price.setText(getProducts.getPrice());*/

       /* holder.title.setText(productList.getProducts().get(position).getTitle());
        holder.desc.setText(""+productList.getProducts().get(position).getDescription());
        holder.price.setText(""+productList.getProducts().get(position).getPrice());
        holder.disc_price.setText(""+productList.getProducts().get(position).getDiscountPercentage());
        holder.rating.setText(""+productList.getProducts().get(position).getRating());
        holder.stock.setText(""+productList.getProducts().get(position).getStock());
        holder.brand.setText(""+productList.getProducts().get(position).getBrand());
        holder.category.setText(""+productList.getProducts().get(position).getCategory());
    */

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private ImageView product_pic;
        TextView title,desc,price,disc_price,rating,stock,brand,category;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            title = mView.findViewById(R.id.txtTitle);
            desc = mView.findViewById(R.id.txtDesc);
            price = mView.findViewById(R.id.txtPrice);
            disc_price = mView.findViewById(R.id.txtDiscount);
            rating = mView.findViewById(R.id.txtRating);
            stock = mView.findViewById(R.id.txtStock);
            brand = mView.findViewById(R.id.txtBrand);
            category = mView.findViewById(R.id.txtCat);
            product_pic = mView.findViewById(R.id.imgSlide);
        }
    }
}
