package info.hindiusa.hindiusaapp;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;

public class GetArrayAsyncTask extends AsyncTask<Void, Void, ServerHandling> {
    CustomListAdapter customListAdapter;

    public GetArrayAsyncTask(CustomListAdapter customListAdapter) {
        this.customListAdapter = customListAdapter;
    }


    @Override
    protected ServerHandling doInBackground(Void... voids) {
        try {
            return new ServerHandling("https://hindiusa-app.herokuapp.com/array");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ServerHandling serverHandling) {
        if (serverHandling != null) {
            customListAdapter.getEntries().clear();
            customListAdapter.getEntries().addAll(serverHandling.getEntries());
            customListAdapter.notifyDataSetChanged();
        }
    }
}
