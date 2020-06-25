package com.billkang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 单词搜索 II
 * <p>
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 提示:
 * <p>
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 */
public class FindWords {

    private static class Trie {
        String word;  //单词结束标志，到这里说明已经可以组成一个单词了。

        Trie[] next = new Trie[26]; //每个节点都有26个节点

        Trie append(char ch) {
            if (next[ch - 'a'] == null) {
                next[ch - 'a'] = new Trie();
            }
            return next[ch - 'a'];
        }
    }

    private boolean[][] visited; //判断是否参加过
    List<String> res = new ArrayList();

    public List<String> findWords(char[][] board, String[] words) {
        Trie root=new Trie();
        for(String word:words){  //先把单词存入字典树当中
            Trie cur=root;
            char[] wd=word.toCharArray();
            for(char c:wd){
                cur=cur.append(c);
            }
            cur.word=word;  //结束标志，说明到这里已经可以组成一个单词
        }
        res=new ArrayList<String>();
        visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;++i){  //对board每一个点都进行检索
            for(int j=0;j<board[i].length;++j){
                dfs(root,i,j,board);
            }
        }
        Collections.sort(res);  //需要对结果进行排序
        return new ArrayList<String>(res);
    }

    public void dfs(Trie cur,int x,int y,char[][] board){
        if(x<0||y<0||x>=board.length||y>=board[0].length||visited[x][y]){
            return;
        } //边界返回
        cur=cur.next[board[x][y]-'a'];  //延伸下一个节点
        visited[x][y]=true; //把当前设置为走过 不可重复走
        if(cur!=null){ //如果当前不为null的话 可以继续检索
            if(cur.word!=null){ //说明到这里已经可以组成一个单词了
                res.add(cur.word);
                cur.word=null; //变成null是为了防止重复加入单词
            }

            dfs(cur,x+1,y,board); //四个方向检索
            dfs(cur,x-1,y,board); //四个方向检索
            dfs(cur,x,y+1,board); //四个方向检索
            dfs(cur,x,y-1,board); //四个方向检索

        }
        visited[x][y]=false; //回溯，把visited置为false，供一个单词匹配时用
    }
}
