package controllers.ws;

public class ControllerWs {

    private static final String PROTOCOL = "http";

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    private static final String WEB = "/TicTacToe/rest";

    private static final String URI = PROTOCOL + "://" + HOST + ":" + PORT + WEB;

    public static String getUri() {
        return URI;
    }
}
