/**
 * creation de cette classe pour differencier de illegalArgument exception
 */
public class NoteInexistantException extends RuntimeException {
    public NoteInexistantException(String message) {
        super(message);
    }
}
