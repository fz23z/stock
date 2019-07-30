package com.dev.zhouhua.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiangyanyan
 * @since 2019/7/28 下午8:18
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

