package com.company.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Laptop extends BaseDomain {
    private Double height;
    private Double weight;

    @Builder(builderMethodName = "childBuilder")
    public Laptop(Long id, String color, Double price, String creationDate,
                        Integer quantity, Double height, Double weight) {
        super(id, color, price, creationDate, quantity);
        this.height = height;
        this.weight = weight;
    }
}
