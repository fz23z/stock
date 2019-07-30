package com.dev.zhouhua.mapstruct;

import lombok.*;

import java.util.Date;

/**
 * @author jiangyanyan
 * @since 2019/7/28 下午8:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;
    private String name;
    private String email;
    private Date birthday;
    private User user;


}
