package pers.husen.demo;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author 何明胜
 * @version 1.0
 * @since 2019年2月27日 下午7:29:03
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] array = new int[]{5, 4, 6, 9, 0, 7, 6, 8, 4, 3, 2, 7, 8};
		quickSort(array, 0, array.length - 1);

		System.out.println(Arrays.toString(array));
	}

	public static void quickSort(int[] array, int start, int end) {
		// 结束标识
		if (start >= end) {
			return;
		}

		// 以第一个为标准
		int flag = array[start];
		// 记录下标
		int low = start;
		int high = end;
		// 循环把小的数放在标准左边，大的放在右边
		while (low < high) {
			// 当右边比标准大,向左移动,直到小于标准,赋值给low
			while (low < high && array[high] >= flag) {
				high--;
			}
			array[low] = array[high];
			// 当左边比标准小，向右移动，直到比标准大，赋值给high
			while (low < high && array[low] <= flag) {
				low++;
			}
			array[high] = array[low];
		}
		// 标准赋值给中间数，完成一次快排
		array[low] = flag;
		// 递归给中间数左右的数排序
		quickSort(array, start, low);
		quickSort(array, low + 1, end);
	}
}
