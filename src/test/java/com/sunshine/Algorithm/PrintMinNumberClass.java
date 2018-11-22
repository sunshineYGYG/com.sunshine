package com.sunshine.Algorithm;

import org.junit.Test;

public class PrintMinNumberClass {

    private void print(String[] ss){
        for(String s:ss){
            System.out.print(s+" ");
        }
        System.out.println();
    }

    @Test
    public void test(){
        int[] numbers={4,32,3,321};
        PrintMinNumber(numbers);
    }

    public String PrintMinNumber(int [] numbers) {
        String[] numStrs=new String[numbers.length];
        int maxlen=0;
        for(int i=0;i<numbers.length;i++){
            String s=numbers[i]+"";
            numStrs[i]=s;
            if(maxlen<s.length()){
                maxlen=s.length();
            }
        }
        solve(numStrs,maxlen,numbers.length);
        StringBuffer sb=new StringBuffer();
        for(String s:numStrs){
            sb.append(s);
        }
        return sb.toString();
    }
    private void solve(String[] strs,int maxlen,int len){
        int pos=maxlen-1;
        String[][] ans=new String[10][len];
        int[] curPos={0,0,0,0,0,0,0,0,0,0};
        while(pos>=0){
            for(int i=0;i<len;i++){
                int tpos=pos;
                if(strs[i].length()<=tpos){
                    tpos=0;
                }
                Integer c = strs[i].charAt(tpos)-48;
                ans[c][curPos[c]++]=strs[i];
            }
            int cur=0;
            for(int i=0;i<10;i++){
                for(int j=0;j<curPos[i];j++){
                    strs[cur++]=ans[i][j];
                }
                curPos[i]=0;
            }
            pos--;
        }

    }
}
