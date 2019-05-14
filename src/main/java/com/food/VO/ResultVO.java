package com.food.VO;

import lombok.Data;

import java.io.Serializable;

/**最外层通用结果集VO
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-06 22:55
 */
@Data
public class ResultVO<T> implements Serializable {


    private static final long serialVersionUID = -4197807287859104298L;
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
