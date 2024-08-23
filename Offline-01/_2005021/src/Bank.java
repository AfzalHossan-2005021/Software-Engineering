import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private final double initialFund;
    private double profit = 0;
    private final HashMap<String, Account> accounts;
    private final HashMap<String, Employee> employees;
    private final ArrayList<LoanRequest> loanRequests;

    public Bank(double initialFund, int officerCount, int cashierCount){
        this.initialFund = initialFund;
        this.accounts = new HashMap<>();
        this.employees = new HashMap<>();
        this.loanRequests = new ArrayList<>();
        System.out.print("Bank Created; ");

        createEmployee("ManagingDirector", "MD");
        System.out.print("MD");

        for (int i = 1; i <= officerCount; i++){
            String name = "S" + i;
            createEmployee("Officer", name);
            System.out.print(", " + name);
        }
        for (int i = 1; i <= cashierCount; i++){
            String name = "C" + i;
            createEmployee("Cashier", name);
            System.out.print(", " + name);
        }
        System.out.println(" created.");
    }

    public void createEmployee(String employeeType, String name){
        if(employeeType.equalsIgnoreCase("ManagingDirector")) {
            employees.put(name, new ManagingDirector(name, this));
        } else if (employeeType.equalsIgnoreCase("Officer")) {
            employees.put(name, new Officer(name, this));
        } else if (employeeType.equalsIgnoreCase("Cashier")) {
            employees.put(name, new Cashier(name, this));
        }else {
            System.out.println("No such account type");
        }
    }

    public void createAccount(String name, String type, double initialDeposit){
        if(type.equalsIgnoreCase("Savings")) {
            if (initialDeposit >= Savings.getMinInitialDeposit()) {
                accounts.put(name, new Savings(this, name, initialDeposit));
            } else {
                System.out.println("Insufficient initial deposit for creating Savings account");
            }
        } else if (type.equalsIgnoreCase("Student")) {
            if (initialDeposit >= Student.getMinInitialDeposit()) {
                accounts.put(name, new Student(this, name, initialDeposit));
            }else {
                System.out.println("Insufficient initial deposit for creating Student account");
            }
        } else if (type.equalsIgnoreCase("Fixed")) {
            if(initialDeposit >= FixedDeposit.getMinInitialDeposit()) {
                accounts.put(name, new FixedDeposit(this, name, initialDeposit));
            }else {
                System.out.println("Insufficient initial deposit for creating Fixed Deposit");
            }
        }else {
            System.out.println("No such account type");
        }
    }

    public void reflectYearIncrement(){
        for(Account account: accounts.values()){
            processInterestOnDeposit(account);
            processInterestOnLoan(account);
            processServiceCharge(account);
            if(account instanceof FixedDeposit){
                ((FixedDeposit) account).setMature(true);
            }
        }
    }

    private void processInterestOnDeposit(Account account){
        double interest = account.getInterestOnDeposit();
        account.setBalance(account.getBalance() + interest);
        increaseProfit(-interest);
    }

    private void processInterestOnLoan(Account account){
        double interest = account.getInterestOnLoan();
        account.setBalance(account.getBalance() - interest);
        increaseProfit(interest);
    }

    private void processServiceCharge(Account account){
        double serviceCharge = account.getServiceCharge();
        account.setBalance(account.getBalance() - serviceCharge);
        increaseProfit(serviceCharge);
    }

    public void changeAccountInterestRate(String accountType, double newRate){
        if(accountType.equalsIgnoreCase("Savings")) {
            Savings.setDepositInterestRate(newRate);
            System.out.println("Interest rate for Savings accounts is changed to " + newRate*100);
        } else if (accountType.equalsIgnoreCase("Student")) {
            Student.setDepositInterestRate(newRate);
            System.out.println("Interest rate for Student accounts is changed to " + newRate*100);
        } else if (accountType.equalsIgnoreCase("Fixed")) {
            FixedDeposit.setDepositInterestRate(newRate);
            System.out.println("Interest rate for Fixed Deposits is changed to " + newRate*100);
        }else {
            System.out.println("No such account type");
        }
    }

    public double getTotalDeposit(){
        double totalDeposit = 0;
        for (Account account : accounts.values()){
            totalDeposit += account.getBalance();
        }
        return totalDeposit;
    }

    public double getTotalLoan(){
        double totalLoan = 0;
        for (Account account : accounts.values()){
            totalLoan += account.getLoan();
        }
        return totalLoan;
    }

    public void approveAllLoan(){
        System.out.print("Loan for ");
        for (LoanRequest loanRequest : loanRequests){
            loanRequest.approve();
            System.out.print(loanRequest.getRequesterName() + " ");
        }
        loanRequests.clear();
        System.out.println("approved.");
    }

    public double getInternalFund(){
        double totalDeposit = this.getTotalDeposit();
        double totalLoan = this.getTotalLoan();
        return this.initialFund + this.profit + totalDeposit - totalLoan;
    }

    public void lookUpAccount(String accountName){
        Account account = accounts.get(accountName);
        if(account == null){
            System.out.println("No such account.");
        } else {
            System.out.println(account.getName() + "’s current balance " + account.getBalance() + "$");
        }
    }

    public void increaseProfit(double newProfit){
        this.profit += newProfit;
    }

    public void receiveLoanRequest(LoanRequest newLoanRequest){
        this.loanRequests.add(newLoanRequest);
    }

    public boolean hasLoanRequest(){
        return !loanRequests.isEmpty();
    }

    public HashMap<String, Employee> getEmployees() {
        return employees;
    }

    public Account findAccount(String accountName){
        return accounts.get(accountName);
    }
}