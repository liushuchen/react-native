/**
 * files
 *
 * @Title: ValidatorConfig.java<br>
 * @Description: <br>
 * @author lsc<br>
 * @date 2018年9月29日<br>
 * @version 1.0<br>
 * @Copyright:Copyright Taikanglife.All Rights Reserved <br>
 * 注意：本内容仅限于泰康保险集团内部传阅，禁止外泄以及用于其他的商业 <br>
 */
package com.httd.api.filter;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author lsc
 *
 */
@Configuration
public class ValidatorConfig {

    @Bean
    public Validator validator() {
        Validator validator = Validation.byProvider(HibernateValidator.class).configure().failFast(true)
                .buildValidatorFactory().getValidator();
        return validator;
    }
}
