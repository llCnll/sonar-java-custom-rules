package com.chennan.sonar.java.template;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cn
 * @date 2020-07-23 14:17
 */
public class CreateTemplate {

    Map<String, String> propertyMap = new HashMap();
    public static final Pattern regex = Pattern.compile("\\$\\{(.*?)\\}");

    @Test
    public void createTemplate() {
        createRule();
        createHtml();
        createJson();
        createTestFile();
        createTestJunit();
    }

    private void createTestJunit() {
        String templateTestJunitURL = propertyMap.get("src.address") + propertyMap.get("template.test.junit.address");
        String destTestJunitURL = propertyMap.get("src.address") + propertyMap.get("test.junit.address") + propertyMap.get("rule.name") + "Test.java";

        createFile(templateTestJunitURL, destTestJunitURL);
    }

    private void createTestFile() {
        String templateTestFileURL = propertyMap.get("src.address") + propertyMap.get("template.test.file.address");
        String destTestFileURL = propertyMap.get("src.address") + propertyMap.get("test.file.address") + propertyMap.get("rule.name") + "Check.java";

        createFile(templateTestFileURL, destTestFileURL);
    }

    private void createJson() {
        String templateJsonURL = propertyMap.get("src.address") + propertyMap.get("template.squid.json.address");
        String destJsonURL = propertyMap.get("src.address") + propertyMap.get("squid.address") + propertyMap.get("rule.name") + "_json.html";

        createFile(templateJsonURL, destJsonURL);
    }

    private void createHtml() {
        String templateHtmlURL = propertyMap.get("src.address") + propertyMap.get("template.squid.html.address");
        String destHtmlURL = propertyMap.get("src.address") + propertyMap.get("squid.address") + propertyMap.get("rule.name") + "_java.html";

        createFile(templateHtmlURL, destHtmlURL);
    }

    private void createRule() {
        String templateRuleURL = propertyMap.get("src.address") + propertyMap.get("template.rule.address");
        String destRuleURL = propertyMap.get("src.address") + propertyMap.get("rule.address") + propertyMap.get("rule.name") + "Rule.java";

        createFile(templateRuleURL, destRuleURL);
    }

    private void createFile(String templateURL, String destURL) {
        try (FileReader reader = new FileReader(templateURL);
             FileWriter writer = new FileWriter(destURL, false);
             BufferedReader br = new BufferedReader(reader)) {
            String str = null;
            while ((str = br.readLine()) != null) {
                writer.write(replacePlaceHolder(str) + "\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String replacePlaceHolder(String str) {
        Matcher matcher = regex.matcher(str);
        while (matcher.find()) {
            String placeHolder = matcher.group(0);
            String key = matcher.group(1);
            str = str.replace(placeHolder, propertyMap.get(key));
        }
        return str;
    }

    @Before
    public void loadProperties() throws Exception {
        Properties properties = new Properties();
        InputStream in = CreateTemplate.class.getClassLoader().getResourceAsStream("template/property.properties");
        properties.load(in);
        properties.stringPropertyNames().forEach(key -> {
            propertyMap.put(key, (String) properties.get(key));
        });
    }
}
