package com.sunshine.shine.Util;

import lombok.Data;


@Data
public class JwtPayload {
    /**
     * Claims常量
     * iat
     */
    private Integer iat;
    /**
     * Claims常量
     * exp
     */
    private Integer exp;


    private Boolean is_student;

    private Integer user_id;

    private Integer cdb_user_id;

    private String phone;

    private Integer sign_in_count;

}
