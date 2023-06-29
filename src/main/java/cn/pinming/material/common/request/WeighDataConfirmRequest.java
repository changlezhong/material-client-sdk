package cn.pinming.material.common.request;

import cn.pinming.material.MaterialConfiguration;
import cn.pinming.material.common.enums.ApiService;
import cn.pinming.material.common.response.Response;
import cn.pinming.material.model.WeighDataAssemble;
import com.alibaba.fastjson.JSONObject;

public class WeighDataConfirmRequest extends ServiceRequest<Response, WeighDataAssemble>{
    public WeighDataConfirmRequest(MaterialConfiguration materialConfiguration, ApiService apiService, Response response) {
        super(materialConfiguration, apiService, response);
    }

    @Override
    void initRequest(MaterialConfiguration materialConfiguration, ApiService apiService, Response response) {
        super.init(materialConfiguration, apiService);
        super.setBody(JSONObject.toJSONString(response));
    }
}
