package com.github.nez.nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class TokenizeExample {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP= Pipeline.getPipeline();
        String text = "This is Montaniz Stills";
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabelList= coreDocument.tokens();
        for (CoreLabel coreLabel:  coreLabelList) {
            System.out.println("The core label is: "+coreLabel+"\n"+
                    "the core label original text is: "+ coreLabel.originalText()
                    );
        }
    }
}
