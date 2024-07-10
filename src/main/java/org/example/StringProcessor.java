package org.example;
public class StringProcessor {

    // 移除连续3个或更多相同字符的方法
    public static String removeConsecutiveDuplicates(String input) {
        StringBuilder sb = new StringBuilder(input);
        int i = 0;
        while (i < sb.length() - 2) {
            if (sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(i + 1) == sb.charAt(i + 2)) {
                int j = i + 2;
                while (j < sb.length() && sb.charAt(j) == sb.charAt(i)) {
                    j++;
                }
                sb.delete(i, j);
                // 注意：由于已经删除了字符，不需要增加i
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    // 场景2: 替换连续相同的字符为它们之前的那个字符
    // 辅助函数，用于替换连续三个及三个以上相同的字符
    private static String replaceConsecutiveWithPrevious(String input) {
        StringBuilder sb = new StringBuilder(input);
        boolean changed = true;

        while (changed) {
            changed = false;
            int i = 0;
            while (i < sb.length() - 2) {
                char currentChar = sb.charAt(i);
                if (sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(i + 1) == sb.charAt(i + 2)) {
                    // 找到连续三个相同的字符
                    char prevChar = (char) ('a' + (currentChar - 'a' - 1 + 26) % 26); // 正确的回绕逻辑
                    int length = 3;
                    // 检查是否还有更多连续的相同字符
                    while (i + length < sb.length() && sb.charAt(i + length) == currentChar) {
                        length++;
                    }

                    // 替换为之前的那个字符
                    for (int j = i; j < i + length; j++) {
                        sb.setCharAt(j, prevChar);
                    }

                    // 跳过已经替换的部分
                    i += length - 1;
                    changed = true; // 标记为已更改，以便再次检查
                } else {
                    i++;
                }
            }
        }

        return sb.toString();
    }
    // 重复应用方法直到没有连续3个或更多相同字符
    public static String processString(String input, boolean remove) {
        String result = input;
        while (true) {
            String nextResult = remove ? removeConsecutiveDuplicates(result) : replaceConsecutiveWithPrevious(result).toString();
            System.out.println("change after:"+nextResult);
            if (nextResult.equals(result)) {
                break;
            }
            result = nextResult;
        }
        return result;
    }

}
