package cn.rookie;

/**
 * Created by Rookie on 2016/4/23.
 * Package name is cn.rookie
 * Description:
 */
public class StringUtils {

    /**
     * 判断给定的字符串是否为空，以及空字符串
     * @param input
     * @return
     */
    public static boolean blank(String input) {
        return input == null || "".equals(input) || input.length() == 0 || input.trim().length() == 0;
    }

    /**
     * 判断给定的字符串不为空
     * @param input
     * @return
     */
    public static boolean notBlank(String input) {
        return !blank(input);
    }

    /**
     * 首字母大写
     * @param input
     * @return
     */
    public static String toFirstUpperCase(String input) {
        return blank(input) ? input : input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
