package com.sam.graduation.design.gdmusicserver.model.enums.related;

import com.sam.graduation.design.gdmusicserver.model.enums.base.PojoEnumable;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/2/28 16:22:44
 */
public enum UserSex implements PojoEnumable {

    /**
     * 性别：1（男），2（女），3（保密）
     */
    MALE(1) {
        @Override
        public String description() {
            return "男";
        }
    }, FEMALE(2) {
        @Override
        public String description() {
            return "女";
        }
    }, SECRET(3) {
        @Override
        public String description() {
            return "保密";
        }
    },;

    private int actualValue;

    private UserSex(int actualValue) {
        this.actualValue = actualValue;
    }

    @Override
    public int value() {
        return this.actualValue;
    }

    public int getActualValue() {
        return actualValue;
    }

    public static UserSex from(int value) {
        for (UserSex en : UserSex.values()) {
            if (en.getActualValue() == value) {
                return en;
            }
        }
        return UserSex.MALE;
    }

    public static UserSex from(String name) {
        for (UserSex en : UserSex.values()) {
            if (en.name().equals(name)) {
                return en;
            }
        }
        return UserSex.MALE;
    }

}
