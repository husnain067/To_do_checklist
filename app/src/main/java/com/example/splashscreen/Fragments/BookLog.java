package com.example.splashscreen.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.splashscreen.Classes.BookLog_Details;
import com.example.splashscreen.Classes.Finish_book_names;
import com.example.splashscreen.NewTasks.Create_new_Book_log;
import com.example.splashscreen.R;
import com.example.splashscreen.utility.Book_log_RecycleView;
import com.example.splashscreen.utility.Finish_Book_log_RecycleView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookLog extends Fragment {
    private View rootView;

    private ImageView new_bookIcon;
    private ImageView menu_popup;
    private Book_log_RecycleView book_log_recycleView;
    private Finish_Book_log_RecycleView finish_book_log_recycleView;
    private ArrayList<BookLog_Details> bookLog_details = new ArrayList<>();
    private ArrayList<Finish_book_names> finish_book_names = new ArrayList<>();

    public BookLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_book_log, container, false);


        new_bookIcon = rootView.findViewById(R.id.add_new_book);
        menu_popup = rootView.findViewById(R.id.booksLog_to);

        new_bookIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Create_new_Book_log.class);
                startActivity(i);
            }
        });

        bookLog_details.add(new BookLog_Details("Jail Diary", "Chandrashekar", getCurrentDate(), "0000"));
        bookLog_details.add(new BookLog_Details("David Copperfield", "Charles Dickens", getCurrentDate(), "0000"));
        bookLog_details.add(new BookLog_Details("Death of City", "Amrita Pritam", getCurrentDate(), "0000"));
        finish_book_names.add(new Finish_book_names("Death of City"));


        setBook_log_recycleView();
        setFinish_book_log_recycleView();
        setCurrent_bookReading_recycleView();

        return rootView;
    }

    private void setBook_log_recycleView() {
        RecyclerView recyclerView = rootView.findViewById(R.id.book_cover_view);
        book_log_recycleView = new Book_log_RecycleView(getActivity(), bookLog_details);
        recyclerView.setAdapter(book_log_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));

    }

    private void setFinish_book_log_recycleView() {
        RecyclerView recyclerView = rootView.findViewById(R.id.finish_book_cover_view);
        finish_book_log_recycleView = new Finish_Book_log_RecycleView(getActivity(), finish_book_names);
        recyclerView.setAdapter(finish_book_log_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
    }

    private void setCurrent_bookReading_recycleView() {
        RecyclerView recyclerView = rootView.findViewById(R.id.current_reading_books);
        finish_book_log_recycleView = new Finish_Book_log_RecycleView(getActivity(), finish_book_names);
        recyclerView.setAdapter(finish_book_log_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
    }

    public String getCurrentDate() {
        String DATE_FORMAT_4 = "MMMM dd, yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}
