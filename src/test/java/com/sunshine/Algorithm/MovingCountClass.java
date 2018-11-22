package com.sunshine.Algorithm;

import org.junit.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MovingCountClass {

    @Test
    public void test(){
        System.out.println(movingCount(40,0,0));
    }

    private Set<Point> onePoints=new HashSet<>();

    public int movingCount(int threshold, int rows, int cols)
    {
        BFS(threshold,rows,cols);
        return onePoints.size();
    }

    private void BFS(int threshold, int rows, int cols){
        LinkedList<Point> queue=new LinkedList<>();
        Point start = new Point(rows, cols);
        if(check(threshold,start)){
            queue.add(start);
            onePoints.add(start);
        }
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            Point p1 = new Point(x+1, y);
            if(checkoutNext(threshold,p1)){
                queue.add(p1);
                onePoints.add(p1);
            }
            Point p2 = new Point(x-1, y);
            if(checkoutNext(threshold,p2)){
                queue.add(p2);
                onePoints.add(p2);
            }
            Point p3 = new Point(x, y-1);
            if(checkoutNext(threshold,p3)){
                queue.add(p3);
                onePoints.add(p3);
            }
            Point p4 = new Point(x, y+1);
            if(checkoutNext(threshold,p4)){
                queue.add(p4);
                onePoints.add(p4);
            }
        }
    }

    private boolean check(int threshold,Point p){
        int x = p.x;
        int y = p.y;
        int ans = 0;
        while(x>0){
            ans+=x%10;
            x/=10;
        }
        while(y>0){
            ans+=y%10;
            y/=10;
        }
        if(ans<=threshold){
            return true;
        }
        return false;
    }

    private boolean checkoutNext(int threshold,Point p){
        if(p.x<0||p.y<0){
            return false;
        }
        if(onePoints.contains(p)){
            return false;
        }
        if(!check(threshold,p)){
            return false;
        }
        return true;
    }
}
