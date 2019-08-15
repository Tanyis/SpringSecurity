package org.security.entity;

/**
 * @author tanyi
 * @date 2019/8/13 15:52
 */
public class Msg {
//测试标题", "测试内容", "额外信息，只对管理员显示
    private  String title;
    private  String content;
    private String message;

    public Msg(String title, String content, String message) {
        this.title = title;
        this.content = content;
        this.message = message;
    }

    public Msg() {
    }
}
