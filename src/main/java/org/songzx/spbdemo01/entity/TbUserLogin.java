package org.songzx.spbdemo01.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUserLogin implements Serializable {

    private static final long serialVersionUID = -170214422313660141L;
    private int id;

    private String loginname;
    private String password;
    private String email;
    private Date lastlogintime;
}
