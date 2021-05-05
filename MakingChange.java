public class MakingChange {
        public static int minimumCoins(int money, int[] coins) {
                    // m is size of coins array (number of different coins
                    // minCoinsCount[i] will be storing the minimum number of coins required for i value. So minCoinsCount[money] will have result
                    int m=coins.length;
                    int minCoinsCount[] = new int[money + 1];
                    // Base case (If given value V is 0)
                    minCoinsCount[0] = 0;
                    // Initialize all minCoinsCount values as Infinite
                    for (int i = 1; i <= money; i++)
                        minCoinsCount[i] = Integer.MAX_VALUE;
                    // Compute minimum coins required for all values from 1 to money
                    for (int i = 1; i <= money; i++)
                    {       // Go through all coins smaller than i
                        for (int j = 0; j < m && coins[j] <= i; j++)
                            if (coins[j] <= i)
                            {
                                //int sub_res = minCoinsCount[i - coins[j]];
                                if (minCoinsCount[i - coins[j]] != Integer.MAX_VALUE && 1 + minCoinsCount[i - coins[j]]  < minCoinsCount[i])
                                    minCoinsCount[i] = 1 + minCoinsCount[i - coins[j]];
                            }
                    }
                    if(minCoinsCount[money]==Integer.MAX_VALUE)
                        return -1;
                    return minCoinsCount[money];
                }
                // Driver program
                public static void main (String[] args)
                {
                    int coins[] = {3,2};
                    int m = coins.length;
                    int V = 11;
                    System.out.println ( "Minimum coins required is "+ minimumCoins( V,coins));
                }
            }




