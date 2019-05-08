package com.food.exception;

import com.food.enums.ResultEnum;

/**异常枚举类
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-07 23:52
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
