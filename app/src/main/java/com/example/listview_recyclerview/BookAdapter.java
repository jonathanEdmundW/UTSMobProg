package com.example.listview_recyclerview;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{

    Context ctx;
    ArrayList <Book> book_list;

    public BookAdapter(Context inputContext, ArrayList<Book> inputBookList){
        this.ctx = inputContext;
        this.book_list = inputBookList;
    }

    public BookAdapter(ArrayList<Book> bookList) {
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(
                R.layout.book_list,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        Book book = book_list.get(position);
        holder.image.setImageResource(book.image);
        holder.title.setText(book.title);
        holder.author.setText(book.author);
    }

    @Override
    public int getItemCount() {
        return book_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView title, author;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.book_image);
            title = itemView.findViewById(R.id.book_title);
            author = itemView.findViewById(R.id.book_author);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Book book = book_list.get(position);
//            Toast.makeText(ctx, "Price" + book.price + "Desc" + book.desc, Toast.LENGTH_SHORT).show();
            Intent openDetailActivity = new Intent(v.getContext() , DetailActivity.class);
            openDetailActivity.putExtra("dataBook", book);
            v.getContext().startActivity(openDetailActivity);
        }
    }
}

