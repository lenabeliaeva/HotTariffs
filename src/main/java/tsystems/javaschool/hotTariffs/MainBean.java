package tsystems.javaschool.hotTariffs;

import lombok.NoArgsConstructor;
import tsystems.javaschool.hotTariffs.model.Tariff;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
@NoArgsConstructor
public class MainBean {

    @EJB
    TariffBean tariffBean;

    public List<Tariff> getTariffs() {
        return tariffBean.getTariffs();
    }

}
