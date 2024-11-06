package com.example.listview_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Book> bookList;
    RecyclerView book_RView;
    BookAdapter book_adapter;
    ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bookList = new ArrayList<>();
        Book book1 = new Book();
        book1.image = R.drawable.baseline_bolt_24;
        book1.title = "Pergi ke China";
        book1.author = "Liu";
        book1.desc = "Liu goes to China";
        book1.price = 10000;

        Book book2 = new Book();
        book2.image = R.drawable.baseline_bolt_24;
        book2.title = "Pergi ke Africa";
        book2.author = "Algi";
        book2.desc = "Algi goes to Africa";
        book2.price = 20000;

        Book book3 = new Book();
        book3.image = R.drawable.baseline_bolt_24;
        book3.title = "Pergi ke Pulau Jawa";
        book3.author = "Davin";
        book3.desc = "Davin goes to Pulau Jawa";
        book3.price = 30000;

        for(int i = 0; i < 3; i++){
            bookList.add(book1);
            bookList.add(book2);
            bookList.add(book3);
        }

        book_RView = findViewById(R.id.book_RView);
        // book_RView.setLayoutManager(new LinearLayoutManager(this));
        book_RView.setLayoutManager(new GridLayoutManager(this, 3));

        book_adapter = new BookAdapter(this, bookList);
        book_RView.setAdapter((book_adapter));

//        list_view = findViewById(R.id.list_view);
//
//        String [] listNama = {"Liu", "Algi", "Davin"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this, android.R.layout.simple_list_item_1, listNama);
//        list_view.setAdapter(adapter);
//
//        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String item = (String) parent.getItemAtPosition(position);
//                Toast.makeText(MainActivity.this, "item:" + item, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}