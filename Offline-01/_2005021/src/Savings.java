public class Savings extends Account{
    private static final double MIN_INITIAL_DEPOSIT;
    private static final double MIN_DEPOSIT;
    private static final double MAX_WITHDRAW;
    private static final double MAX_LOAN;
    private static final double MIN_BALANCE;
    private static double DEPOSIT_INTEREST_RATE;
    private static final double LOAN_INTEREST_RATE;
    private static final double SERVICE_CHARGE;
    public Savings(Bank bank, String name, double initialBalance){
        super(bank, name, initialBalance);
        System.out.println("Savings account for " + name + " Created; initial balance " + initialBalance + "$");
    }

    static {
        MIN_INITIAL_DEPOSIT = 0;
        MIN_DEPOSIT = 1;
        MAX_WITHDRAW = Double.MAX_VALUE;
        MAX_LOAN = 10000;
        MIN_BALANCE = 1000;
        DEPOSIT_INTEREST_RATE = 0.1;
        LOAN_INTEREST_RATE = 0.1;
        SERVICE_CHARGE = 500;
    }

    @Override
    public double getInterestOnDeposit() {
        return getBalance() * DEPOSIT_INTEREST_RATE;
    }

    @Override
    public double getInterestOnLoan() {
        return getLoan() * LOAN_INTEREST_RATE;
    }

    @Override
    public double getServiceCharge() {
        return SERVICE_CHARGE;
    }

    @Override
    void deposit(double depositAmount) {
        depositUtil(MIN_DEPOSIT, depositAmount);
    }

    @Override
    void withdraw(double withdrawalAmount) {
        withdrawUtil(true, MAX_WITHDRAW, MIN_BALANCE, withdrawalAmount);
    }

    @Override
    void requestLoan(double loanAmount) {
        requestLoanUtil(MAX_LOAN, loanAmount);
    }

    public static void setDepositInterestRate(double depositInterestRate) {
        DEPOSIT_INTEREST_RATE = depositInterestRate;
    }

    public static double getMinInitialDeposit(){
        return MIN_INITIAL_DEPOSIT;
    }
}