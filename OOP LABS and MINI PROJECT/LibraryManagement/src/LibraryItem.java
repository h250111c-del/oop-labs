public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;
    private  Loan currentLoan;

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank() || title == null || title.isBlank())
            throw new IllegalArgumentException("Id and title required");
        this.id = id;
        this.title = title;
    }

    public abstract int loanPeriodDays();

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public Loan getCurrentLoan() { return currentLoan; }

    @Override
    public void borrow(Member member)
            throws ItemNotAvailableException, MemberLimitExceededException {
        if (!available)
            throw new ItemNotAvailableException(title + " is already on loan");
        if (!member.canBorrow())
            throw new MemberLimitExceededException(
                    member.getName() + " already has " + Member.MAX_LOANS + " loans");
        currentLoan = new Loan(this, member);
        member.addLoan(currentLoan);
        available = false;
    }

    @Override
    public void giveBack() {
        if (currentLoan != null) {
            currentLoan.getMember().removeLoan(currentLoan);
            currentLoan = null;
        }
        available = true;
    }

    @Override
    public String toString() {
        return id + " - " + title + (available ? " (available)" : " (on loan)");
    }
}