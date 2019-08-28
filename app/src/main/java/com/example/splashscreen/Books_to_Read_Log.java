package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.splashscreen.Classes.BookLog_Details;
import com.example.splashscreen.Classes.Finish_book_names;
import com.example.splashscreen.NewTasks.Create_new_Book_log;
import com.example.splashscreen.utility.Book_log_RecycleView;
import com.example.splashscreen.utility.Finish_Book_log_RecycleView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Books_to_Read_Log extends AppCompatActivity {
    private ImageView new_bookIcon;
    private ImageView menu_popup;
    private Book_log_RecycleView book_log_recycleView;
    private Finish_Book_log_RecycleView finish_book_log_recycleView;
    private ArrayList<BookLog_Details> bookLog_details = new ArrayList<>();
    private ArrayList<Finish_book_names> finish_book_names = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_to__read__log);
        new_bookIcon = findViewById(R.id.add_new_book);
        menu_popup = findViewById(R.id.booksLog_to);

        new_bookIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Books_to_Read_Log.this, Create_new_Book_log.class);
                startActivity(i);
            }
        });
        setMenu_popup();
        bookLog_details.add(new BookLog_Details("Jail Diary", "Chandrashekar", getCurrentDate(), "0000"));
        bookLog_details.add(new BookLog_Details("David Copperfield", "Charles Dickens", getCurrentDate(), "0000"));
        bookLog_details.add(new BookLog_Details("Death of City", "Amrita Pritam", getCurrentDate(), "0000"));
        finish_book_names.add(new Finish_book_names("Death of City"));


        setBook_log_recycleView();
        setFinish_book_log_recycleView();
        setCurrent_bookReading_recycleView();
    }

    private void setBook_log_recycleView() {
        RecyclerView recyclerView = findViewById(R.id.book_cover_view);
        book_log_recycleView = new Book_log_RecycleView(this, bookLog_details);
        recyclerView.setAdapter(book_log_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

    }

    private void setFinish_book_log_recycleView() {
        RecyclerView recyclerView = findViewById(R.id.finish_book_cover_view);
        finish_book_log_recycleView = new Finish_Book_log_RecycleView(this, finish_book_names);
        recyclerView.setAdapter(finish_book_log_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
    }

    private void setCurrent_bookReading_recycleView() {
        RecyclerView recyclerView = findViewById(R.id.current_reading_books);
        finish_book_log_recycleView = new Finish_Book_log_RecycleView(this, finish_book_names);
        recyclerView.setAdapter(finish_book_log_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
    }


    private void setMenu_popup() {
        menu_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Books_to_Read_Log.this, menu_popup);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.books_log, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                Books_to_Read_Log.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId() == R.id.booksLog_to_today) {
                            Intent i = new Intent(Books_to_Read_Log.this, TodysChecklit_Activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.booksLog_t0_weekly) {
                            Intent i = new Intent(Books_to_Read_Log.this, WeekCheck_list.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.booksLog_t0_daily) {
                            Intent i = new Intent(Books_to_Read_Log.this, Daily_Thoughts.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.booksLog_t0_gratitude) {
                            Intent i = new Intent(Books_to_Read_Log.this, Gratitude_log_activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.booksLog_to_spendingLog) {
                            Intent i = new Intent(Books_to_Read_Log.this, Spending_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.booksLog_to_movies) {
                            Intent i = new Intent(Books_to_Read_Log.this, MoviesToWatch.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.booksLog_to_mood) {
                            Intent i = new Intent(Books_to_Read_Log.this, SelectMoods.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.booksLog_to_habit) {
                            Intent i = new Intent(Books_to_Read_Log.this, HabitTracker.class);
                            startActivity(i);
                            finish();
                        }

                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        });
    }

    public  String getCurrentDate() {
        String DATE_FORMAT_4 = "MMMM dd, yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

}
