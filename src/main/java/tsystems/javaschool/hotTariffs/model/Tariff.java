package tsystems.javaschool.hotTariffs.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
public class Tariff implements Serializable {
    private long id;
    private String name;
    private double price;
    private Set<Option> options;
}
