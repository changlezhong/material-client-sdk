package cn.pinming.material.common.enums;

import cn.hutool.http.Method;
import cn.pinming.material.common.response.Response;
import cn.pinming.material.model.WeighDataAssemble;

/**
 * @author changlezhong
 * @description
 */
public enum ApiService {

    ASSEMBLE(Method.POST, "/material-client-management/api/openapi/weigh/data/assemble", WeighDataAssemble.class),
    CONFIRM(Method.POST,"/material-client-management/api/openapi/weigh/data/confirm", Boolean.class),
    ;

    private Method httpMethod;
    private String apiPath;
    private Class clazz;

    ApiService(Method httpMethod, String apiPath, Class clazz) {
        this.httpMethod = httpMethod;
        this.apiPath = apiPath;
        this.clazz = clazz;
    }

    public Method httpMethod() {
        return httpMethod;
    }

    public String apiPath() {
        return apiPath;
    }

    public Class clazz() {
        return clazz;
    }

    public static boolean check(String apiService) {
        if (apiService == null || apiService.equals("")) {
            return false;
        }
        for (ApiService value : ApiService.values()) {
            if (value.name().equals(apiService)) {
                return true;
            }
        }
        return false;
    }
}
