package tsystems.javaschool.hotTariffs;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {

    public String getMessage() {
        return "Hello, World!";
    }
}
