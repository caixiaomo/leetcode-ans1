/*
 * Given n, how many structurally unique BST's (binary 
 * search trees) that store values 1...n?

 * For example,
 * Given n = 3, there are a total of 5 unique BST's.

 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = result[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result[i] += result[j - 1] * result[i - j];
            }
        }
        return result[n];
    }

/******************** updated 2013/11/19 ***********************/

    public int numTrees(int n) {
        if(n == 0 || n == 1)
            return 1;
        int num = 0;
        for(int i = 0; i < n; i++) 
            num += numTrees(i) * numTrees(n - 1 - i);
        return num;
    }

/***************************************************************/

    public int numTrees(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * (n + 1 + i) / (i + 1);
        }
        result /= n + 1;
        return result;
    }

}
