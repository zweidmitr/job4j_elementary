package ru.job4j.collection;

import java.util.List;

public class AddAllElementsList {
   /* Задание: метод принимает 2 списка и элемент, который возможно содержится в этих списках.
   Вам необходимо проверить оба списка, содержат ли они одновременно этот элемент, если содержит
   - необходимо удалить элемент из первого списка. Потом второй список нужно добавить в первый.
   Метод должен вернуть индекс элемента, который пришел в параметрах метода из общего списка.*/

    public static int containsElement(List<String> left, List<String> right, String str) {
        int rez1 = 0;
        int rez2 = 0;
        for (String l : left) {
            if (l.equals(str)) {
                rez1 = 1;
            }
        }
        for (String r : right) {
            if (r.equals(str)) {
                rez2 = 1;
            }
        }
        if (rez1 == rez2 && rez1 != 0) {
            left.remove(str);
        }
        left.addAll(right);

        return left.indexOf(str);
    }

}
