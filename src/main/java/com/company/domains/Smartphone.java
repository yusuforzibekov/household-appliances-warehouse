package com.company.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Smartphone extends BaseDomain {
    private Integer volume;
    private Integer brightness;
    private Double size;
    private Integer viewingDistance;

    @Builder(builderMethodName = "childBuilder")
    public Smartphone(Long id, String color, Double price, String creationDate, Integer quantity,
              Integer volume, Integer brightness, Double size, Integer viewingDistance) {
        super(id, color, price, creationDate, quantity);
        this.volume = volume;
        this.brightness = brightness;
        this.size = size;
        this.viewingDistance = viewingDistance;
    }
}
