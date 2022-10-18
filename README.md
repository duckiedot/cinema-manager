
# Project Acceptance Critiera
### The cinema room manager should consits of following:
- Generate seat objects into seat collection based on how many rows and seats per row are specified
- Apply custom seat pricing based if the seat is a font row or back row
- Display all seats with row and seat indcation. Including information if the seat is vacant or not
- Buy a ticket with given row number and seat number
- Total Sales (TBA)
- Refund a ticket by ID(TBA)
- Error/Exception handling

# How to use the cinema manager?
1. Run Cinema.java main method
2. This will run CinemaHanlder
2. The cinema room will be created based on input provided (total rows and seats per row)
3. This will create a SeatCollection containing Seat objects with assigned custom pricing, rowId, seatId and seatBooked
4. User can now use the nav menu

# NavMenu breakdown
1. Show the seats
    -  loops through the seatsCollection and renders it
2. Buy a ticket 
   - invokes buyTicket on seatCollection, which creates a new Ticket from TicketFactory.
   - This changes the selected seat seatBooked property to true, which reflects in navMenu step 1
   - The returned ticket has an ID, price, seatId and rowId
3. Exit
    - Quits the application
