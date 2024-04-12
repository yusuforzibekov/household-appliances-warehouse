package com.company.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Oven extends BaseDomain {
    private Double temperature;
    private Integer processTime;
    private Integer capacity;
    private Integer powerConsumption;

    @Builder(builderMethodName = "childBuilder")
    public Oven(Long id, String color, Double price, String creationDate, Integer quantity,
                Double temperature, Integer processTime, Integer capacity, Integer powerConsumption) {
        super(id, color, price, creationDate, quantity);
        this.temperature = temperature;
        this.processTime = processTime;
        this.capacity = capacity;
        this.powerConsumption = powerConsumption;
    }
}
