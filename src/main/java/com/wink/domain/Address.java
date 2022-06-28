package com.wink.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@TableName("tb_address")
public class Address {
  @TableId
  private Integer addId;
  private String addName;
  private Integer userId;




}
