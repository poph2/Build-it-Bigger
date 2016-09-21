package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.pop.builditbigger.jokegce.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Pop H2 on 9/13/2016.
 * Pop Inc
 * Lagos Nigeria
 */
public class JokeGetter {
    private JokeGetterListener jokeGetterListener;

    public JokeGetter(JokeGetterListener jokeGetterListener) {
        this.jokeGetterListener = jokeGetterListener;
    }

    public interface JokeGetterListener {
        void jokeGotten(String joke);
    }

    public EndpointsAsyncTask fetchJoke(Integer index) {
        EndpointsAsyncTask jokeTask = new EndpointsAsyncTask();
        jokeTask.execute(index);
        return jokeTask;
    }

    public class EndpointsAsyncTask extends AsyncTask<Integer, Void, String> {
        private MyApi myApi = null;
        private Integer index;

        @Override
        protected String doInBackground(Integer... params) {
            if (myApi == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("https://build-it-bigger-144100.appspot.com/_ah/api/");
                // end options for devappserver

                myApi = builder.build();
            }

            index = params[0];

            try {
                return myApi.getJoke(index).execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            jokeGetterListener.jokeGotten(result);
        }
    }
}