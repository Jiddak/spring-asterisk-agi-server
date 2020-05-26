package com.jidda.spring_asterisk_agi_server.configuration.agi.annotations;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface AgiBean {
    String value() default "";
}
