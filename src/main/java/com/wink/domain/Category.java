package com.wink.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@TableName("tb_category")
public class Category {
@TableId
  private Integer categoryId;
  private String categoryName;



}
