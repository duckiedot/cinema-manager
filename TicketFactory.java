package cinema;

public class TicketFactory {
    public Ticket create(Seat selectedSeat) {
        return new Ticket(selectedSeat);
    }
}
