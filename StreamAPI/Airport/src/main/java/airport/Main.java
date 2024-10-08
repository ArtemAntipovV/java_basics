package airport;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        //TODO Метод должен вернуть количество самолетов указанной модели.
        // подходят те самолеты, у которых name начинается со строки model
        return airport.getAllAircrafts().stream()
                .filter(a -> a.getModel().startsWith(model))
                .count();
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        //TODO Метод должен вернуть словарь с количеством припаркованных самолетов в каждом терминале.
        return airport.getTerminals().stream()
                .collect(Collectors.toMap(Terminal::getName, t -> t.getParkedAircrafts().size()));

    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        //TODO Метод должен вернуть список отправляющихся рейсов в ближайшее количество часов.

        Instant departureNow = Instant.now();
        Instant datePlusHours = departureNow.plus(hours, ChronoUnit.HOURS);

        return airport.getTerminals().stream()
                .flatMap(a -> a.getFlights().stream())
                        .filter(x -> x.getType() == Flight.Type.DEPARTURE)
                        .filter(y -> y.getDate().isBefore(datePlusHours)
                        && y.getDate().isAfter(departureNow))
                        .collect(Collectors.toList());
    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {
        //TODO Найти ближайший прилет в указанный терминал.
                Instant arriveNow = Instant.now();

        return airport.getTerminals()
                .stream()
                .filter(terminal -> terminal.getName().equals(terminalName))
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Flight.Type.ARRIVAL)
                .filter(flight -> flight.getDate().isAfter(arriveNow))
                .findFirst();
    }
}