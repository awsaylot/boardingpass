public enum Airports {
    ATLANTA(new double[] {33.6404, -84.4198}),
    TAMPA_BAY(new double[] {27.9791, -82.5393}),
    NEW_ORLEANS(new double[] {29.9893,-90.2548}),
    MIAMI(new double[] {25.7933, -80.2906}),
    ORLANDO(new double[] {28.7733, -81.2358});

    final double[] gpsCoords;

    Airports (double[] gpsCoords) {

        this.gpsCoords = gpsCoords;
    }
}
