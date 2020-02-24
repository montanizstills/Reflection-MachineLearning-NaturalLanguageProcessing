package com.github.nez.nlp;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

public class Pipeline {
    private static StanfordCoreNLP stanfordCoreNLP;
    private static Properties properties;
    private static String propertiesNames = "tokenize,ssplit";

    private Pipeline() {
    }

    static {
        properties=new Properties();
        properties.setProperty("annotators",propertiesNames);
    }
    public static StanfordCoreNLP getPipeline() {
        if (stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }

}

