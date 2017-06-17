package info.hindiusa.hindiusaapp;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ishanarya on 11/23/16.
 */

public class ServerHandling {

    private String url;
    private List<Entry> entries = new ArrayList<>();

    public ServerHandling(String url) throws IOException, JSONException {
        this.url = url;
        readJsonFromUrl();
    }

    private void readJsonFromUrl() throws IOException, JSONException {
        URL theURL = new URL(this.url);
        Log.d(ServerHandling.class.getSimpleName(), this.url);
        BufferedReader rd = new BufferedReader(new InputStreamReader(theURL.openStream()));
        String jsonText = readAll(rd);
        entries = Arrays.asList(new Gson().fromJson(jsonText, Entry[].class));
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public List<Entry> getEntries() {
        return entries;
    }
}
