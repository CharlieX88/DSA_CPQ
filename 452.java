class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort balloons by their end position (right boundary)
        // Using comparingInt to avoid integer overflow that would occur with direct subtraction
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
      
        // Initialize the count of arrows needed
        int arrowCount = 0;
      
        // Track the position of the last arrow shot
        // Initialize to a very small value to ensure first balloon always needs an arrow
        long lastArrowPosition = -(1L << 60);
      
        // Iterate through each balloon
        for (int[] balloon : points) {
            int startPosition = balloon[0];
            int endPosition = balloon[1];
          
            // If current balloon's start is beyond the last arrow's position,
            // we need a new arrow
            if (startPosition > lastArrowPosition) {
                arrowCount++;
                // Shoot the arrow at the current balloon's end position
                // This maximizes the chance of hitting subsequent balloons
                lastArrowPosition = endPosition;
            }
        }
      
        return arrowCount;
    }
}