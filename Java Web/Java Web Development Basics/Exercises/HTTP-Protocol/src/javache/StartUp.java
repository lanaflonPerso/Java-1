package javache;

import java.io.IOException;

public class StartUp {
    private static final int PORT = 5000;
    public static void main(String[] args) throws IOException {
        Server server = new Server(PORT);

        server.run();
    }
}
