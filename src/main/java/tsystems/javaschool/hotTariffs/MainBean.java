package tsystems.javaschool.hotTariffs;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "mainBean", eager = true)
public class MainBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
