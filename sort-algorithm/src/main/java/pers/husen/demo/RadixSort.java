package pers.husen.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 基数排序
 *
 * @author 何明胜
 * @version 1.0
 * @since 2019年2月28日 下午11:21:55
 */
public class RadixSort {
	public static void main(String[] args) {
		Integer[] array = new Integer[]{54, 4, 6, 956, 0, 74, 6, 8, 4462, 3,
				2263, 7, 58624, 11, 765, 29};

		System.out.println(Arrays.toString(radixSort(array)));
	}

	public static Integer[] radixSort(Integer[] array) {
		// 找出数组中最大数的长度
		int max = Integer.MIN_VALUE;
		for (int integer : array) {
			if (integer > max) {
				max = integer;
			}
		}
		// 计算最大位数
		int maxLength = String.valueOf(max).length();

		// 存储的数组
		List<List<Integer>> storageList = buildStorageList(array.length);
		// 原始数据转成数组
		List<Integer> originList = new ArrayList<>(array.length);
		Collections.addAll(originList, array);
		// 根据最大长度决定比较次数
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			// 计算每个数字的相应位数的余数
			for (int j = 0; j < originList.size(); j++) {
				int remainder = originList.get(j) / n % 10;
				storageList.get(remainder).add(originList.get(j));
			}

			// 数字按顺序放回数组，并注意清除数据
			originList.clear();
			for (List<Integer> intList : storageList) {
				originList.addAll(intList);
				intList.clear();
			}
		}

		return originList.toArray(new Integer[originList.size()]);
	}

	/**
	 * 构建基数排序存储的列表
	 * 
	 * @param size
	 * @return
	 */
	public static List<List<Integer>> buildStorageList(int size) {
		List<List<Integer>> storageList = new ArrayList<List<Integer>>(10);
		for (int i = 0; i < 10; i++) {
			storageList.add(new ArrayList<>(size));
		}

		return storageList;
	}
}
