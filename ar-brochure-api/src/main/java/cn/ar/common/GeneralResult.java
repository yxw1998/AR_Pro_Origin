package cn.ar.common;

import lombok.Getter;

/**
 * @author YangXw
 * @date 2021/11/12 0012 9:42
 * @description 统一后端返回格式
 */
@Getter
public class GeneralResult<T> {

    private Integer code;
    private String message;
    private T data;

    public GeneralResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> GeneralResult<T> success(T data) {
        return new GeneralResult<>(ReturnCode.SUCCESS.getCode(), ReturnCode.SUCCESS.getMessage(), data);
    }

    public static <T> GeneralResult<T> fail(T data) {
        return new GeneralResult<>(ReturnCode.FAILED.getCode(), ReturnCode.FAILED.getMessage(), data);
    }


    public static <T> GeneralResult<T> error(T data) {
        return new GeneralResult<>(ReturnCode.ERROR.getCode(), ReturnCode.ERROR.getMessage(), data);
    }

    public static <T> GeneralResult<T> validateFailed(T data) {
        return new GeneralResult<>(ReturnCode.VALIDATE_FAILED.getCode(), ReturnCode.VALIDATE_FAILED.getMessage(), data);
    }

    public static <T> GeneralResult<T> warn(String message, T data) {
        return new GeneralResult<>(ReturnCode.WARN.getCode(), message, data);
    }
}
