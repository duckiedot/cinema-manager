package cinema;

public class CinemaHandler {

    private static final String QUESTION_ROWS = "Enter the number of rows:";
    private static final String QUESTION_SEATS = "Enter the number of seats in each row:";

    private Renderer renderer;
    private SeatCollection seats;
    private NavMenu navMenu;

    public void runCinema() {
        this.renderer = new Renderer();
        this.seats = new SeatCollection(
                renderer.askForInt(QUESTION_ROWS),
                renderer.askForInt(QUESTION_SEATS)
        );
        this.navMenu = new NavMenu(this.seats);
        navMenu.displayNavMenu();
    }
}
