package com.asiabill.common.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: Xiongyancong
 * @create: 2020-07-07 14:27
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int SUCCESS = 200;

    private String msg = "success";

    private int code = SUCCESS;

    private String detail;

    /**
     * maybe null
     */
    private T data;

    private ResultBean(T data) {
        this.data = data;
    }

    private ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> ResultBean<T> success(T data) {
        return new ResultBean<>(data);
    }

    public static <T> ResultBean<T> success() {
        return new ResultBean<>();
    }

    public static <T> ResultBean<T> success(int code, String msg){ return new ResultBean<>(code,msg);}

    public static ResultBean fail(int code, String msg) {
        return new ResultBean<>(code, msg);
    }

}
