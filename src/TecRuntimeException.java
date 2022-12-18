package tec;

public class TecRuntimeException extends RuntimeException{
    // instanciate with an error message
    public TecRuntimeException(String errorMessage){
        super(errorMessage);
    }

    // instanciate with an other exception
    public TecRuntimeException(RuntimeException exception){
        super(exception);
    }
}
