package com.wink.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDetail {
    private int pid;
    private int gid;
    private String name;
    private String comment;
    private double price;
    private int num;


}
