package calc_project;

import java.util.Scanner;

public class programm{
 
public static String calc (String s) {

        s = s.replaceAll(" ", "");                //Удоляем из строки пробелы
        String[] oper = {"+", "-", "/", "*"};                       // Массив математических операций
        String[] Riman = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};                       
        String[] Riman10 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        int OpIndex=-1;                                             // Индекс маркер для операции
        for (int i = 0; i < oper.length; i++) {                     //Проверка какая опереция присутствует в строке 
            if(s.contains(oper[i])){                                
                OpIndex = i;
                break;                                             
            }

        }
        if(OpIndex==-1){                                            // Если Индекс маркера не изменился значит в строке нет математических операций 
            //System.out.println("trows Exeption");                                   //"Исключение: Нет знака действия");
            return s = "trows Exeption";
        }
        String[] AB = s.split("\\"+oper[OpIndex]);                // Делим строку по маркеру и помещаем ее в массив строк   
        if(AB.length>2){                                           // Проверяем нет ли действий больше одного
            //System.out.println("trows Exeption");               //"Исключение: Ошибка ввода");  
            return  s = "trows Exeption";          
        }                             //
        //Римские числа 
        int IndexR1=-1;                                             // Индекс маркер для первого римского числа
        for (int i = 0; i < Riman.length; i++) {                     
            if(AB[0].equals(Riman[i])){
                IndexR1 = i;
                break;
            }
        }
        int IndexR2=-1;                                             // Индекс маркер для второго римского числа
        for (int i = 0; i < Riman.length; i++) {                     
            if(AB[1].equals(Riman[i])){
                IndexR2 = i;
                break;
            }
        }
            if (IndexR2 != -1 && IndexR1 !=-1){                  // если маркеры не изменились то это Римские числа  
            int aR,bR;                                              
            aR = IndexR1;                            
            bR = IndexR2;
            int resR;                                            // Выполняем математическую операцию
            switch (oper[OpIndex]){
                case "+":
                    resR = aR+bR;
                    break;
                case "-":
                    resR = aR-bR;
                    break;
                case "*":
                    resR = aR*bR;
                    break;
                default:
                    resR = aR/bR;
                    break;
            }
            int c = resR / 10;
            int d = resR% 10;
            if (c+d<1){
                        //System.out.println("trows Exeption");   //"Исключение: В Риме не было чисел меньше 1");
                        return s = "trows Exeption";
                    }
            //System.out.println(Riman10[c]+Riman[d]); 
            return s = Riman10[c]+Riman[d];
            }
             else{
         //Арабские числа
            int a,b;
            try {                                             // Передаем из массивы строк в a b сконвертировав в Integer
            a = Integer.parseInt(AB[0]);                            
            b = Integer.parseInt(AB[1]);
            if (a>10 | b>10){
            //System.out.println("trows Exeption");   //"Исключение: Число вне диапазона задачи");
            return s = "trows Exeption";     
            }
            int res;                                            // Выполняем математическую операцию
            switch (oper[OpIndex]){
                case "+":
                    res = a+b;
                    break;
                case "-":
                    res = a-b;
                    break;
                case "*":
                    res = a*b;
                    break;
                default:
                    if (b==0){
                        //System.out.println("trows Exeption");   //"Исключение: Деление на ноль");
                        return s = "trows Exeption";
                    }
                    res = a/b;
                    break;
            }
            //System.out.println(res); 
            s = Integer.toString(res);
            }catch (Exception ex) {
                //System.out.println("trows Exeption");   //"Исключение: Ошибка ввода");
                return s = "trows Exeption"; 
            }
        }
            return s;
        }   
        public static void main(String[] args) {
        System.out.print("\033[H\033[J");   
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку для расчета");
        String s = in.nextLine();            
        in.close();     
        System.out.print(calc(s));     
        } 
    }