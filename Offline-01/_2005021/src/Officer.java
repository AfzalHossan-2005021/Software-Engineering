public class Officer extends Cashier{
    public Officer(String name, Bank bank){
        super(name, bank);
    }

    @Override
    public void approveLoan() {
        this.getBank().approveAllLoan();
    }
}
