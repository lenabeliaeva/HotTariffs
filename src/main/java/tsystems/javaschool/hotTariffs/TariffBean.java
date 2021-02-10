package tsystems.javaschool.hotTariffs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import tsystems.javaschool.hotTariffs.model.Tariff;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

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
            e.printStackTrace();
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
