package com.ithub.source.learn.base;

import org.springframework.util.StringUtils;


public enum MtCouponIdEnum {

	ZERO(0, "10000",10000),
	ONE(1, "20000",20000),
	TWO(2, "50000",50000),
	THREE(3, "100000",100000),
	FOUR(4,"200000",200000),
	FIVE(5,"500000",500000),
	SIX(6,"1000000",1000000),
	SEVEN(7,"2000000",2000000),
	EIGHT(8,"5000000",5000000),
	;
	private Integer value;

	private String name;

	private Integer money;

	MtCouponIdEnum(Integer value, String name, Integer money) {
		this.value = value;
		this.name = name;
		this.money = money;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static String getName(Integer value) {
		for (MtCouponIdEnum c : MtCouponIdEnum.values()) {
			if (c.value == value) {
				return c.name;
			}
		}
		return null;
	}

	public static MtCouponIdEnum getEnum(Integer value) {
		for (MtCouponIdEnum c : MtCouponIdEnum.values()) {
			if (c.value == value.intValue()) {
				return c;
			}
		}
		return null;
	}

	public static MtCouponIdEnum getEnumByMoney(Integer money) {
		for (MtCouponIdEnum c : MtCouponIdEnum.values()) {
			if (c.getMoney().intValue() == money.intValue()) {
				return c;
			}
		}
		return null;
	}

	public static Integer getValue(String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		for (MtCouponIdEnum c : MtCouponIdEnum.values()) {
			if (c.getName().equals(name)) {
				return c.value;
			}
		}
		return null;
	}

	public static Integer getValue(Integer money) {
		if (money == null) {
			return null;
		}
		for (MtCouponIdEnum c : MtCouponIdEnum.values()) {
			if (c.getMoney().intValue() == money.intValue()) {
				return c.value;
			}
		}
		return null;
	}


	public static boolean contain(Integer value) {
		return getName(value) != null;
	}


	public Integer getMoney() {
		return money;
	}


	public String getText() {
		return name;
	}
}
