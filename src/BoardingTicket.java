public class BoardingTicket {
    private int boardingPassNumber;
    private int date;
    private String origin;
    private String destination;
    private int departureTime;
    private int ticketPrice;
    private int arrivalTime;

    public BoardingTicket(int date, String origin, String destination, int departureTime, Passenger passenger) {
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = calculateArrival();
        this.ticketPrice = calculatePrice();
        this.boardingPassNumber = generateBoardingPassNumber();
    }

    private int generateBoardingPassNumber() {
        return 0;
    }
    private int calculatePrice(Passenger passenger) {
        return 0;
    }
    private int calculateArrival() {
        return 0;
    }

    public void setDate(int date) {
        this.date = date;
    }
    public int getDate() {
        return date;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getOrigin() {
        return origin;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getDestination() {
        return destination;
    }
    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }
    public int getDepartureTime() {
        return departureTime;
    }
}

