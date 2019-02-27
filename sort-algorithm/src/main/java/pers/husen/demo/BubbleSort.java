package pers.husen.demo;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author 何明胜
 * @version 1.0
 * @since 2019年2月27日 下午7:48:00
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] array = new int[]{5, 4, 6, 9, 0, 7, 6, 8, 4, 3, 2, 7, 8};
		bubbleSort(array);

		System.out.println(Arrays.toString(array));
	}

	public static void bubbleSort(int[] array) {
		int length = array.length;
		// 排序次数
		for (int i = 0; i < length - 1; i++) {
			// 每次从0开始与右边一个数比较，如果比右边一个大，则交换（实现冒泡）
			for (int j = 0; j < length - 1 - i; j++) {
				if (array[j] <= array[j + 1]) {
					continue;
				}

				int temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
	}
}
