import static java.lang.Math.min;

public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int largest = (r - l) * min(heights[l], heights[r]);

        while (l < r) {
            if (heights[l] < heights[r]) l++;
            else r--;

            int area = (r - l) * min(heights[l], heights[r]);
            if (largest < area) {
                largest = area;
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] heights2 = {1, 1};

        ContainerWithMostWater container = new ContainerWithMostWater();
        System.out.println(container.maxArea(heights));
        System.out.println(container.maxArea(heights2));
    }
}
