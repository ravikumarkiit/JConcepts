package samplePrograms;

public class NumericTextInputSeparate {
    
    
    public static class TextInput {
        String value="";
        
        void add(char c) {
            value.concat(Character.toString(c));
        }
        
        String getValue() {
            return value;
        }
    }

    public static class NumericInput extends TextInput {
    	
    	void add(char c) {
    		try {
    			if(Character.isDigit(c)) {
    				value = value.concat(Character.toString(c));
        		}
    		} catch(Exception excp) {
    		}
    		
    		/*try {
    			value = value.concat(String.valueOf(Integer.parseInt(Character.toString(c))));
    		} catch(Exception excp) {
    		}*/
        }
    	
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}