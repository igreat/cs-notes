package exam2012.problem3;

public class VoteException extends Exception {
    public VoteException(String message) {
        super(message);
    }

    public VoteException() {
        super("Not a valid voting option");
    }
}