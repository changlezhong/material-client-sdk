package cn.pinming.material.common.request;

import cn.pinming.material.MaterialConfiguration;
import cn.pinming.material.common.enums.ApiService;
import cn.pinming.material.model.WeighDataAssemble;
import cn.pinming.material.model.form.WeighDataAssembleForm;
import com.alibaba.fastjson.JSONObject;

/**
 * @author changlezhong
 * @date 2023/6/26
 */
public class WeighDataAssembleRequest extends ServiceRequest<WeighDataAssembleForm, WeighDataAssemble> {

    public WeighDataAssembleRequest(MaterialConfiguration materialConfiguration, ApiService apiService, WeighDataAssembleForm assembleForm) {
        super(materialConfiguration, apiService, assembleForm);
    }

    @Override
    void initRequest(MaterialConfiguration materialConfiguration, ApiService apiService, WeighDataAssembleForm assembleForm) {
        super.init(materialConfiguration, apiService);
        super.setBody(JSONObject.toJSONString(assembleForm));
    }
}
