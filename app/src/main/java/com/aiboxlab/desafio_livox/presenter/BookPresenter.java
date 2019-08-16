package com.aiboxlab.desafio_livox.presenter;

import com.aiboxlab.desafio_livox.BookMVP;
import com.aiboxlab.desafio_livox.model.data.BookData;
import com.aiboxlab.desafio_livox.model.domain.Book;

import java.util.ArrayList;

public class BookPresenter implements BookMVP.Presenter, BookMVP.Model.onDataLoadingListener {
    private BookMVP.View bookView;
    private BookMVP.Model bookModel;

    public BookPresenter(BookMVP.View bookView) {
        this.bookView = bookView;
        this.bookModel = new BookData();
    }

    @Override
    public void requestData() {
        this.bookView.showProgress();
        this.bookModel.getBookList(this);
    }

    @Override
    public void onDataLoaded(ArrayList<Book> bookList) {
        this.bookView.setDataToListView(bookList);
        this.bookView.hideProgress();
    }

    @Override
    public void onLoadingFailure() {
        this.bookView.showErrorMessage();
        this.bookView.hideProgress();
    }
}
