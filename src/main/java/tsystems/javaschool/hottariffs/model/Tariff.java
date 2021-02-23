package tsystems.javaschool.hottariffs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class Tariff implements Serializable {
    private long id;
    private String name;
    private double price;
    private Set<Option> options;
}
