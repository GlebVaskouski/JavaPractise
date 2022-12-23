import books.BookShelf;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;

public class JsonSerialization  {
    public static void main(String[] args) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        BookShelf books = objectMapper.readValue(new File("js.json"), BookShelf.class);
        books.outShelf();

    }
}
