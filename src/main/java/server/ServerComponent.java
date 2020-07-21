package server;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class ServerComponent extends Component {
    public static void main(String[] args) throws Exception {
        new ServerComponent().start();
    }

    public ServerComponent() {
        getServers().add(Protocol.HTTP, 8080);
        getDefaultHost().attach("/first/", ServerResourceHandler.class);
        getDefaultHost().attach("/second/", SecondServerResourceHandler.class);
        getDefaultHost().attach("/third/", ThirdServerResourceHandler.class);
        getDefaultHost().attach("/file/", FileServerResource.class);
    }

}
