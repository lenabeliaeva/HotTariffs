package tsystems.javaschool.hotTariffs;

import lombok.Getter;
import lombok.Setter;
import tsystems.javaschool.hotTariffs.model.Tariff;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Singleton
public class TariffBean {

    private final Receiver receiver = new Receiver();
    private final Loader loader = Loader.getInstance();

    @Getter
    @Setter
    private List<Tariff> tariffs;

    @PostConstruct
    private void init() {
        try {
            receiver.getMessage();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        updateTariffList();
    }

    @PreDestroy
    private void destroy() {
        try {
            receiver.close();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void updateTariffList() {
        tariffs = loader.getTariffs();
    }
}
