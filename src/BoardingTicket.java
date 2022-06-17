public class BoardingTicket {
    private String boardingPassNumber;
    private String date;
    private String origin;
    private String destination;
    private int departureTime;
    private double ticketPrice;
    private double arrivalTime;
    private final int price = 150;

    public BoardingTicket(String date, String origin, String destination, int departureTime, Passenger passenger) {
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = calculateArrival();
        this.ticketPrice = calculatePrice(passenger);
        this.boardingPassNumber = generateBoardingPassNumber();
    }

    private String generateBoardingPassNumber() {
//        this function should be able to access file
//        operations in order to check the last boarding pass
//        number and add one to the number
        int prevNumber = 100500;
        if (prevNumber != 0) {
            return Integer.toString(++prevNumber);
        }
        return Integer.toString(000001);
    }
    private double calculatePrice(Passenger passenger) {
        if (passenger.getAge() <= 12) {
            return this.price * 0.5;
        }
        if (passenger.getAge() >= 50) {
            return this.price * 0.6;
        }
        if (passenger.getGender() == "F") {
            return this.price * 0.25;
        }
        return price;
    }
    private double calculateArrival() {
        double lat1 = Airports.valueOf("TAMPA_BAY").gpsCoords[0];
        double lat2 = Airports.valueOf("ORLANDO").gpsCoords[0];
        double lon1 = Airports.valueOf("TAMPA_BAY").gpsCoords[1];
        double lon2 = Airports.valueOf("ORLANDO").gpsCoords[1];

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos((deg2rad(lat1))) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);

        dist = dist * 60 * 1.1515;
        System.out.println((dist / 500 + .40) * 60);
        return dist / 500;
    }
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
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

    public double getArrivalTime() {
        return arrivalTime;
    }
}

