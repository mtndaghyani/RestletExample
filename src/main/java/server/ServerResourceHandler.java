package server;

import client.Person;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;

public class ServerResourceHandler extends ServerResource {

    /*
        This method reads a query key from the request and return
        a "Hello NAME!" response to the client.
     */

    @Get
    public String read(){
        String name = getQueryValue("name");
        return "Hello " + name + " !" + "\n";
    }
    /*
        This method shows that we can pass a List of Serializable
        objects and return it to the client as a response.
     */

    @Put
    public ArrayList<Person> Update(ArrayList<Person> people) {
        return people;
    }


}
