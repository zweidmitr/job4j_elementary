package ru.job4j.collection.list;

import java.util.List;

/*Задание: метод принимает два параметра - список и элемент, который предполагается, что содержится в этом списке.
Необходимо реализовать метод, чтобы он возвращал результаты следующим образом:
1. Элемента нет в списке - возвращает пустой список.
2. Элемент в списке встречается 1 раз - возвращает пустой список.
3. Элемент встречается более одного - возвращается список,
начиная с первого вхождения элемента и заканчивая предшествующим
последнему вхождению элемента в исходной коллекции. */

public class SubList {
    public static List<String> getElementBetweenIndex(List<String> list, String el) {
        int start = list.indexOf(el);
        int finish = list.lastIndexOf(el);
        list = list.subList(start, finish);
        return  list;
    }
}
