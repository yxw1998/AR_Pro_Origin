package cn.ar.config;

import cn.ar.common.GeneralResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author YangXw
 * @date 2021/11/12 0012 10:08
 * @description 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public GeneralResult exception(Exception e) {
        log.error("routerPc全局异常处理-----{}" + e.getMessage());
        return GeneralResult.unAuthorized(e.getMessage());
    }

}
