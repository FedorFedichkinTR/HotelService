package connection_pool;


public class ConnectionPoolException extends RuntimeException{
    ConnectionPoolException(String message, Exception e) {
        super(message, e);
    }
}
