public class EditDistance {
    public static int editDistance(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        // Create a DP array to memoize result of previous computations
        int [][]DP = new int[2][len1 + 1];
        // Start filling the DP -- This loop run for every character in second String
        for (int i = 0; i <= len2; i++)  //This loop compares the char from second String with first String characters
        {
            for (int j = 0; j <= len1; j++)
            {   // If first string is empty, only option is to insert all characters of second string
                if (i == 0)
                    DP[i % 2][j] = j;
                    // If second string is empty, only option is to remove all characters of first string
                else if (j == 0)
                    DP[i % 2][j] = i;
                    // if character from both String is same then we do not perform any operation . here i % 2 is for bound the row number.
                else if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    DP[i % 2][j] = DP[(i - 1) % 2][j - 1];
                }
                // if character from both String is not same then we take the minimum from three specified operation
                else {
                    DP[i % 2][j] = 1 + Math.min(DP[(i - 1) % 2][j], Math.min(DP[i % 2][j - 1], DP[(i - 1) % 2][j - 1]));
                } } }
        // after complete fill the DP array if the len2 is even then we end up in the 0th row else we end up in the 1th row so we take len2 % 2 to get row
        return DP[len2 % 2][len1];
    }
    public static void main(String[] args)
    {
        String str1 = "cat";
        String str2 = "gattt";
        int a=editDistance(str1, str2);
        System.out.print(a);
    }
}