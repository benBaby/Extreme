package com.apt_compiler;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.VariableElement;

import apew.com.apt_annotation.BindView;

/**
 * Instructions :
 * Created by ZZ on 2018/5/7.
 */

public class BindViewField {
    private VariableElement mFieldElement;
    private int mResId;

    public BindViewField(Element element) throws IllegalArgumentException {
        if (element.getKind() != ElementKind.FIELD) {
            throw new IllegalArgumentException(
                    String.format("Only fields can be annotated with @%s", BindView.class.getSimpleName()));
        }

        mFieldElement = (VariableElement) element;
        BindView bindView = mFieldElement.getAnnotation(BindView.class);
        mResId = bindView.value();
    }

    public Object getFieldName() {
        return mFieldElement.getSimpleName();
    }

    public Class<?> getFieldType() {
        return mFieldElement.getClass();
    }

    public Object getResId() {
        return mResId;
    }
    // some getter methods

}
