package tsystems.javaschool.hotTariffs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Option {
    private long id;
    private String name;
    private double price;
    private double connectionCost;
}
