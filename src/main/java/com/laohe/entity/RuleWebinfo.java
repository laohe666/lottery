package com.laohe.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RuleWebinfo implements Serializable {

    private int id;
    private String url;
    private String title;
    private Date createTime;
}
