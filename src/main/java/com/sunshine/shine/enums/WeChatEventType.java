package com.sunshine.shine.enums;

public enum WeChatEventType {
    /***
     * 关注
     */
    subscribe("subscribe"),
    unsubscribe("unsubscribe");

    private String eventType = "";
    WeChatEventType(String eventType) {
        this.eventType = eventType;
    }
}
