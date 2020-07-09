package server;

import client.Person;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class SecondServerResourceHandler extends ServerResource implements ResourceInterface {

    /*
        Return a sample Person object.
        Note that Person implements Serializable and has a dummy constructor.
     */
    @Get
    public Person read(){
        return new Person("matin", 12);
    }

}
