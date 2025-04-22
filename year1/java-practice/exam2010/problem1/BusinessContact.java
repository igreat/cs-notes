package exam2010.problem1;

public class BusinessContact extends Contact {
    private int accountNo;

    public BusinessContact(String name, Information info, int accountNo) {
        super(name, info);
        this.accountNo = accountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }
}