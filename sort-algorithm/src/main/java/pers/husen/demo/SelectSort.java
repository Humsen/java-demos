package pers.husen.demo;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author 何明胜
 * @version 1.0
 * @since 2019年2月28日 下午9:50:20
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] array = new int[]{5, 4, 6, 9, 0, 7, 6, 8, 4, 3, 2, 7, 8};
		selectSort(array);

		System.out.println(Arrays.toString(array));
	}

	public static void selectSort(int[] array) {
		// 遍历所有的数
		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			// 记录最小数的下标
			for (int j = i + 1; j < array.length; j++) {
				// 如果后面的数比最小的数小
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}

			// 如果最小的不是当前下标，交换
			if (i != minIndex) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}
}
