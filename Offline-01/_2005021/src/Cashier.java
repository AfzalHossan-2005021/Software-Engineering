public class Cashier extends Employee{
    public Cashier(String name, Bank bank){
        super(name, bank);
    }

    @Override
    public void lookUp(String accountName) {
        this.getBank().lookUpAccount(accountName);
    }

    @Override
    public void approveLoan() {
        System.out.println("You don’t have permission for this operation");
    }

    @Override
    public void changeInterestRate(String accountType, double newRate) {
        System.out.println("You don’t have permission for this operation");
    }

    @Override
    public void seeInternalFund() {
        System.out.println("You don’t have permission for this operation");
    }
}
