public class LoanRequest {
    private final Account requester;
    private final double loanAmount;
    private boolean isApproved;

    public LoanRequest(Account requester, double loanAmount) {
        this.requester = requester;
        this.loanAmount = loanAmount;
        this.isApproved = false;
    }
    void approve(){
        this.isApproved = true;
        requester.reflectLoanApproval(this);
    }

    public boolean isApproved() {
        return isApproved;
    }

    public String getRequesterName() {
        return requester.getName();
    }

    public double getLoanAmount() {
        return loanAmount;
    }
}
