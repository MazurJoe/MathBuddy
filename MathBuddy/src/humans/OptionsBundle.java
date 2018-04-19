/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humans;

/**
 *
 * @author John Rosser
 */
public class OptionsBundle {
    private int min,max;
    private String operation;
    private boolean integersOnly;

    public OptionsBundle(int min, int max, String operation, boolean integersOnly) {
        this.min = min;
        this.max = max;
        this.operation = operation;
        this.integersOnly = integersOnly;
    }
    

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public String getOperation() {
        return operation;
    }

    public boolean isIntegersOnly() {
        return integersOnly;
    }
    
}
