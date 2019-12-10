package com.sample;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.logger.*;

import javax.swing.JOptionPane;


/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
        	KieServices ks = KieServices.Factory.get();
     	    KieContainer kContainer = ks.getKieClasspathContainer();
         	KieSession kSession = kContainer.newKieSession("ksession-rules");
         	KieRuntimeLogger kLogger = ks.getLoggers().newFileLogger(kSession, "test");
         	
             // go !

            kSession.fireAllRules();
            kLogger.close();
        
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public static class UiHandler{
    	
    	
		public static String showQuestionAndGetAnswer(String question, Object[] answers){
    		JOptionPane questionPane = new JOptionPane();
    		int result = questionPane.showOptionDialog(null, question, "ChooseTheGame", 
    		JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, answers, null);
    		return (String) answers[result];
    	}
    	
		public static void showDialog(String text){
			JOptionPane questionPane = new JOptionPane();
			questionPane.showMessageDialog(null, text, "ChooseTheGame", JOptionPane.PLAIN_MESSAGE);
		}	
		
    }


}
