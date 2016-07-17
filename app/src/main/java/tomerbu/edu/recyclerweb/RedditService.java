package tomerbu.edu.recyclerweb;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import tomerbu.edu.recyclerweb.utils.IOUtils;

/**
 * Usage Example from MainActivity:
 *
   RedditService service = new RedditService(tvJson);
   service.execute();
 */

public class RedditService extends AsyncTask {

    private TextView tvJson;
    public RedditService(TextView tvJson) {
        this.tvJson = tvJson;
    }


    @Override
    protected Object doInBackground(Object[] params) {
        try {
            URL url = new URL("https://www.reddit.com/.json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

            InputStream in = con.getInputStream();
            String data = IOUtils.getString(in);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        if (o != null) {
            String data = (String) o;
            tvJson.setText(data);
        }
    }
}
