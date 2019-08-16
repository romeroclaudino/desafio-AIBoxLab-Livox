package com.aiboxlab.desafio_livox;

import com.aiboxlab.desafio_livox.model.domain.Book;

import java.util.ArrayList;

public interface BookMVP {

    interface Model{
        interface onDataLoadingListener {
            void onDataLoaded(ArrayList<Book> bookList);
            void onLoadingFailure();
        }

        void getBookList(onDataLoadingListener onDataLoadingListener);
    }

    interface View {
        void showProgress();
        void hideProgress();
        void setDataToListView(ArrayList<Book> bookList);
        void showErrorMessage();
    }

    interface Presenter {
        void requestData();
    }
}
