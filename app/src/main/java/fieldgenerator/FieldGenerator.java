package fieldgenerator;

public class FieldGenerator
{
    private int[] field;
    private String startColor;

    public int[] getField() {
        return field;
    }

    public String getStartColor() { return startColor; }
    
    private int getRandomInt(int minVal, int maxVal) {

        int randomNumber = minVal + (int)(Math.random() * ((maxVal - minVal) + 1));
        
        return randomNumber;
    }
    
    public void generate() {
        
        int plusCount = 9 ;
        int minusCount = 8;
        int neutralCount = 7;
        //int spyCount = 1;
        int randomNumber;
        
        // Initialize field
        field = new int[25];


        // Set start color
        randomNumber = getRandomInt(0,1);
        if (randomNumber==1)
            startColor = "blue";
        else
            startColor = "red";
        
        // Populate
        for(int i = 24; i >= 0; i--) {
            
            // Random number
            randomNumber = getRandomInt(1,i + 1);
            
            // Get field
            if (randomNumber <= plusCount) {
                field[i] = 1;
                plusCount--;
            }    
            else if (randomNumber <= (plusCount + minusCount)) {
                field[i] = -1;
                minusCount--;
            } else if (randomNumber <= (plusCount + minusCount + neutralCount)) {
                neutralCount--;
            } else {
                field[i] = 9;
            }
            
        }
     
    }
    
    void print() { 
    
        System.out.println("New field:");
        
        for(int i = 0; i < 5; i++) {

            for(int j = 0; j < 5; j++) {
                System.out.print(field[i*5 + j] + " ");
            }
            System.out.println("");
        }
    
    }
    
}
