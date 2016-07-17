package tomerbu.edu.recyclerweb.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {

    public static String getString(InputStream in) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            StringBuilder builder = new StringBuilder();


            String line = reader.readLine();

            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }

            return builder.toString();
        }
        finally {
            reader.close();
        }
    }
}
