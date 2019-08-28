package com.example.splashscreen.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.splashscreen.Classes.MoviesDetails;
import com.example.splashscreen.NewTasks.CreateNewMovieLog;
import com.example.splashscreen.R;
import com.example.splashscreen.utility.MoviesLogRecycleView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieLog extends Fragment {
    private View rootView;

    private ImageView new_movieIcon;
    private MoviesLogRecycleView moviesLogRecycleView;
    private ArrayList<MoviesDetails> moviesDetails = new ArrayList<>();

    public MovieLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_movie_log, container, false);


        new_movieIcon = rootView.findViewById(R.id.add_new_movie);

        new_movieIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), CreateNewMovieLog.class);
                startActivity(i);
            }
        });
        moviesDetails.add(new MoviesDetails("Focus"));
        moviesDetails.add(new MoviesDetails("Captin Fantastic"));
        moviesDetails.add(new MoviesDetails("The switch"));

        setNew_movieRecycleView();
        return rootView;
    }
    private void setNew_movieRecycleView() {
        RecyclerView recyclerView = rootView.findViewById(R.id.movie_title_view);
        moviesLogRecycleView = new MoviesLogRecycleView(getActivity(), moviesDetails);
        recyclerView.setAdapter(moviesLogRecycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }
}
