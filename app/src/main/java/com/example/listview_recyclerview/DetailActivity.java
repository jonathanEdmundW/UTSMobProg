package com.example.listview_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    ImageView image;
    TextView title, author, desc, price;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        image = findViewById(R.id.detail_image);
        title = findViewById(R.id.detail_title);
        author = findViewById(R.id.detail_author);
        desc = findViewById(R.id.detail_desc);
        price = findViewById(R.id.detail_price);
        backButton = findViewById(R.id.back);

        Intent getData = getIntent();
        Book book = (Book) getData.getSerializableExtra("dataBook");

        image.setImageResource(book.image);
        title.setText(book.title);
        author.setText(book.author);
        desc.setText(book.desc);
        price.setText(book.price+"");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });
    }


}