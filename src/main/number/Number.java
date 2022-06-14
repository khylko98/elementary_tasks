package main.number;

public class Number {
    private int number;
    private final String[][] FROM_ZERO_TO_THOUSAND =
            {
                    {"ноль", "один", "два", "три", "четыре", "пять",
                            "шесть", "семь", "восемь", "девять", "десять"
                    },
                    {"одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
                            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
                    },
                    {"сто", "десять", "двадцать", "тридцать", "сорок", "пятьдесят",
                            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"
                    },
                    {"сто", "двести", "триста", "четыреста", "пятьсот",
                            "шестьсот", "семьсот", "восемьсот", "девятьсот", "тысяча"
                    }
            };

    public Number(int number) {
        if (number < 0 || number > 1000)
            throw new IllegalArgumentException("Your number less than 0 or larger than 1000!");
        else this.number = number;
    }

    private String below_ten() {
        return number + " - " + FROM_ZERO_TO_THOUSAND[0][number];
    }

    private String below_twenty() {
        return number + " - " + FROM_ZERO_TO_THOUSAND[1][(number % 10) - 1];
    }

    private String tens() {
        String result = number + " - " + FROM_ZERO_TO_THOUSAND[2][number / 10] + " ";
        if (number % 10 == 0) System.out.println();
        else result += FROM_ZERO_TO_THOUSAND[0][number % 10];
        return result;
    }

    private String thousand() {
        String result = number + " - " + FROM_ZERO_TO_THOUSAND[3][(number / 100) - 1] + " ";
        if (number % 100 == 0) {
            result += "\n";
        } else {
            if ((number % 100) / 10 == 0) {
                result += "";
                if (number % 10 != 0) result += FROM_ZERO_TO_THOUSAND[0][number % 10];
            } else if ((number % 100) / 10 == 1) {
                if (number % 10 == 0) result += FROM_ZERO_TO_THOUSAND[0][10];
                else result += FROM_ZERO_TO_THOUSAND[1][(number % 10) - 1];
            } else {
                result += FROM_ZERO_TO_THOUSAND[2][(number % 100) / 10] + " ";
                if ((number % 1000) / 100 == 0) System.out.print("");
                else result += FROM_ZERO_TO_THOUSAND[0][number % 10];
            }
        }
        return result;
    }

    public String converter() {
        if (number <= 10) return below_ten();
        else if (number <= 19) return below_twenty();
        else if (number <= 99) return tens();
        else if (number <= 1000) return thousand();
        return "";
    }
}
