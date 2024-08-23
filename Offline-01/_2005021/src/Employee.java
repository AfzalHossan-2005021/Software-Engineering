abstract public class Employee extends User {
    private final Bank bank;
    public Employee(String name, Bank bank){
        super(name);
        this.bank = bank;
    }
    public Bank getBank() {
        return bank;
    }
    abstract void lookUp(String accountName);
    abstract void approveLoan();
    abstract void changeInterestRate(String accountType, double newRate);
    abstract void seeInternalFund();
}
