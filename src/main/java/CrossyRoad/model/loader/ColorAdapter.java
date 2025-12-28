package CrossyRoad.model.loader;

public class ColorAdapter {

    public static String getHexColor(char code) {
        return switch (code) {
            case 'a' -> "#000000";      // Preto (mas devia ser ciano, mas não deu devido ao fundo da fonte ser preto)
            case 'b' -> "#000000";      // Preto
            case 'd' -> "#FF0000";      // Vermelho
            case 'f' -> "#FFFFFF";      // Branco
            case 'g' -> "#E59400";      // Laranja Escuro
            case 'h' -> "#772D20";      // Castanho
            case 'i' -> "#E0E0E0";      // Cinza Claro
            case 'j' -> "#B4B4B4";      // Cinza Escuro
            case 'k' -> "#0047ab";      // Azul
            case 'n' -> "#ffba00";      // Ouro
            case 'l' -> "#ff9800";      // Laranja
            case 'm' -> "#00c1ff";      // Azul Claro
            case 'o' -> "#ffae00";      // Amarelo Torrado
            case 'p' -> "#b914c8";      // Roxo
            case 'q' -> "#d54d34";      // Vermelho Escuro
            default -> "#FFFFFF";       // ‘Default’ Branco
        };
    }
}