package org.sonar.samples.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author cn
 * @date 2020-07-03 16:30
 */
public class MyFirstCustomCheckTest {

    @Test
    public void test(){
        JavaCheckVerifier.verify("src/test/files/MyFirstCustomCheck.java", new MyFirstCustomCheck());
    }
}
