package cn.pinming.material;

import cn.pinming.material.common.response.Response;
import cn.pinming.material.exception.MaterialException;
import cn.pinming.material.model.WeighDataAssemble;
import cn.pinming.material.model.form.WeighDataAssembleForm;

/**
 * @author changlezhong
 * @description
 */
public interface Material {

    /**
     * 称重数据组装
     * @param assembleForm
     * @return
     */
    WeighDataAssemble weighDataAssemble(WeighDataAssembleForm assembleForm) throws MaterialException;

    Response weighDataConfirm(WeighDataAssembleForm assembleForm) throws MaterialException;

}
