package com.aiboxlab.desafio_livox.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiboxlab.desafio_livox.R;
import com.aiboxlab.desafio_livox.model.domain.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    private Context context;
    private int resource;
    private List<Book> bookList;


    public BookAdapter(Context context, int resource, List<Book> bookList) {
        super(context, resource, bookList);
        this.context = context;
        this.resource = resource;
        this.bookList = bookList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(this.resource, null);

        Book book        = this.bookList.get(position);
        TextView title   = convertView.findViewById(R.id.lv_item_txt_title);
        TextView authors = convertView.findViewById(R.id.lv_item_txt_authors);
        TextView status  = convertView.findViewById(R.id.lv_item_txt_status);
        ImageView cover  = convertView.findViewById(R.id.lv_item_img_cover);

        title.setText(book.getTitle());

        authors.setText(TextUtils.join(", ", book.getAuthors()));
        String bStatus = (book.getStatus().equals("PUBLISH")) ? "Publicado" : "Leitura Antecipada";
        status.setText(bStatus);
        Picasso.get().load(book.getThumbnailUrl()).into(cover);

        return convertView;
    }
}
