package tec;

public class TecException extends Exception{
    // instanciate with an error message
    public TecException(String errorMessage){
        super(errorMessage);
    }

    // instanciate with an other exception
    public TecException(Exception exception){
        super(exception);
    }
}
