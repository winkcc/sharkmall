package com.wink.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@TableName("tb_car")
public class Car {
@TableId
  private Integer carId;
  private Integer userId;
  private Integer goodsId;
  private double carNum;
  private double carSumnum;




}
