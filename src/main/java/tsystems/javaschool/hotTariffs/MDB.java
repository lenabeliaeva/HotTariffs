package tsystems.javaschool.hotTariffs;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "tariffQueue"),
        @ActivationConfigProperty(
                propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"
        )
})
public class MDB implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage msg = (ObjectMessage) message;
            String tariffsJson = (String) msg.getObject();
            System.out.println(tariffsJson);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
