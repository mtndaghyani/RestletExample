package server;

import com.gilecode.yagson.YaGson;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileServerResource extends ServerResource {
    @Post
    public void getFile(String entity) throws IOException {
        byte[] bytes = new YaGson().fromJson(entity, byte[].class);
        //Add an arbitrary destination path
        String destinationPath = "";
        File file = new File(destinationPath);
        if (!file.exists())
            if(!file.createNewFile())
                throw new IOException("File creation failed.");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
    }
}
