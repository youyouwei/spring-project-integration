package spring.project.integration.springdemoapp.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 20:46 2021/1/27
 */
public class Demo {

    public static void main(String[] args) {

        int[] strs = {1, 1, 3, 2, 4, 4};
        System.out.println(sort(strs, 2));
    }

    private static Map<Integer, Integer> sort(int[] strs, int n) {
        if (strs == null || strs.length == 0) {
            return new HashMap<>();
        }

        Map<Integer, Integer> tempMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            if ((tempMap.get(strs[i])) != null) {
                tempMap.put(strs[i], tempMap.get(strs[i]) + 1);
            } else {
                tempMap.put(strs[i], 1);
            }
        }
        Integer[] keys = new Integer[]{};
        keys = tempMap.keySet().toArray(keys);
        quickSort(keys, 0, keys.length - 1);
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            result.put(keys[i], tempMap.get(keys[i]));
        }
        return result;
    }

    //快速排序
    public static void quickSort(Integer[] x, int low, int high) {
        if (low < high) {
            int index = partSort(x, low, high);
            quickSort(x, low, index - 1);
            quickSort(x, index + 1, high);
        }
    }

    public static int partSort(Integer[] x, int low, int high) {
        int mid = x[low];
        while (low < high) {
            while (low < high && x[high] >= mid) {
                high--;
            }
            x[low] = x[high];
            while (low < high && x[low] <= mid) {
                low++;
            }
            x[high] = x[low];
        }
        x[low] = mid;
        return low;
    }


}
