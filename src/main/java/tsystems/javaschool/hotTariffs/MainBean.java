package tsystems.javaschool.hotTariffs;

import tsystems.javaschool.hotTariffs.model.Tariff;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class MainBean {

    @EJB
    private TariffBean tariffBean;

    public List<Tariff> getTariffs() {
        return tariffBean.getTariffs();
    }
}
