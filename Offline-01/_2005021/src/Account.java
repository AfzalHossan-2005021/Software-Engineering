abstract public class Account extends User {
    private final Bank bank;
    private double balance;
    private double loan;
    public Account(Bank bank, String name, double initialBalance){
        super(name);
        this.bank = bank;
        this.balance = initialBalance;
        this.loan = 0;
    }

    abstract double getInterestOnDeposit();
    abstract double getInterestOnLoan();
    abstract double getServiceCharge();
    abstract void deposit(double depositAmount);
    abstract void withdraw(double withdrawalAmount);
    abstract void requestLoan(double loanAmount);

    public void queryDeposit(){
        System.out.print("Current balance " + this.balance + "$");
        if(loan > 0){
            System.out.print(", loan " + loan + "$");
        }
        System.out.println();
    }

    protected void depositUtil(double minAmount, double depositAmount){
        if (depositAmount < minAmount){
            System.out.print("Invalid transaction; ");
            System.out.println("Deposit amount must be at least " + minAmount + "$");
        }
        else {
            this.balance += depositAmount;
            System.out.print(depositAmount + "$ deposited; ");
            System.out.println("current balance " + this.balance + "$");
        }
    }

    protected void withdrawUtil(boolean isMature, double maxWithdraw, double minBalance, double withdrawalAmount){
        if(!isMature){
            System.out.print("Invalid transaction; ");
            System.out.println("Your deposit in no mature");
        }
        else if(withdrawalAmount > maxWithdraw){
            System.out.print("Invalid transaction; ");
            System.out.println("Your cannot withdraw more than " + maxWithdraw + "$ in one transaction");
        }
        else if(this.balance - withdrawalAmount < minBalance){
            System.out.print("Invalid transaction; ");
            System.out.print("Withdrawal result must be at least " + minBalance + "$; ");
            System.out.println("current balance " + this.balance + "$");
        }
        else {
            this.balance -= withdrawalAmount;
            System.out.print(withdrawalAmount + "$ withdrawn; ");
            System.out.println("current balance " + this.balance + "$");
        }
    }

    protected void requestLoanUtil(double maxLoan, double loanAmount){
        if(loanAmount > maxLoan){
            System.out.print("Invalid request; ");
            System.out.println("Your maximum allowable loan " + maxLoan + "$");
        }
        else {
            LoanRequest newLoanRequest = new LoanRequest(this, loanAmount);
            getBank().receiveLoanRequest(newLoanRequest);
            System.out.println("Loan request successful, sent for approval");
        }
    }

    public void reflectLoanApproval(LoanRequest loanRequest) {
        if(loanRequest.isApproved()){
            double newLoan = loanRequest.getLoanAmount();
            this.loan += newLoan;
            this.balance += newLoan;
        }
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLoan() {
        return loan;
    }
}
