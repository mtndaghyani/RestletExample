package server;

import client.Person;
import org.restlet.resource.Get;

public interface ResourceInterface {
    @Get
    public Person read();
}
