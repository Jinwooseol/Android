package com.example.ch13_asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = findViewById(R.id.progress_bar);

        ProgressTask task = new ProgressTask();
        task.execute("");

    }

    private class ProgressTask extends AsyncTask<String, Integer, Boolean> {

        private int mProgressStatus = 0;
        int i = 0;

        @Override
        protected Boolean doInBackground(String... params) {
            while (isCancelled() == false) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                mProgressStatus = i++;
                publishProgress(mProgressStatus);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... progressStatus) {
            super.onProgressUpdate(progressStatus);
            mProgress.setProgress(progressStatus[0]);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgress.setMax(100);
            mProgress.setProgress(0);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            mProgress.setProgress(0);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            mProgress.setProgress(0);
        }
    }

}