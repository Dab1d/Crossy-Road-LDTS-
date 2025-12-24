package CrossyRoad.model.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    private final List<String> lines;

    public Loader(String filename) throws IOException {

        InputStream is = getClass().getResourceAsStream("/loadscreen/" + filename);
        if (is == null) {
            throw new IOException("Ficheiro não encontrado: /loadscreen/" + filename);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            lines = readLines(br);
        }
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    public List<String> getLines() {
        return lines;
    }

}