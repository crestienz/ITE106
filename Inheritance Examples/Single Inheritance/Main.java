import java.io.*;
import java.lang.*;
import java.util.*;

class One {
    public void print_geek() {
        System.out.println("Geeks");
    }
}

class Two extends One {
    public void print_for() {
        System.out.println("for");
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {
        Two g = new Two();
        g.print_geek();
        g.print_for();
        g.print_geek();
    }
}
