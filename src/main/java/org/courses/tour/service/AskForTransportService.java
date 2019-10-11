package org.courses.tour.service;

import org.apache.log4j.Logger;
import org.courses.tour.city.City;
import org.courses.tour.transport.Transport;
import org.courses.tour.utils.show.ShowingEntityImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.courses.tour.utils.ConsoleComunication.chooseSomeEntity;
import static org.courses.tour.utils.ConsoleComunication.showMessage;

@Service
public class AskForTransportService {
    private static final Logger LOG = Logger.getLogger(AskForTransportService.class);

    public Transport askForTransport(City city) {
        ShowingEntityImpl showing = new ShowingEntityImpl();
        Map<Integer, Transport> transportMap = city.getTransportMap();
        showing.showTransport(transportMap);
        int transportNumber = chooseSomeEntity(transportMap.size());
        Transport transport = transportMap.get(transportNumber);
        LOG.info("Choose transport = " + transport);
        showMessage("Great choose. What type of food you prefer?");
        return transport;

    }
}
