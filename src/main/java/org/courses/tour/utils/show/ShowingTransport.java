package org.courses.tour.utils.show;

import org.courses.tour.transport.Transport;
import org.courses.tour.typeTours.Tour;

import java.util.Map;

public interface ShowingTransport {
    void showTransport(Map<Integer, Transport> integerTourMap);
}
