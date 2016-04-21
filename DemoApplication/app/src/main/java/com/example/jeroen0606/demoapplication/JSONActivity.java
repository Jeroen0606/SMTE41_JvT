package com.example.jeroen0606.demoapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        new AsyncTaskParseJson().execute();
    }

    public class AsyncTaskParseJson extends AsyncTask<String, String, String> {

        final String TAG = "AsyncTaskParseJson.java";

        String url = "https://api.myjson.com/bins/2a5oa";

        JSONArray array = new JSONArray();

        @Override
        protected void onPreExecute() {}

        @Override
        protected String doInBackground(String... arg0) {

            try {

                JsonParser jParser = new JsonParser();
                JSONObject json = jParser.getJSONFromUrl(url);
                array = json.getJSONArray("emergencies");
                for (int i = 0; i < array.length(); i++) {

                    JSONObject c = array.getJSONObject(i);

                    String titel = c.getString("titel");
                    String date = c.getString("date");
                    String description = c.getString("description");

                    Log.e(TAG, "titel: " + titel
                            + ", date: " + date
                            + ", description: " + description);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String strFromDoInBg) {}
    }
}
