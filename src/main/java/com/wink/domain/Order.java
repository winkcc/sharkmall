package com.wink.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@TableName("tb_order")
public class Order {
  @TableId
  private Integer orderId;
  private double orderPrice;
  private String orderStatus;
  private Integer userId;
  private Integer goodsId;
  private String orderCreate;
  private String orderWay;
  private Integer orderNo;




}
