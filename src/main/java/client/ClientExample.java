package client;

import com.gilecode.yagson.YaGson;
import org.restlet.resource.ClientResource;
import server.ResourceInterface;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ClientExample {
    public static void main(String[] args) throws IOException {
        /*
            Create a new client resource object and send a request
            to ServerResourceHandler server resource.
         */
        System.out.println("Sending a GET request for a single person: ");
        ClientResource clientResource1 = new ClientResource("http://localhost:8080/first/");
        clientResource1.setQueryValue("name", "matin");
        clientResource1.get().write(System.out);

        System.out.println("Sending a GET request for a list of people:");
        ArrayList<Person> people= new ArrayList<>();
        people.add(new Person("farid", 12));
        clientResource1.put(people).write(System.out);

        /*
            ResourceInterface makes it possible to call server resources methods directly
            as is shown here.
         */
        System.out.println("\n" + "-------------------------------------------" + "\n");
        ClientResource clientResource2 = new ClientResource("http://localhost:8080/second/");
        ResourceInterface resourceInterface = clientResource2.wrap(ResourceInterface.class);
        Person response = resourceInterface.read();
        System.out.println(response);

        System.out.println("\n" + "-------------------------------------------" + "\n");
        ClientResource clientResource3 = new ClientResource("http://localhost:8080/third/");
        ResourceInterface resourceInterface1 = clientResource3.wrap(ResourceInterface.class);
        Person response1 = resourceInterface1.read();
        System.out.println(response1);

        /*
            Send a file to the server using YaGson
         */
        System.out.println("\n" + "-------------------------------------------" + "\n");
        ClientResource clientResource4 = new ClientResource("http://localhost:8080/file/");

        //Add an existing file path
        String path = "";
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] bytes = fileInputStream.readAllBytes();
        YaGson mapper = new YaGson();
        String entity = mapper.toJson(bytes, byte[].class);
        clientResource4.post(entity);
    }
}
