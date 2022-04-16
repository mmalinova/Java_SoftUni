package softuni.exam.util;

import javax.validation.ConstraintViolation;


public interface ValidationUtil {

    <T> boolean isValid(T entity);
}
