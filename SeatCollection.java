package cinema;

import java.util.ArrayList;
import java.util.Map;

public class SeatCollection
{
    private final static int LARGE_ROOM_SEATS = 60;
    private final int numRows;
    private final int seatsPerRow;

    private final ArrayList<Seat> seats;
    private final Renderer renderer;
    private final TicketFactory ticketFactory;

    SeatCollection(int numRows, int seatsPerRow)
    {
        this.numRows = numRows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new ArrayList<>();
        this.renderer = new Renderer();
        this.ticketFactory = new TicketFactory();
        this.generateSeats();
    }

    public void renderSeats()
    {
        this.renderer.displayVoid(this.getSeatsView());
    }

    public Ticket buyTicket(int rowId, int seatId)
    {
        int selectedSeatId = 0;
        if (rowId == 1) {
            selectedSeatId = seatId-1;
        } else {
            selectedSeatId = ((rowId - 1) * this.seatsPerRow) + (seatId - 1);
        }

        Ticket ticket = this.ticketFactory.create(this.seats.get(selectedSeatId));
        ticket.buy();
        Map<String, String> ticketInfo = ticket.getTicketInfo();
        this.renderer.displayVoid(String.format("Ticket price: %s", ticketInfo.get(Ticket.TICKET_PRICE)));

        return ticket;
    }

    private void generateSeats()
    {
        for (int currentRow = 1; currentRow <= this.numRows; currentRow++) {
            for (int currentSeat = 1; currentSeat <= this.seatsPerRow; currentSeat++) {
                this.seats.add(
                        new Seat(currentRow-1, this.numRows, this.getIsLargeRoom())
                );
            }
        }
    }

    private String getSeatsView()
    {
        StringBuilder output = new StringBuilder("\nCinema:\n");

        for (int currentRowId = 1; currentRowId <= this.numRows; currentRowId++) {
            if (currentRowId == 1) {
                output.append(this.generateSeatViewHeader());
            }
            output.append(currentRowId);
            for (Seat singleSeat : this.getSeatsByRow(currentRowId-1)) {
                output.append(" ");
                output.append(singleSeat.getSeatBooked() ? "B" : "S");
            }
            output.append('\n');
        }
        return String.valueOf(output);
    }

    private String generateSeatViewHeader()
    {
        StringBuilder output = new StringBuilder();

        output.append(' ');
        for (int i = 1;i <= this.seatsPerRow; i++) {
            output.append(' ');
            output.append(i);
        }
        output.append('\n');

        return String.valueOf(output);
    }

    private ArrayList<Seat> getSeatsByRow(int currentRow)
    {
        ArrayList<Seat> output = new ArrayList<>();
        int firstSeatInRowId =  currentRow == 0 ? 0 : (currentRow * seatsPerRow);
        int lastSeatInRowId = firstSeatInRowId + seatsPerRow;

        for (int currentSeat = firstSeatInRowId;currentSeat < lastSeatInRowId;currentSeat++) {
            output.add(this.seats.get(currentSeat));
        }
        return output;
    }

    private boolean getIsLargeRoom()
    {
        return (this.numRows * this.seatsPerRow > LARGE_ROOM_SEATS);
    }
}
