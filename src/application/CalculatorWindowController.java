package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
public class CalculatorWindowController {

	 @FXML
	    private TextArea historyTA;

	    @FXML
	    private TextField operationTF;

	    @FXML
	    private TextField resultTF;

	    private ArrayList<String>operations = new ArrayList<>();

	    @FXML
	    void calculateClick(ActionEvent event) {
	    	int result =0;
	  
	    	String value="";
	    	String one="";
	    	String two="";
	    	value = operationTF.getText();
	    	char[]numbers = value.toCharArray();
	    	int a=0;
	        char simbol='0';
	       for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]=='+'||numbers[i]=='-'||numbers[i]=='*'||numbers[i]=='/') {
				a=i;
				simbol=numbers[i];
			}
		   }
	        
	       for(int i=0;i<a;i++) {
	    	   one+=String.valueOf(numbers[i]);
	       }
	       for(int i=a+1;i<numbers.length;i++) {
	    	   two+=String.valueOf(numbers[i]);
	       }
	       if(one!=""&&two!="") {
	       if(simbol=='+') {
	    	   int oneS=Integer.parseInt(one);
	    	   int twoS=Integer.parseInt(two);
	    	   result=oneS+twoS;
	       }
	       if(simbol=='-') {
	    	   int oneS=Integer.parseInt(one);
	    	   int twoS=Integer.parseInt(two);
	    	   result=oneS-twoS;
	    	    
	       }
	       if(simbol=='*') {
	    	   int oneS=Integer.parseInt(one);
	    	   int twoS=Integer.parseInt(two);
	    	   result=oneS*twoS;
	       }
	       if(simbol=='/') {
	    	   double oneS=Double.parseDouble(one);
	    	   double twoS=Double.parseDouble(two);
	    	   double resultD=oneS/twoS;
	    	   DecimalFormat df = new DecimalFormat("#.00");
	           resultTF.setText(df.format(resultD));
	           String operation = operationTF.getText()+" = "+resultTF.getText();
		       operations.add(operation);
	           operationTF.setText("");
	       }
	       if(simbol=='+'||simbol=='-'||simbol=='*') {
	       String resultFinal=String.valueOf(result);
	       resultTF.setText(resultFinal);
	       String operation = operationTF.getText()+" = "+resultTF.getText();
	       operations.add(operation);
	       operationTF.setText(resultFinal);
	       }
	       
	       
		}
	       String text="";
	       for (int i = 0; i < operations.size(); i++) {
			text+= operations.get(i)+"\n";
	       }
	       historyTA.setText(text);
	    }

	    @FXML
	    void clickNumber(ActionEvent event) {
	    	Button operation = (Button) event.getSource();
	    	String text =operation.getText();
	    
	    	operationTF.appendText(text);
	    	
	    }
	    @FXML
	    void deleteClick(ActionEvent event) {
          operationTF.setText("");
          resultTF.setText("");
	    }
	    @FXML
	    void percentageClick(ActionEvent event) {
          String operation = operationTF.getText();
          double value = Double.parseDouble(operation);
          double result = value*0.1;
          DecimalFormat df = new DecimalFormat("#.00");
          resultTF.setText(df.format(result));
          String n = " % "+ operationTF.getText()+" = "+resultTF.getText();
          operations.add(n);
          operationTF.setText("");
	    }

     
	  

}
