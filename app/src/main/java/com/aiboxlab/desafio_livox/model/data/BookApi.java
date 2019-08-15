package com.aiboxlab.desafio_livox.model.data;

import com.aiboxlab.desafio_livox.model.domain.Book;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BookApi {
    @GET("h8xi7/")
    Call<ArrayList<Book>> getBooks();
}
