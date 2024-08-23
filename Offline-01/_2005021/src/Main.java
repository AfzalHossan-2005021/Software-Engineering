import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(1000000, 2, 5);
        BankingSystem bankingSystem = new BankingSystem();
        for (Employee employee : bank.getEmployees().values()){
            bankingSystem.addUser(employee);
        }

        Scanner scanner = new Scanner(System.in);
        String operation;
        while(!(operation = scanner.nextLine()).equalsIgnoreCase("Exit")){
            String[] tokens = operation.split(" ");
            try {
                switch (bankingSystem.getActiveUser()) {
                    case null -> {
                        if (tokens[0].equalsIgnoreCase("Create")) {
                            String name = tokens[1];
                            String accountType = tokens[2];
                            try {
                                double initialDeposit = Double.parseDouble(tokens[3]);
                                User user = bankingSystem.findUser(name);
                                if(user == null){
                                    bank.createAccount(name, accountType, initialDeposit);
                                    user = bank.findAccount(name);
                                    if(user != null)  {
                                        bankingSystem.addUser(user);
                                        bankingSystem.setActiveUser(user);
                                    }
                                } else {
                                    System.out.println("An user already exists with this name");
                                }
                            } catch (NumberFormatException exception) {
                                exception.printStackTrace(System.out);
                            }
                        } else if (tokens[0].equalsIgnoreCase("Open")) {
                            String name = tokens[1];
                            User user = bankingSystem.findUser(name);
                            if (user instanceof Employee employee) {
                                bankingSystem.setActiveUser(user);
                                System.out.print(user.getName() + " active");
                                if (bank.hasLoanRequest() && employee instanceof Officer) {
                                    System.out.print(", there are loan approvals pending");
                                }
                                System.out.println();
                            } else if (user instanceof Account) {
                                bankingSystem.setActiveUser(user);
                                System.out.println("Welcome back, " + user.getName());
                            } else {
                                System.out.println("No user found");
                            }
                        } else if (tokens[0].equalsIgnoreCase("INC")) {
                            bank.reflectYearIncrement();
                            System.out.println("1 year passed");
                        }else {
                            System.out.println("No user is active");
                        }
                    }
                    case Account account -> {
                        try {
                            if (tokens[0].equalsIgnoreCase("Deposit")) {
                                double depositAmount = Double.parseDouble(tokens[1]);
                                account.deposit(depositAmount);
                            } else if (tokens[0].equalsIgnoreCase("Withdraw")) {
                                double withdrawalAmount = Double.parseDouble(tokens[1]);
                                account.withdraw(withdrawalAmount);
                            } else if (tokens[0].equalsIgnoreCase("Request")) {
                                double loanAmount = Double.parseDouble(tokens[1]);
                                account.requestLoan(loanAmount);
                            } else if (tokens[0].equalsIgnoreCase("Query")) {
                                account.queryDeposit();
                            } else if (tokens[0].equalsIgnoreCase("Close")) {
                                String name = account.getName();
                                bankingSystem.setActiveUser(null);
                                System.out.println("Transaction Closed for " + name);
                            }else {
                                System.out.println("Invalid operation for active account.");
                            }
                        } catch (NumberFormatException exception) {
                            exception.printStackTrace(System.out);
                        }
                    }
                    case Employee employee -> {
                        try {
                            if (tokens[0].equalsIgnoreCase("Lookup")) {
                                String name = tokens[1];
                                employee.lookUp(name);
                            } else if (tokens[0].equalsIgnoreCase("Approve")) {
                                employee.approveLoan();
                            } else if (tokens[0].equalsIgnoreCase("Change")) {
                                String accountType = tokens[1];
                                double newRate = Double.parseDouble(tokens[2]) / 100;
                                employee.changeInterestRate(accountType, newRate);
                            } else if (tokens[0].equalsIgnoreCase("See")) {
                                employee.seeInternalFund();
                            } else if (tokens[0].equalsIgnoreCase("Close")) {
                                String name = employee.getName();
                                bankingSystem.setActiveUser(null);
                                System.out.println("Operation Closed for " + name);
                            }else {
                                System.out.println("Invalid operation for active employee.");
                            }
                        } catch (NumberFormatException exception) {
                            exception.printStackTrace(System.out);
                        }
                    }
                    default -> System.out.println("Invalid operation.");
                }
            } catch (Exception exception) {
                exception.printStackTrace(System.out);
            }
        }
    }
}
