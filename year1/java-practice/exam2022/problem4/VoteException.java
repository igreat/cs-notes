package exam2022.problem4;

public class VoteException extends Exception {
    // should have another constructor that takes a message
    public VoteException() {
        super("Not a valid option name");
    }
}
