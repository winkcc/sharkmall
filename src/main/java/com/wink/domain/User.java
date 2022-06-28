package com.wink.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@TableName("tb_user")
public class User {
  @TableId
  private Integer usId;
  private String usName;
  private String usUsername;
  private String usPassword;



}
