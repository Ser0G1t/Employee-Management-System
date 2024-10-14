package CRM.exceptionHandling;

public class EntityNotFoundException extends RuntimeException{
    private String message;
    public EntityNotFoundException(String message) {

    }
}
