package com.milage;

import com.airport.*;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

// Processing the String of the flights
public class FlightArgumentConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext parameterContext) throws ArgumentConversionException {
        if (!(source instanceof String)){
            throw new IllegalArgumentException("The argument should be a string: " + source);
        }
        try {
            String[] parts = ((String) source).split(";");
            Flight flight = null;

            switch (parts[1].toLowerCase().trim()){
                case "b" : flight = new BusinessFlight(parts[0]);
                    break;
                case "p" : flight = new PremiumFlight(parts[0]);
                    break;
                case "e" : flight = new EconomyFlight(parts[0]);
                    break;
            }

            flight.addPassenger(new Passenger(parts[2].trim(), Boolean.valueOf(parts[3].trim())));
            flight.setDistance(Integer.valueOf(parts[4].trim()));

            return flight;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getClass().getSimpleName() + " " + e.getMessage());
        }
    }
}
