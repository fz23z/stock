package com.dev.zhouhua.practise.factoryMode;

import org.springframework.util.Assert;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jiangyanyan
 * @since 2019/8/20 上午9:36
 */
@Getter
@Setter
public class Employee {

    private String name;

    public static Employee create(int type) {
        EmployeeTypeEnum typeEnum = EmployeeTypeEnum.getByType(type);
        Assert.notNull(typeEnum, ErrorCode.EmployeeTypeNotExist.getMsg());
        return typeEnum.getTypeInstance();
    }


    public static void main(String args[]){

        System.out.println(Employee.create(3).getClass().getName());


    }

}
