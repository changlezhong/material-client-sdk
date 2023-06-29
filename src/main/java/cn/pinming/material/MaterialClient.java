package cn.pinming.material;

import cn.hutool.http.Method;
import cn.pinming.material.auth.CredentialsProvider;
import cn.pinming.material.common.enums.ApiService;
import cn.pinming.material.common.request.ServiceRequest;
import cn.pinming.material.common.request.WeighDataAssembleRequest;
import cn.pinming.material.common.response.Response;
import cn.pinming.material.exception.MaterialException;
import cn.pinming.material.http.HttpClient;
import cn.pinming.material.model.WeighDataAssemble;
import cn.pinming.material.model.form.WeighDataAssembleForm;

/**
 * @author changlezhong
 * @description
 */
public class MaterialClient implements Material {

    private MaterialConfiguration materialConfiguration = new MaterialConfiguration();

    public MaterialClient(String endpoint, CredentialsProvider credsProvider) {
        this.materialConfiguration.setEndpoint(endpoint);
        this.materialConfiguration.setCredsProvider(credsProvider);
    }

    @Override
    public WeighDataAssemble weighDataAssemble(WeighDataAssembleForm assembleForm) throws MaterialException {
        ServiceRequest<WeighDataAssembleForm, WeighDataAssemble> request = new WeighDataAssembleRequest(materialConfiguration, ApiService.ASSEMBLE, assembleForm);
        return this.doOperation(request);
    }

    @Override
    public Response weighDataConfirm(WeighDataAssembleForm assembleForm) throws MaterialException {
        ServiceRequest<WeighDataAssembleForm, WeighDataAssemble> request = new WeighDataAssembleRequest(materialConfiguration, ApiService.CONFIRM, assembleForm);
        return this.doOperation(request);
    }

    private <T> T doOperation(ServiceRequest request) throws MaterialException {
        T t = null;
        Method method = request.getHttpMethod();
        switch (method) {
            case GET:
                t = HttpClient.doGet(request);
                break;
            case POST:
                t = HttpClient.doPost(request);
                break;
            case DELETE:
                t = HttpClient.doDelete(request);
                break;
            case PUT:
                t = HttpClient.doPut(request);
                break;
        }
        return t;
    }

}
