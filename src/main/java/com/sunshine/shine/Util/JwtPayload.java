package com.sunshine.shine.Util;

import lombok.Data;


/**
 * @title 
 * @description 
 * @company 好未来-爱智康
 * @author 杨光
 * @mobile 17600556713
 * @version 1.0
 * @created 2019/3/15 下午3:11
 * @changeRecord 
 */


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
