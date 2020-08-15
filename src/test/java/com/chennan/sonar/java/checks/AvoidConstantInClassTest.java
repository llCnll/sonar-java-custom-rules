package com.chennan.sonar.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author cn
 * @date 2020-07-07 14:35
 */
public class AvoidConstantInClassTest {

    @Test
    public void test(){
        JavaCheckVerifier.verify("src/test/files/AvoidConstantInClassCheck.java", new AvoidConstantInClassRule());
    }
}
