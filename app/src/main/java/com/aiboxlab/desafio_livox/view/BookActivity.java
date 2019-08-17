package com.aiboxlab.desafio_livox.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.aiboxlab.desafio_livox.BookMVP;
import com.aiboxlab.desafio_livox.R;
import com.aiboxlab.desafio_livox.adapter.BookAdapter;
import com.aiboxlab.desafio_livox.model.domain.Book;
import com.aiboxlab.desafio_livox.presenter.BookPresenter;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity implements BookMVP.View, AdapterView.OnItemClickListener {

    private ListView bookLv;
    private BookAdapter bookAdapter;
    private ArrayList<Book> books;
    private BookPresenter bookPresenter;
    private ContentLoadingProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        books = new ArrayList<>();
        bookAdapter = new BookAdapter(BookActivity.this, R.layout.book_item, books);
        bookLv = findViewById(R.id.activity_book_listview);
        bookLv.setAdapter(bookAdapter);
        bookLv.setOnItemClickListener(this);

        progressBar = findViewById(R.id.activity_book_progress);

        bookPresenter = new BookPresenter(this);
        bookPresenter.requestData();
    }

    @Override
    public void showProgress() {
        progressBar.show();
    }

    @Override
    public void hideProgress() {
        progressBar.hide();
    }

    @Override
    public void setDataToListView(ArrayList<Book> bookList) {
        this.books.addAll(bookList);
        this.bookAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, getResources().getText(R.string.message_error), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent bookDetail = new Intent(BookActivity.this, BookDetailedActivity.class);
        bookDetail.putExtra(Book.KEY, books.get(position));
        startActivity(bookDetail);
    }
}
