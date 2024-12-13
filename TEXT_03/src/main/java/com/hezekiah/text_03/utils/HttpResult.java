package com.hezekiah.text_03.utils;

import java.util.HashMap;
import java.util.Map;

public class HttpResult {
    private static Map<String, Object> instance (Integer code, Boolean success, String msg, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("success", success);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    };

    public static Map<String, Object> success (String msg, Object data) {
        return HttpResult.instance(200, true, msg, data);
    }
    public static Map<String, Object> error (String msg, Object data) {
        return HttpResult.instance(500, false, msg, data);
    }
}
