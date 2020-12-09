package com.ithub.source.learn.StackAndQueue;

import java.util.Stack;

public class HanoiProblem2 {
    public static void main(String[] args) {
        hanoiProblem2(3,"left","mid","right");
    }

    public static int hanoiProblem2(int num,String left,String mid,String right){
        Stack<Integer> lS = new Stack<Integer>();
        Stack<Integer> mS = new Stack<Integer>();
        Stack<Integer> rS = new Stack<Integer>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);

        for (int i = num; i > 0; i--) {
            lS.push(i);
        }

        Action[] record = {Action.No};
        int step = 0 ;
        while (rS.size() != num+1){
            step +=fStackTotStack(record,Action.MToL,Action.LToM,lS,mS,left,mid);
            step +=fStackTotStack(record,Action.LToM,Action.MToL,mS,lS,mid,left);
            step +=fStackTotStack(record,Action.RToM,Action.MToR,mS,rS,mid,right);
            step +=fStackTotStack(record,Action.MToR,Action.RToM,rS,mS,right,mid);
        }
        return step;
    }

    public static int fStackTotStack(Action[] record,Action preNoAct,Action nowAct,
                                     Stack<Integer> fStack,Stack<Integer> tStack,
                                     String from,String to){
        if(record[0] != preNoAct && fStack.peek() < tStack.peek()){
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;

    }
}
