package server;

import client.Person;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ThirdServerResourceHandler extends ServerResource implements ResourceInterface {

    @Override
    @Get
    public Person read() {
        return new Person("ali", 20);
    }
}