package br.dmppka.usermanager.server.converter;

import br.dmppka.usermanager.client.view.View;
import br.dmppka.usermanager.server.model.Model;
import org.dozer.CustomConverter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class ModelConverter<T extends Model> implements CustomConverter {

    public Object convert(Object dst, Object src, Class<?> dstClass, Class<?> srcClass) {
        if (src instanceof HashMap) return convertTo((Map<String, Serializable>) src);
        T model = (T) src;
        Map<String, Serializable> result = convertFrom(model);
        populateRedirectURI(result, model);
        return result;
    }

    private void populateRedirectURI(Map<String, Serializable> result, Model model) {
        String redirectURI = model.getRedirectURI();
        if (redirectURI != null) {
            result.put(View.MODEL_REDIRECT_URI, redirectURI);
        }
    }

    protected abstract Map<String, Serializable> convertFrom(T model);
    protected abstract T convertTo(Map<String, Serializable> map);
}
