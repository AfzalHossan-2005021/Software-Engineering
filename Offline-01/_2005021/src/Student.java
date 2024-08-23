public class Student extends Account{
    private static final double MIN_INITIAL_DEPOSIT;
    private static final double MIN_DEPOSIT;
    private static final double MAX_WITHDRAW;
    private static final double MAX_LOAN;
    private static final double MIN_BALANCE;
    private static double DEPOSIT_INTEREST_RATE;
    private static final double LOAN_INTEREST_RATE;
    private static final double SERVICE_CHARGE;
    public Student(Bank bank, String name, double initialBalance){
        super(bank, name, initialBalance);
        System.out.println("Student account for " + name + " Created; initial balance " + initialBalance + "$");
    }

    static {
        MIN_INITIAL_DEPOSIT = 0;
        MIN_DEPOSIT = 1;
        MAX_WITHDRAW = 10000;
        MAX_LOAN = 1000;
        MIN_BALANCE = 0;
        DEPOSIT_INTEREST_RATE = 0.05;
        LOAN_INTEREST_RATE = 0.1;
        SERVICE_CHARGE = 0;
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