package pzl.study;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 示例 1：
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
// 示例 2：
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
// 示例 3：
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
//
// 示例 4：
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
//
// 示例 5：
//输入：nums1 = [2], nums2 = []
//输出：2.00000
//
// 提示：
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
// Related Topics 数组 二分查找 分治
// 👍 4478 👎 0
public class Demo0004 {
    public static void main(String[] args) {
        Demo0004 demo = new Demo0004();
        int[] a = {1}, b={};
        System.out.println(demo.findMedianSortedArrays(a, b));
    }

    /**
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:39.7 MB,击败了39.06% 的Java用户
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int count = len >>> 1;
        int isRemain = len % 2;
        int[] newArr = new int[count + 1];
        int i = 0, index1 = 0, index2 = 0;
        while (i < newArr.length) {
            if (index1 == nums1.length) {
                newArr[i++] = nums2[index2++];
                continue;
            }
            if (index2 == nums2.length) {
                newArr[i++] = nums1[index1++];
                continue;
            }
            if (nums1[index1] <= nums2[index2]) {
                newArr[i++] = nums1[index1++];
            } else {
                newArr[i++] = nums2[index2++];
            }
        }
        return isRemain == 1 ? newArr[count] : (double) (newArr[count] + newArr[count - 1]) / 2;
    }
}
