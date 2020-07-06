[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=org.sonarsource.samples%3Ajava-custom-rules&metric=alert_status)](https://sonarcloud.io/dashboard?id=org.sonarsource.samples%3Ajava-custom-rules)

This example demonstrates how to write **Custom Rules** for SonarJava.

# 操作
1. org.sonar.samples.java.checks 添加自定义类
2. RulesList.getJavaChecks 添加刚刚自定义的类
3. 测试 test.files 创建要测试的文件
4. test.java.org.sonar.samples.java.checks 添加自定义测试类

# 注意
10.17.1.75 sonarqube版本为7.0  
因此在 #第一个自定插件 的时候, 不能使用master(要求sonarqube版本为8.1).  


使用 `git checkout 4777a3cd2e0d836f423beb697bbe293c8954b7ef`(要求sonarqube版本为6.7)  
不修改版本号的话会出现 `org.sonar.sslr.grammar.GrammarException`  
版本号修改为  
```xml
		<sonar.version>7.6</sonar.version>
		<sonarjava.version>5.0.1.12818</sonarjava.version>
```

[参考issues链接](https://github.com/SonarSource/sonar-custom-rules-examples/issues/38)