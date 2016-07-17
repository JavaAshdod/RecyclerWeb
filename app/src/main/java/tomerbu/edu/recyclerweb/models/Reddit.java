package tomerbu.edu.recyclerweb.models;

/**
 * Created by stud27 on 17/07/16.
 */
public class Reddit {
    private String title;
    private String thumbnail;
    private String url;

    public Reddit(String title, String thumbnail, String url) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Reddit{" +
                "title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
