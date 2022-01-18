package task.lesson8;

import com.skillbox.airport.Airport;

public class Loader {

    public static void main(String[] args) {
        final int aircraftNumbers = Airport.getInstance().getAllAircrafts().size();
        System.out.printf("Number aircraft's in airport: %d", aircraftNumbers);
    }
}
