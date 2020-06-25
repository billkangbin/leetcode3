package com.billkang;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class MedianFinder {
    //中位数为前半部分的最大值，后半部分的最小值；堆实现，两个堆大小差值不超过1

    PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> minQueue;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxQueue = new PriorityQueue<>((a,b)->b-a);
        minQueue = new PriorityQueue<>();
    }
    public void addNum(int num) {
        if(maxQueue.isEmpty() || num<=maxQueue.peek()){
            maxQueue.add(num);
        }else{
            minQueue.add(num);
        }
        if(maxQueue.size()==minQueue.size()+2){
            minQueue.add(maxQueue.poll());
        }
        if(minQueue.size()==maxQueue.size()+2){
            maxQueue.add(minQueue.poll());
        }
    }

    public double findMedian() {
        if(maxQueue.size()==minQueue.size()){
            return (double)(maxQueue.peek()+minQueue.peek())/2;
        }else{
            if(maxQueue.size()>minQueue.size()){
                return maxQueue.peek();
            }else {
                return minQueue.peek();
            }
        }
    }
}
