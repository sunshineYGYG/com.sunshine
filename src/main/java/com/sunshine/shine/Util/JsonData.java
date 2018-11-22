package com.sunshine.shine.Util;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Created by cool.chen on 2017/4/9 23:33 23:36.
 * json返回值格式的辅助对象
 */
@ToString
public class JsonData<T> implements Serializable {

    private static final String DEFAULT_SUCCESS_MSG = "操作成功";
    private static final String DEFAULT_ERROR_MSG = "操作失败";

    private static final int DEFAULT_SUCCESS_CODE = 0;
    private static final int DEFAULT_ERROR_CODE = 1;

    /**
     * 状态返回值
     */
    private final boolean ret;

    /**
     * 前端弹出消息
     */
    private String msg;

    /**
     * 后端具体传递给前端的消息
     */
    private T data;

    /**
     * 错误码
     */
    private Integer errcode;

    public JsonData() {
        this.ret = true;
    }

    /**
     * 为了保证符合规范，我们闭合构造权限
     */
    private JsonData(boolean ret) {
        this.ret = ret;
    }


    public static JsonData error(Object object, String message, Integer errcode) {
        JsonData result = new JsonData(false);
        result.data = object;
        result.msg = Strings.isNullOrEmpty(message) ? DEFAULT_ERROR_MSG : message;
        result.errcode = errcode == null ? DEFAULT_ERROR_CODE : errcode;
        return result;
    }

    public static JsonData error(Object object, String message) {
        return error(object, message, null);
    }

    /**
     * eg.
     * <p>
     * <pre>
     *      {
     *          "ret" : false,
     *          "msg" : "错误的id，修改失败",
     *          "errcode" : 1
     *      }
     * </pre>
     *
     * @param message
     * @param errcode
     * @return
     */
    public static JsonData error(String message, Integer errcode) {
        return error(null, message, errcode);
    }

    /**
     * eg.
     * <p>
     * <pre>
     *      {
     *          "ret" : false,
     *          "msg" : "错误的id，修改失败"
     *      }
     * </pre>
     *
     * @param message
     * @return
     */
    public static JsonData error(String message) {
        return error(null,message, null);
    }

    public static JsonData error(Object object, Integer errcode) {
        return error(object, null, errcode);
    }


    /**
     * eg.
     * <p>
     * <pre>
     *      {
     *          "ret" : false
     *      }
     * </pre>
     *
     * @return
     */
    public static JsonData error() {
        return error(null,null, null);
    }

    /**
     * eg.
     * <p>
     * <pre>
     *      {
     *          "ret" : false
     *          "errcode" : 1
     *      }
     * </pre>
     *
     * @param errcode
     * @return
     */
    public static JsonData error(Integer errcode) {
        return error(null,null, errcode);
    }

    /**
     * eg.
     * <p>
     * <pre>
     *      {
     *          "ret" : true,
     *          "data": {
     *                      "encodedRID": "2916181129",
     *                      "operator": "gambol2",
     *                      "createTime": 1411363837776,
     *                      "rescueStatus": 1,
     *                      "pFunction": "free",
     *                      "departure": "北京",
     *                      "arrive": "大连"
     *          },
     *          "msg";"修改成功"
     *      }
     * </pre>
     *
     * @param object
     * @param msg
     * @return
     */
    public static JsonData success(Object object, String msg) {
        JsonData result = new JsonData(true);
        result.data = object != null ? object : "";
        result.msg = Strings.isNullOrEmpty(msg) ? DEFAULT_SUCCESS_MSG : msg;
        result.errcode = DEFAULT_SUCCESS_CODE;
        return result;
    }

    /**
     * eg.
     * <p>
     * <pre>
     *      {
     *          "ret" : true,
     *          "data": {
     *                      "encodedRID": "2916181129",
     *                      "operator": "gambol2",
     *                      "createTime": 1411363837776,
     *                      "rescueStatus": 1,
     *                      "pFunction": "free",
     *                      "departure": "北京",
     *                      "arrive": "大连"
     *          }
     *      }
     * </pre>
     *
     * @param object
     * @return
     */
    public static JsonData success(Object object) {
        return success(object, null);
    }

    /**
     * eg.
     * <p>
     * <pre>
     *      {
     *          "ret" : true,
     *          "msg";"修改成功"
     *      }
     * </pre>
     *
     * @param msg
     * @return
     */
    public static JsonData success(String msg) {
        return success(null, msg);
    }

    /**
     * eg.
     * <p>
     * <pre>
     *      {
     *          "ret" : true
     *      }
     * </pre>
     *
     * @return
     */
    public static JsonData success() {
        return success(null, null);
    }

