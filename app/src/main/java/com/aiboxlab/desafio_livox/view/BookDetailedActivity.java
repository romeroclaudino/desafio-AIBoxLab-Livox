package com.aiboxlab.desafio_livox.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiboxlab.desafio_livox.R;
import com.aiboxlab.desafio_livox.model.domain.Book;
import com.squareup.picasso.Picasso;


public class BookDetailedActivity extends AppCompatActivity {
    private ImageView cover;
    private TextView title, isbn, status, longDescription, authors, categories;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detailed);

        cover = findViewById(R.id.activity_book_detailed_cover);
        title = findViewById(R.id.activity_book_detailed_txt_title);
        isbn = findViewById(R.id.activity_book_detailed_txt_isbn);
        status = findViewById(R.id.activity_book_detailed_txt_status);
        longDescription = findViewById(R.id.activity_book_detailed_txt_long_description);
        authors = findViewById(R.id.activity_book_detailed_txt_authors);
        categories = findViewById(R.id.activity_book_detailed_txt_categories);

        Book book = (Book) getIntent().getSerializableExtra(Book.KEY);

        Picasso.get().load(book.getThumbnailUrl()).into(cover);
        title.setText(book.getTitle());
        isbn.setText(book.getIsbn());
        String bStatus = (book.getStatus().equals("PUBLISH")) ? "Publicado" : "Leitura Antecipada";
        status.setText(bStatus);
        longDescription.setText(book.getLongDescription());

        authors.setText(TextUtils.join(", ", book.getAuthors()));
        categories.setText(TextUtils.join(", ", book.getCategories()));
    }
}
