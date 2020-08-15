package ${package}.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.List;

/**
 * @author ${author}
 * @date ${date}
 */
@Rule(key = "${rule.name}")
public class ${rule.name}Rule extends IssuableSubscriptionVisitor {
    @Override
    public List<Tree.Kind> nodesToVisit() {
//        return ImmutableList.of(Tree.Kind.MEMBER_SELECT, Tree.Kind.METHOD);
//        return Collections.singletonList(Tree.Kind.VARIABLE);
        return null;
    }

    @Override
    public void visitNode(Tree tree) {
        super.visitNode(tree);
    }

    @Override
    public void leaveNode(Tree tree) {
        super.leaveNode(tree);
    }

    @Override
    public void scanFile(JavaFileScannerContext context) {
        super.scanFile(context);
    }
}
