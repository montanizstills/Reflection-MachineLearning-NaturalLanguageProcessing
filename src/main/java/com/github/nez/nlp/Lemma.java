package com.github.nez.nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.awt.*;
import java.nio.channels.Pipe;
import java.util.List;

public class Lemma {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        String text = "What are the possible uses of creating a machine learning natural language processor?";
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> list = coreDocument.tokens();
        for (CoreLabel coreLabel: list){
            String lemma = coreLabel.lemma();
            System.out.println(coreLabel.originalText()+" = "+lemma);
        }
    }
}
