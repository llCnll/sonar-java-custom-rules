package com.chennan.sonar.java.checks;

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
@Rule(key = "AvoidConstantInClass")
public class AvoidConstantInClassRule extends IssuableSubscriptionVisitor {
    @Override
    public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.VARIABLE);
    }

    @Override
    public void visitNode(Tree tree) {
        VariableTree param = (VariableTree)tree;
        if(checkPublicStaticString(param)){
            reportIssue(param, "Constant~");
            System.out.print("modifier: ");
            param.modifiers().stream().forEach(modifier -> System.out.print(modifier.firstToken().text()+" "));
            System.out.println();
            System.out.println("type: "+param.type());
            System.out.println("name: "+param.simpleName());
            System.out.println("value: "+ param.initializer().firstToken().text());
            System.out.println("============================");
        }
    }

    public boolean checkPublicStaticString(VariableTree param){
        return param.symbol().isPublic() && param.symbol().isStatic() && param.symbol().isFinal()&&"String".equals(param.type().toString());
    }
}
