package com.itdotaer.dubbo.research.bean.models;

import java.math.BigDecimal;

/**
 * FromBean
 *
 * @author jt_hu
 * @date 2018/10/25
 */
public class FromBean {
    private Long id;
    private String name;
    private String address;
    private Integer age;
    private String remark;
    private BigDecimal price;
    private Double minPrice;
    private Float floatPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Float getFloatPrice() {
        return floatPrice;
    }

    public void setFloatPrice(Float floatPrice) {
        this.floatPrice = floatPrice;
    }
}
