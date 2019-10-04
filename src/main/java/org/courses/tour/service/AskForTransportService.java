package org.courses.tour.service;

import org.courses.tour.city.City;
import org.courses.tour.transport.Transport;
import org.courses.tour.utils.show.ShowingEntityImpl;

import java.util.Map;

import static org.courses.tour.utils.ConsoleComunication.chooseSomeEntity;
import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class AskForTransportService {
    public Transport askForTransport(City city) {
        ShowingEntityImpl showing = new ShowingEntityImpl();
        Map<Integer, Transport> transportMap = city.getTransportMap();
        showing.showTransport(transportMap);
        int transportNumber = chooseSomeEntity(transportMap.size());
        Transport transport = transportMap.get(transportNumber);
        showMessage("Great choose. What type of food you prefer?");
        return transport;

    }
}
