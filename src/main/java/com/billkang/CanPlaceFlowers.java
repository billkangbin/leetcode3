package com.billkang;

/**
 * @author binkang
 * @date Jun 4, 2017
 */
public class CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(flowerbed==null || flowerbed.length ==0) {
			return false;
		}
		if(n==0) {
			return true;
		}
		int len = flowerbed.length;
		if(len==1) {
			return flowerbed[0]==0;
		}
		
		int count=0;
		for(int i=0;i<len;i++) {
			if(flowerbed[i]==0) {
			if(i==0){
				if(flowerbed[i+1]==0) {
				flowerbed[i]=1;
				count++;
				if(count==n) {
					return true;
				}
				}
			} else if(i==len-1){
				 if(flowerbed[i-1]==0) {
				flowerbed[i]=1;
				count++;
				if(count==n) {
					return true;
				}
				 }
			} else if(flowerbed[i-1]==0 && flowerbed[i+1]==0) {
				flowerbed[i]=1;
				count++;
				if(count==n) {
					return true;
				}
			}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		new CanPlaceFlowers().canPlaceFlowers(new int[]{1,0,1,0,1,0,1}, 1);
	}
}
