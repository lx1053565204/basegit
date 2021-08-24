package com.luxu.basegit.base;

/**
 * @author luxu
 * @version 1.0
 * @date 2021/6/25 15:42
 */
public class ResultUtil {

    /**成功且带数据**/
    @SuppressWarnings("unchecked")
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    /**成功但不带数据**/
    @SuppressWarnings("unchecked")
    public static Result success(){

        return success(null);
    }
    /**失败**/
    @SuppressWarnings("unchecked")
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
