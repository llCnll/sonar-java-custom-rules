package org.sonar.samples.java.checks;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.VariableTree;

import java.util.Collections;
import java.util.List;

/**
 * @author cn
 * @date 2020-07-07 14:36
 */
@Rule(
        key = "MyStaticCheck",
        name = "Constant should not in the class",
        description = "Constant should write into file.",
        priority = Priority.CRITICAL,
        tags = {"bug"})
public class MyStaticCheck extends IssuableSubscriptionVisitor {
    @Override
    public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.VARIABLE);
    }

    @Override
    public void visitNode(Tree tree) {
        VariableTree param = (VariableTree)tree;
        if(checkPublicStaticString(param)){
            reportIssue(param, "是静态常量~");
            System.out.print("修饰符: ");
            param.modifiers().stream().forEach(modifier -> System.out.print(modifier.firstToken().text()+" "));
            System.out.println();
            System.out.println("变量类型: "+param.type());
            System.out.println("变量名称: "+param.simpleName());
            System.out.println("变量值: "+ param.initializer().firstToken().text());
        }
    }

    public boolean checkPublicStaticString(VariableTree param){
        return param.symbol().isPublic() && param.symbol().isStatic() && param.symbol().isFinal();
    }
}
