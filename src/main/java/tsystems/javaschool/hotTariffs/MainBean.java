package tsystems.javaschool.hotTariffs;

import javax.ejb.Stateless;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Named
@Stateless
public class MainBean {
    private final Receiver receiver = new Receiver();

    @Inject
    @Push(channel = "tariffsChannel")
    PushContext tariffsChannel;

    public void update() {
        tariffsChannel.send("updateTariffs");
    }

    public void getMessage() {
        try {
            receiver.getMessage();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
