package by.itacademy.jd2.mkjd295224.fitnessstudio.mail.service;

import java.util.Random;

public final class CodeGenerationUtil {

    public static final int LEFT_LIMIT = 48;
    public static final int RIGHT_LIMIT = 122;
    public static final int TARGET_STRING_LENGTH = 10;

    private CodeGenerationUtil() {
        throw new IllegalStateException("Util class");
    }

    public static String generateCode() {
        Random random = new Random();
        return random.ints(LEFT_LIMIT, RIGHT_LIMIT + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(TARGET_STRING_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
