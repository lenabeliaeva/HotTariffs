package tsystems.javaschool.hottariffs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import tsystems.javaschool.hottariffs.model.Tariff;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Log4j
@Singleton
@NoArgsConstructor
public class TariffBean {

    @EJB
    private Receiver receiver;

    private final Loader loader = Loader.getInstance();

    @Getter
    private List<Tariff> tariffs;

    @PostConstruct
    private void init() {
        try {
            receiver.getMessage();
        } catch (IOException | TimeoutException e) {
            log.warn("Can't get message");
        }
        loadTariffList();
    }

    public void loadTariffList() {
        tariffs = loader.getTariffs();
    }

    @PreDestroy
    private void destroy() {
        try {
            receiver.close();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
