package com.example.kunuztokenbased.dto;

import com.example.kunuztokenbased.entity.enums.RolesType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
 private Long id;
private String name;
private String phone;
private Integer age;
private String password;
private Long role_id;
}
