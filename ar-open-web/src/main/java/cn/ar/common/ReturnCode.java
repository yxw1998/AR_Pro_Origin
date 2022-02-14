package cn.ar.common;

import lombok.Getter;

/**
 * @author YangXw
 * @date 2021/11/12 0012 9:43
 * @description
 */
@Getter
public enum ReturnCode {
    SUCCESS(1000, "操作成功！"),
    FAILED(1006, "操作失败！"),
    WARN(1004, "友情提示！"),
    ERROR(0, "系统异常！"),
    VALIDATE_FAILED(1002, "参数检验失败"),
    UNAUTHORIZED(1003, "暂未登录或token已经过期"),
    TEST(1100, "没有相关权限"),
    VERIFICATION_CODE(1007, "验证码错误"),
    FORBIDDEN(1006, "没有相关权限");

    private Integer code;

    private String message;

    ReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
