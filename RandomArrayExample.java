public class RandomArrayExample {
    public static void main(String[] args) {
        // Specify the size of the array
        //public int N = 1000;
         int N = 1000;
         int[] randomArray = new int[N];
        // Create an array to store random numbers
        

        // Populate the array with random numbers
        for(int i = 0; i < N; i++) {
          randomArray[i] = (int)(Math.random() * N); // Generates a random double between 0.0 (inclusive) and 1.0 (exclusive)
        }

        // Print the populated array
        for(int i = 0; i < N; i++) {
          System.out.println("Random Array Element " + (i + 1) + ": " + randomArray[i]);
        }      
    }
}