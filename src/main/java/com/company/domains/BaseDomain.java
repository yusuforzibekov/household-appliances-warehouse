package com.company.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDomain {
    protected Long id;
    protected String color;
    protected Double price;
    protected String creationDate;
    protected Integer quantity;
}