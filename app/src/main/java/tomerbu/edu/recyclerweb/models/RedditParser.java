package tomerbu.edu.recyclerweb.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class RedditParser {
    public static ArrayList<Reddit> parse(String json) throws JSONException {
        ArrayList<Reddit> reddits = new ArrayList<>();

        JSONArray children = new JSONObject(json).getJSONObject("data").getJSONArray("children");

        for (int i = 0; i < children.length(); i++) {
            JSONObject childObject = children.getJSONObject(i);
            JSONObject childData = childObject.getJSONObject("data");

            String url = childData.getString("url");
            String title = childData.getString("title");
            String thumbnail = childData.getString("thumbnail");

            reddits.add(new Reddit(title, thumbnail, url));
        }
        return reddits;
    }
}
