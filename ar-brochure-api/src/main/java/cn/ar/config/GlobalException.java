package cn.ar.config;

import cn.ar.common.GeneralResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

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
        log.error("全局异常处理-----{}" + e.getMessage());
        return GeneralResult.error(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GeneralResult exception2(MethodArgumentNotValidException e) {
        List<String> collect = e.getBindingResult().getFieldErrors()
                .stream()
                .map(o -> o.getDefaultMessage())
                .collect(Collectors.toList());
        log.error("参数校验异常处理-----{}" + collect);
        return GeneralResult.validateFailed(collect);
    }
}
