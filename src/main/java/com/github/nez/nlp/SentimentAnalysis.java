package com.github.nez.nlp;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class SentimentAnalysis {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        String text= "Ok, so maybe I am feeling a little guilty for not studying as hard as I should have at Perscholas. But I will give all my praise to God for He has brought me through -- and over high mountains!";
        String text2 = "America is involved in a war and is losing";
        String text3 = "I am feeling great.";
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreSentence> coreSentenceList = coreDocument.sentences();
        for(CoreSentence sentence: coreSentenceList){
            String sentiment = sentence.sentiment();
            System.out.println(sentiment+"\t"+sentence);
        }
        // inferring sentiments
    }
}
