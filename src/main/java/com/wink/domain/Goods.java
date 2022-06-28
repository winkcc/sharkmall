package com.wink.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@TableName("tb_goods")
public class Goods {
@TableId
  private Integer goodsId;
  private String goodsName;
  private double goodsPrice;
  private String goodsComment;
  private Integer categoryId;




}
