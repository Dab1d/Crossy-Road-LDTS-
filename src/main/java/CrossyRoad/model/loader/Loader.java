package CrossyRoad.model.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    private final List<String> lines;

    public Loader(String filename) throws IOException {

        URL resource = Loader.class.getResource("/loadscreen/" + filename);
        if (resource == null) {
            throw new IOException("Ficheiro loadscreen.txt não encontrado!");
        }

        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        lines = readLines(br);
        br.close();
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    public List<String> getLines() {
        return lines;
    }

    public static List<String> loadBackground(String filename) throws IOException {
        return new Loader(filename).getLines();
    }
}
