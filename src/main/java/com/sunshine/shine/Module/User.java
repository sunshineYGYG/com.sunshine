package com.sunshine.shine.Module;

import lombok.Data;

@Data
public class User extends Book{
    private String name;
    private String nickName;
    private String dream;
    private Book book;
}
