package com.github.nez.nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class PartsOfSpeech {

    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        String text = "Although I really like video games, I want to create a sustainable life for myself so that I may continue to enjoy the things I love.";
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> list = coreDocument.tokens();
        for (CoreLabel coreLabel: list) {
            String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            System.out.println(coreLabel.originalText()+ "=" + pos);
        }

    }
}
