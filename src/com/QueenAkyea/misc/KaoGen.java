package com.QueenAkyea.misc;

import java.util.ArrayList;
import java.util.Arrays;

public class KaoGen {
    final private static ArrayList<String> KAOMOJIS_EMBARRASED = new ArrayList<String>(Arrays.asList("(⌒_⌒;)", "(o^ ^o)", "(*/ω＼)", "(*/。＼)", "(*/_＼)", "(*ﾉωﾉ)", "(o-_-o)", "(*μ_μ)", "( ◡‿◡ *)", "(ᵔ.ᵔ)", "(*ﾉ∀`*)", "(//▽//)",
            "(//ω//)", "(ノ*°▽°*)", "(*^.^*)", "(*ﾉ▽ﾉ)", "(￣▽￣*)ゞ", "(⁄ ⁄•⁄ω⁄•⁄ ⁄)", "(*/▽＼*)", "(⁄ ⁄>⁄ ▽ ⁄<⁄ ⁄)", "(„ಡωಡ„)", "(ง ื▿ ื)ว", "( 〃▽〃)", "(/▿＼ )"));
    final private static ArrayList<String> KAOMOJIS_JOY = new ArrayList<String>(Arrays.asList("(* ^ ω ^)",	"(´ ∀ ` *)", "٩(◕‿◕｡)۶", "☆*:.｡.o(≧▽≦)o.｡.:*☆", "(o^▽^o)", "(⌒▽⌒)☆", "<(￣︶￣)>",	"。.:☆*:･'(*⌒―⌒*)))",
            "ヽ(・∀・)ﾉ", "(´｡• ω •｡`)", "(￣ω￣)", "｀;:゛;｀;･(°ε° )", "(o･ω･o)", "(＠＾◡＾)", "ヽ(*・ω・)ﾉ", "(o_ _)ﾉ彡☆"));
    final private static ArrayList<ArrayList<String>> KAOMOJIS_LIST = new ArrayList<ArrayList<String>>(Arrays.asList(KAOMOJIS_EMBARRASED, KAOMOJIS_JOY));
    public static String generate() {
        int index1 = (int) (Math.random() * 2);
        ArrayList<String> mojis = KAOMOJIS_LIST.get(index1);
        int index2 = (int) (Math.random() * mojis.size());
        return mojis.get(index2);
    }

    public static void generateN(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(generate());
        }
    }
}
