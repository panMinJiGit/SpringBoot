package com.cc.springboot.entity;


import javax.persistence.*;

@Entity
@Table(name = "t_device")
public class DeviceEntity {

    /**
     * ID，唯一不重复
     * 声明主键
     * 声明主键的生成策略
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length =50,name = "deviceCode")
    private String deviceCode;

    @Column(length =50,name = "deviceName")
    private String deviceName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
