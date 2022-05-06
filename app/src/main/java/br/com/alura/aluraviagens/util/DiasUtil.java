package br.com.alura.aluraviagens.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataEmTexto(int qtdDeDias) {
        if (qtdDeDias > 1)
            return qtdDeDias + PLURAL;
        return qtdDeDias + SINGULAR;
    }
}
