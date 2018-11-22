package com.sunshine.shine.Service;

public interface RedisScript<T> {
    //获取脚本的sha1
    String getSha1();
    //获取脚本的返回值
    Class<T> getResultType();
    //获取脚本的字符串
    String getScriptAsString();
}
