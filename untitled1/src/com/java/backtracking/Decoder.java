package com.java.backtracking;

import java.util.*;

class Decoder
{
    public static void main(String args[]){

        Queue<String> psQ= new LinkedList<String>();
        Set<String> rs = new HashSet<String>();
//read the input 
        String s="ab";
        psQ.add(s);
        while(psQ.size()!=0)//0!=0
        {
            String s1 = psQ.poll();//
            if(!rs.contains(s1))//True
            {
                rs.add(s1);
                for(int i = 0;i<s1.length();i++) // i=1,i<s1.length()=2 ===> 1<2
                {
                    psQ.add(s1.substring(i+1) + s1.charAt(i) + s1.substring(0,i));//s1.substring(1)
                }
            }
        }
        System.out.println("total permutations = "+ rs.size());
        for(String p:rs)
            System.out.println(p);

    }
} 