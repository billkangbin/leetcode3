package com.billkang;

/**
 *  551. Student Attendance Record I
 *  You are given a string representing an attendance record for a student. The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
 * @author binkang
 * @date May 23, 2017
 */
public class StudentAttendanceRecord1 {
	public boolean checkRecord(String s) {
		int a = 0;
		int l = 0;
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c == 'P') {
				l = 0;
				continue;
			} else if (c == 'A') {
				l = 0;
				a++;
				if (a > 1) return false;
			} else {
				l++;
				if (l > 2) return false;
			}
		}
		return true;
	}
}
