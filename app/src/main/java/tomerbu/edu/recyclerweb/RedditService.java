package tomerbu.edu.recyclerweb;

import android.os.AsyncTask;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Locale;

import tomerbu.edu.recyclerweb.models.Reddit;
import tomerbu.edu.recyclerweb.models.RedditParser;
import tomerbu.edu.recyclerweb.utils.IOUtils;

/**
 * Usage Example from MainActivity:
 *
   RedditService service = new RedditService(tvJson);
   service.execute();
 */

public class RedditService extends AsyncTask<String, Integer, ArrayList<Reddit>> {

    private final RecyclerView rvReddits;
    private final ProgressBar progressBar;

    public RedditService(RecyclerView rvReddits, ProgressBar progressBar) {
        this.rvReddits = rvReddits;
        this.progressBar = progressBar;
    }

    @Override
    protected ArrayList<Reddit> doInBackground(String... params) {
        try {
            URL url = new URL("https://www.reddit.com/.json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

            InputStream in = con.getInputStream();
            String data = IOUtils.getString(in);

            ArrayList<Reddit> reddits = RedditParser.parse(data);

            return reddits;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Reddit> reddits) {
        progressBar.setVisibility(View.GONE);
        rvReddits.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvReddits.setAdapter(new RedditAdapter(rvReddits.getContext(), reddits));
    }
}
