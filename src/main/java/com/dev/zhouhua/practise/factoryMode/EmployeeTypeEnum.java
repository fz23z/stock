package com.dev.zhouhua.practise.factoryMode;

import lombok.Getter;

/**
 * @author jiangyanyan
 * @since 2019/8/20 上午9:39
 */
@Getter
public enum EmployeeTypeEnum {

    /**
     * 工程师
     */
    ENGINEER(0, "工程师") {
        @Override
        public Engineer getTypeInstance() {
            return new Engineer();
        }
    },

    /**
     * 销售
     */
    SALESMAN(1, "销售") {
        @Override
        public SalesMan getTypeInstance() {
            return new SalesMan();
        }
    },

    /**
     * 经理
     */
    MANAGER(2, "经理") {
        @Override
        public Manager getTypeInstance() {
            return new Manager();
        }
    },


    /**
     * 老板
     */
    BOSS(3, "老板") {
        @Override
        public Boss getTypeInstance() {
            return new Boss();
        }
    };

    private int type;

    private String desc;

    public abstract Employee getTypeInstance();

    EmployeeTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static EmployeeTypeEnum getByType(int type) {
        for (EmployeeTypeEnum typeEnum : EmployeeTypeEnum.values()) {
            if (typeEnum.getType() == type) {
                return typeEnum;
            }
        }
        return null;
    }

}
