package com.jtc.LogisticCommodities.LogisticCommodity.Service;


import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;


@Component
public class CommodityObjectValidator {
    private Validator validator;
}
