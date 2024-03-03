package util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.net.URL;

/*
 * Need to work on!!!!
 */
public class InputReader {
    public static List<String> readInputByLine(String filePath, Class<?> callingClass){
        URL resource = callingClass.getClassLoader().getResource(filePath); //Was hat es mit der calling class auf sich?

        URI uri = null;
        try {
            assert resource != null; //Was ist assert? Was ist URI?
            uri = resource.toURI();

            Path path = Path.of(uri);
            return Files.lines(path).collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
