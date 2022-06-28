package com.wink.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDetail {
    private String name;
    private String comment;
    private double price;
    private int num;


}
