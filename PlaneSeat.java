public class PlaneSeat {
    private int seatID; 
    private boolean assigned; 
    private int customerId; 
    public PlaneSeat(int seat_ID){
        this.seatID = seat_ID;
        this.assigned = false; 
        this.customerId = 0;
    }
    public int getSeatID() {
        return this.seatID;
    }
    public int getCustomerID() {
        return this.customerId; 
    }
    public boolean isOccupied() {
        return assigned; 
    }
    public void assign(int cust_id) {
        this.assigned = true; 
        this.customerId = cust_id; 
    }
    public void unAssign() {
        this.assigned = false;
        this.customerId = 0;
    }
}