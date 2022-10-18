package cinema;

import java.util.HashMap;
import java.util.Map;

public class Ticket {

    public final static String TICKET_ID = "ticket_id";
    public final static String TICKET_PRICE = "ticket_price";
    public final static String TICKET_ROW = "ticket_row";
    public final static String TICKET_SEAT_ID = "ticket_seat_id";
    private static int ticketId;

    private final int ticketPrice;
    private final int ticketRow;
    private final int ticketSeatId;

    private final Seat selectedSeat;

    public Ticket(Seat selectedSeat) {
        ticketId++;
        this.selectedSeat = selectedSeat;
        this.ticketPrice = this.selectedSeat.getPrice();
        this.ticketRow = this.selectedSeat.getRow();
        this.ticketSeatId = this.selectedSeat.getSeatId();
    }

    public boolean buy() {

        if (selectedSeat.getSeatBooked()) {
            return false;
        }
        this.selectedSeat.bookSeat();

        return true;
    }

    public Map<String, String> getTicketInfo() {
        Map<String, String> ticketInfo = new HashMap<String, String>();

        ticketInfo.put(TICKET_ID, String.valueOf(ticketId));
        ticketInfo.put(TICKET_PRICE, String.format("$%s", this.ticketPrice));
        ticketInfo.put(TICKET_ROW, String.valueOf(this.ticketRow));
        ticketInfo.put(TICKET_SEAT_ID, String.valueOf(this.ticketSeatId));

        return ticketInfo;
    }
}
