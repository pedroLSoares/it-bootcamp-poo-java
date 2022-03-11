package Exceptions;

import java.io.Closeable;
import java.io.IOException;

public class ExampleRepository implements Closeable {

    public void save(){
        throw new CustomException("Error during save");
    }
    @Override
    public void close() throws IOException {
        System.out.println("Closing DB");
    }
}
