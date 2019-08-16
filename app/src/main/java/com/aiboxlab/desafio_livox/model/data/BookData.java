package com.aiboxlab.desafio_livox.model.data;

import android.util.Log;

import com.aiboxlab.desafio_livox.BookMVP;
import com.aiboxlab.desafio_livox.model.domain.Book;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookData implements BookMVP.Model {
    private final String TAG = "BookData";

    @Override
    public void getBookList(final onDataLoadingListener onDataLoadingListener) {
        BookApi bookApi = RetrofitClient.getClient().create(BookApi.class);

        Call<ArrayList<Book>> call = bookApi.getBooks();

        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {

                ArrayList<Book> bookList = response.body();
                onDataLoadingListener.onDataLoaded(bookList);
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable throwable) {

                Log.d(TAG, throwable.toString());
                onDataLoadingListener.onLoadingFailure();

            }
        });
    }
}
