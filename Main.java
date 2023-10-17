import org.w3c.dom.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

    public static class Summom {
        int health;
        int attackpower;

        public Summom(int attackpower, int health) {
            this.health = health;
            this.attackpower = attackpower;
        }


    }

    public static class Player {
        ArrayList<Summom> s=new ArrayList<>();

        public Player() {
            s.add(new Summom(0, 30));
        }

        public void attack(int a, int b, Player p)//a攻击p
        {
            s.get(a).health -= p.s.get(b).attackpower;
            p.s.get(b).health -= s.get(a).attackpower;
            if(s.get(a).health<=0&&a!=0) s.remove(a);
            if(p.s.get(b).health<=0&&b!=0) p.s.remove(b);
        }

        public void call(int pos, int a, int h) {
            s.add(pos, new Summom(a, h));
        }

    }

    public static void main(String[] args) {
        Player p1 = new Player();
        Player p2 = new Player();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = new String();
        int flag = 1;
        for (int i = 0; i < n; i++) {
            s = scanner.next();
            if (s.equals("summon")) {
                int p, a, h;
                p = scanner.nextInt();
                a = scanner.nextInt();
                h = scanner.nextInt();
                if (flag == 1)
                    p1.call(p, a, h);
                else
                    p2.call(p, a, h);
            } else if (s.equals("attack")) {

                int a, b;
                a = scanner.nextInt();
                b = scanner.nextInt();
                if (flag == 1) {
                    p1.attack(a, b, p2);
                    //System.out.println("i");
                }
                else
                    p2.attack(a,b,p1);

            }
            else {
                flag *= -1;
                if(p1.s.get(0).health<=0||p2.s.get(0).health<=0) break;
            }
        }
        if(p1.s.get(0).health<=0&&p2.s.get(0).health>0) System.out.println(-1);
        else if(p2.s.get(0).health<=0&&p1.s.get(0).health>0) System.out.println(1);
        else System.out.println(0);
        System.out.println(p1.s.get(0).health);
        System.out.print(p1.s.size()-1+" ");
        for (int i = 1; i <p1.s.size() ; i++) {
            System.out.print(p1.s.get(i).health+" ");
        }
        System.out.println();
        System.out.println(p2.s.get(0).health);
        System.out.print(p2.s.size()-1+" ");
        for (int i = 1; i <p2.s.size() ; i++) {
            System.out.print(p2.s.get(i).health+" ");
        }
        System.out.println();


    }
}
