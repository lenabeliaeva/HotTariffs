package tsystems.javaschool.hotTariffs.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Option {
    private long id;
    private String name;
    private double price;
    private double connectionCost;
}
