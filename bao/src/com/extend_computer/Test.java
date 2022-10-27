package com.extend_computer;

public class Test {
    public static void main(String[] args) {
        PC pc = new PC("intel", 16, 512, "联想");
        pc.printInfo();

        color co = new color("AMD", 16, 1024, "蓝色");
        co.printInfo();
    }
}
