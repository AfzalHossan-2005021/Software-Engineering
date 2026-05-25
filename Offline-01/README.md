# Offline-01: Banking Management System

Offline-01 is a console-based banking simulator implemented in plain Java. It models customer accounts, bank employees, loan processing, and year-end financial updates using an object-oriented design with role-based access control.

## Highlights

- Create `Savings`, `Student`, and `Fixed Deposit` accounts.
- Support account-holder operations for deposit, withdrawal, loan requests, and balance queries.
- Support employee operations for account lookup, loan approval, interest-rate changes, and internal-fund inspection.
- Process yearly interest, loan interest, service charges, and fixed-deposit maturity with `INC`.
- Provide sample input and output files for quick verification.

## Design Overview

- `Bank` owns the account registry, employee registry, pending loan requests, and yearly fund calculation.
- `BankingSystem` tracks the currently active user session.
- `Account` and `Employee` define the shared contract for concrete account and staff types.
- `LoanRequest` encapsulates the approval flow and updates the requester when approved.

## UML Diagram

The class diagram documents the object relationships and responsibilities in the system.

- [UML Class Diagram](UML%20Class%20Diagram.pdf)

## Command Reference

### No user is active

- `Create <name> <Savings|Student|Fixed> <initialDeposit>`
- `Open <name>`
- `INC`
- `Exit`

### Active account

- `Deposit <amount>`
- `Withdraw <amount>`
- `Request <amount>`
- `Query`
- `Close`

### Active employee

- `Lookup <accountName>`
- `Approve`
- `Change <Savings|Student|Fixed> <newRatePercent>`
- `See`
- `Close`

## Account Rules

| Account | Key Rules |
| --- | --- |
| Savings | Minimum deposit: 1; maximum loan: 10000; minimum balance: 1000; yearly service charge: 500 |
| Student | Minimum deposit: 1; maximum withdrawal: 10000; maximum loan: 1000; minimum balance: 0; yearly service charge: 0 |
| Fixed Deposit | Minimum initial deposit: 100000; minimum deposit: 50000; maximum loan: 100000; withdrawals allowed only after maturity; yearly service charge: 500 |

`INC` applies deposit interest, loan interest, service charges, and marks fixed deposits as mature.

## Build and Run

The project has no external dependencies. A modern JDK is required; Java 21 or newer is recommended because the main command loop uses pattern matching in `switch`.

From `Offline-01/_2005021/src` in PowerShell:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out *.java
java -cp out Main
```

To run the included sample scenario:

```powershell
java -cp out Main < ..\..\input.txt
```

Compare the result with `..\..\output.txt`.

## Project Notes

- The application starts with an initial bank fund of 1,000,000.
- Default employees are `MD`, `S1`, `S2`, `C1`, `C2`, `C3`, `C4`, and `C5`.
- The implementation is intentionally simple and relies on standard input and output, which makes it easy to test from the command line or an IDE.

## Repository Layout

- `_2005021/src` - Java source files
- `input.txt` - sample input
- `output.txt` - expected output for the sample input
- `UML Class Diagram.pdf` - UML class diagram for the banking system
