public class Plane {
    private PlaneSeat[] seat = new PlaneSeat[12];
    private int numEmptySeat;
    public Plane(){
        this.numEmptySeat = 12;
        for(int i = 0; i < 12; i++){
            seat[i] = new PlaneSeat(i + 1);
        }
    }
    private PlaneSeat[] sortSeats(){
        for(int i = 0; i < seat.length - 1; i++) {
            for(int j = 0; j < seat.length - i - 1; j++){
                if(seat[j].getCustomerID() > seat[j + 1].getCustomerID())
                {
                    PlaneSeat temp = seat[j];
                    seat[j] = seat[j + 1];
                    seat[j + 1] = temp;
                }
            }
        }
        return seat; 
    }
    public void showNumEmptySeats(){
        System.out.println("Number of empty seats is " + numEmptySeat);
    }
    public void showEmptySeats(){
        System.out.println("Empty Seats At Index: ");
        for(int i = 0; i < seat.length; i++) {
            if(seat[i].isOccupied()) {
                continue; 
            } else {
                System.out.println(seat[i].getSeatID());
            }
        }
    }
    public void showAssignedSeats(boolean bySeatId) {
        System.out.println("Seat assignments as follows: ");
        PlaneSeat[] listToUse = bySeatId ? seat : sortSeats(); 
        for(int i = 0 ; i < listToUse.length; i++) {
            if(!listToUse[i].isOccupied ()) continue; 
            System.out.println("SeatID " + listToUse[i].getSeatID() + " Assigned to CustomerID " + listToUse[i].getCustomerID() + ".");
        }
    }
    public void assignSeat(int seatId, int cust_id) {
        if (seat[seatId - 1].isOccupied()) {
            System.out.println("Seat already assigned to a customer.");
        } else {
            seat[seatId - 1].assign(cust_id);
            numEmptySeat--;
            System.out.println("Seat Assigned!");
        }
    }
    public void unAssignSeat(int bySeatId) {
        if(seat[bySeatId - 1].isOccupied()) {
            seat[bySeatId - 1].unAssign();
            numEmptySeat++;
            System.out.println("Seat Unassigned!");
        }else {
            System.out.println("Seat is already empty");
        }
    }
}