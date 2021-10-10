package dev.ricecx.augmentedsmp.core.file;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigAdapter {
    Class<? extends ConfigSerializable> adapter() default ConfigSerializable.class;
}
