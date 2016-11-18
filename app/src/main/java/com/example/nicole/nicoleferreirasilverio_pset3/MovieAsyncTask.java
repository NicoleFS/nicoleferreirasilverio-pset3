package com.example.nicole.nicoleferreirasilverio_pset3;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Nicole on 18-11-2016.
 */

public class MovieAsyncTask extends AsyncTask<String, Integer, String> {

    Context context;
    MainActivity activity;

    // constructor
    public MovieAsyncTask(MainActivity activity){
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }

    // onPreExecute()
    @Override
    protected void onPreExecute(){
        Toast.makeText(context, "Getting data from server", Toast.LENGTH_LONG).show();
    }

    // doInBackGround()
    @Override
    protected String doInBackground(String... params){
        return HttpRequestHelper.downloadFromServer(params);
    }

    // onProgressUpdate()

    // onPostExecute()
    protected void onPostExecute(String result){
        super.onPostExecute(result);

        // checken of result uberhaupt iets heeft binnengekregen
        if (result.length() == 0){
            Toast.makeText(context, "No data found", Toast.LENGTH_LONG).show();
        }
        else{
            ArrayList<MovieData> moviedata = new ArrayList<>();
            try {
                JSONObject respObj = new JSONObject(result);
                JSONObject searchedMovieObj = respObj.getJSONObject("movies");
                JSONArray movies = searchedMovieObj.getJSONArray("movie");

                for (int i = 0; i < movies.length(); i++){
                    JSONObject movie = movies.getJSONObject(i);
                    String movietitle = movie.getString("title");
                    String movieyear = movie.getString("year");
                    String movieposter = movie.getString("imageURL");

                    // JSONObject artistObj = track.getJSONObject(“artist”);
                    // String artistName = artistObj.getString(“name”);
                    moviedata.add(new MovieData(movietitle, movieyear, movieposter));
                }
            } catch (JSONException e){
                e.printStackTrace();
            }
            activity.setData(moviedata);
        }
    }
}
