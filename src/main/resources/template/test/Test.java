package ${package}.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author ${author}
 * @date ${date}
 */
public class ${rule.name}Test {

    @Test
    public void test() {
        JavaCheckVerifier.verify("src/test/files/${rule.name}Check.java", new ${rule.name}Rule());
    }
}
