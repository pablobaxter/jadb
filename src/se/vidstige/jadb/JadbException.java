package se.vidstige.jadb;

public class JadbException extends Exception {

    public JadbException(Throwable throwable) {
        super(throwable);
    }

    public JadbException(String message) {
        super(message);
    }

    private static final long serialVersionUID = -3879283786835654165L;
}
