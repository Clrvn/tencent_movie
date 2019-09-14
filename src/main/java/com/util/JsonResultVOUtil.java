package com.util;


import com.enums.ResultFailureEnum;
import com.vo.JsonResultVO;

public class JsonResultVOUtil {
    
    public static <T> JsonResultVO success(T object) {
        JsonResultVO<T> resultVO = new JsonResultVO<>();
        resultVO.setState(200);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }
    
    public static JsonResultVO success() {
        JsonResultVO resultVO = new JsonResultVO();
        resultVO.setState(200);
        resultVO.setMessage("成功");
        return resultVO;
    }
    
    public static JsonResultVO failure(ResultFailureEnum resultEnum) {
        JsonResultVO resultVO = new JsonResultVO();
        resultVO.setState(resultEnum.getState());
        resultVO.setMessage(resultEnum.getMessage());
        return resultVO;
    }
}
