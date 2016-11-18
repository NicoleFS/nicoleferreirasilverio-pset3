package com.example.nicole.nicoleferreirasilverio_pset3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchForMovie (View view){
        EditText movie_input = (EditText) findViewById(R.id.editText3);
        String searchinput = movie_input.getText().toString();
        MovieAsyncTask asyncTask = new MovieAsyncTask(this);
        asyncTask.execute(searchinput);
    }

    public void setData(ArrayList<MovieData> moviedata) {
//        MovieAdapter movieadapter = new MovieAdapter();
//        ArrayList<MovieData> resultmovies = new ArrayList<>();
//        resultmovies = moviedata;

//        ListView moviesFound = (ListView) findViewById(R.id.movieresult);
//        moviesFound.setAdapter((ListAdapter) movieadapter);

//        MovieAdapter adapter = new MovieAdapter(this);
//        ListView moviesFound = (ListView) findViewById(R.id.movieresult);
//        moviesFound.setAdapter(adapter);

        // onclicklistener toevoegen? 7.00 in filmpje


    }


}
