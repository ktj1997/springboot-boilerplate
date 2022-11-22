package spring.layer.template;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Test
@Tag("unit")
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnitTest {}