    /**
     * eg.
     * <pre>
     *
     *
     *  {
     *      "ret": true,
     *      "data": {
     *          "content": [
     *                          {
     *                              "operationTime": 1411389538087,
     *                              "username": "haifeng111222",
     *                              "encodedSID": "3279243797",
     *                              "operation": "关闭订单",
     *                              "totalQuotas": 30,
     *                              "operator": "kris.zhang"
     *                          },
     *                          {
     *                              "operationTime": 1411389517575,
     *                              "username": "haifeng111222",
     *                              "encodedSID": "3279243797",
     *                              "operation": "关闭订单",
     *                              "totalQuotas": 30,
     *                              "operator": "kris.zhang"
     *                          }
     *                      ],
     *          "totalRows": 4
     *      },
     *      "msg": "查询到结果"
     *  }
     * </pre>
     *
     * @param content
     * @param totalRows
     * @param msg
     * @return
     */
    public static <T> JsonData list(Collection<T> content, Integer totalRows, String msg) {
        Preconditions.checkNotNull(content);  // fast fail
        JsonData result = new JsonData(true);
        Map<String, Object> map = Maps.newHashMap();
        map.put("content", content);
        if (totalRows == null) {
            map.put("totalRows", content.size());
        } else {
            map.put("totalRows", totalRows);
        }
        result.msg = Strings.isNullOrEmpty(msg) ? DEFAULT_SUCCESS_MSG : msg;
        result.data = map;
        result.errcode = DEFAULT_SUCCESS_CODE;
        return result;
    }

    /**
     * eg.
     * <pre>
     *
     *
     *  {
     *      "ret": true,
     *      "data": {
     *          "content": [
     *                          {
     *                              "operationTime": 1411389538087,
     *                              "username": "haifeng111222",
     *                              "encodedSID": "3279243797",
     *                              "operation": "关闭订单",
     *                              "totalQuotas": 30,
     *                              "operator": "kris.zhang"
     *                          },
     *                          {
     *                              "operationTime": 1411389517575,
     *                              "username": "haifeng111222",
     *                              "encodedSID": "3279243797",
     *                              "operation": "关闭订单",
     *                              "totalQuotas": 30,
     *                              "operator": "kris.zhang"
     *                          }
     *                      ],
     *          "totalRows": 2
     *      },
     *      "msg": "查询到结果"
     *  }
     * </pre>
     *
     * @param content
     * @param msg
     * @return
     */
    public static <T> JsonData list(Collection<T> content, String msg) {
        return list(content, null, msg);
    }

    /**
     * eg.
     * <pre>
     *
     *
     *  {
     *      "ret": true,
     *      "data": {
     *          "content": [
     *                          {
     *                              "operationTime": 1411389538087,
     *                              "username": "haifeng111222",
     *                              "encodedSID": "3279243797",
     *                              "operation": "关闭订单",
     *                              "totalQuotas": 30,
     *                              "operator": "kris.zhang"
     *                          },
     *                          {
     *                              "operationTime": 1411389517575,
     *                              "username": "haifeng111222",
     *                              "encodedSID": "3279243797",
     *                              "operation": "关闭订单",
     *                              "totalQuotas": 30,
     *                              "operator": "kris.zhang"
     *                          }
     *                      ],
     *          "totalRows": 2
     *      }
     *  }
     * </pre>
     *
     * @param content
     * @return
     */
    public static <T> JsonData list(Collection<T> content) {
        return list(content, null, null);
    }

    /**
     * eg.
     * <pre>
     *
     *  {
     *      "ret": true,
     *      "data": {
     *          "content": [
     *                          {
     *                              "operationTime": 1411389538087,
     *                              "username": "haifeng111222",
     *                              "encodedSID": "3279243797",
     *                              "operation": "关闭订单",
     *                              "totalQuotas": 30,
     *                              "operator": "kris.zhang"
     *                          },
     *                          {
     *                              "operationTime": 1411389517575,
     *                              "username": "haifeng111222",
     *                              "encodedSID": "3279243797",
     *                              "operation": "关闭订单",
     *                              "totalQuotas": 30,
     *                              "operator": "kris.zhang"
     *                          }
     *                      ],
     *          "totalRows": 40
     *      }
     *  }
     * </pre>
     *
     * @param content
     * @return
     */
    public static <T> JsonData list(Collection<T> content, Integer totalRows) {
        return list(content, totalRows, null);
    }

    /**
     * 获得ret值
     *
     * @return
     */
    public boolean getRet() {
        return ret;
    }

    /**
     * 获得message
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }

    public JsonData<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * 获得数据
     *
     * @return
     */
    public T getData() {
        return data;
    }

    public JsonData<T> data(T data) {
        this.data = data;
        return this;
    }

    /**
     * 获得error code
     *
     * @return
     */
    public Integer getErrcode() {
        return errcode;
    }

    public JsonData<T> errcode(int errcode) {
        this.errcode = errcode;
        return this;
    }
}

