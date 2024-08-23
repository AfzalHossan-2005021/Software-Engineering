public class ManagingDirector extends Officer{
    public ManagingDirector(String name, Bank bank){
        super(name, bank);
    }

    @Override
    public void changeInterestRate(String accountType, double newRate) {
        this.getBank().changeAccountInterestRate(accountType, newRate);
    }

    @Override
    public void seeInternalFund() {
        double internalFund = this.getBank().getInternalFund();
        System.out.println("Internal Fund " + internalFund + "$");
    }
}
