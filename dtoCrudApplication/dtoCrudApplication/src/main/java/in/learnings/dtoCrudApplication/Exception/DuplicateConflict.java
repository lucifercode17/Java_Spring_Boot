package in.learnings.dtoCrudApplication.Exception;

public class DuplicateConflict extends RuntimeException{
    public DuplicateConflict(String message){
        super(message);
    }

}
