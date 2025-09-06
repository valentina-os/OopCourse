public class Main {
    public static void main(String[] args) {
        ListItem<Integer> item4 = new ListItem<>(13);
        ListItem<Integer> item3 = new ListItem<>(2, item4);
        ListItem<Integer> item2 = new ListItem<>(7, item3);
        ListItem<Integer> item1 = new ListItem<>(5, item2);
        ListItem<Integer> head = new ListItem<>(3, item1);

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(head);

        System.out.println("Односвязный список: " + singlyLinkedList);
        System.out.println("Размер списка = " + singlyLinkedList.getSize());
        System.out.println("Первый элемент = " + singlyLinkedList.getHead());
        System.out.println("Четвертый элемент = " + singlyLinkedList.getData(3));
        System.out.println("Изменен второй элемент = " + singlyLinkedList.setData(5, 3));

        System.out.println("Удалить элемент по индексу 2 = " + singlyLinkedList.deleteListItem(2));
        System.out.println("Список после удаления элемента: " + singlyLinkedList);

        singlyLinkedList.setHead(8);
        System.out.println("Список после вставки в начало элемента: " + singlyLinkedList);

        ListItem<Integer> listItem = new ListItem<>(4);
        singlyLinkedList.setListItem(2, listItem);
        System.out.println("Список после вставки по индексу 2 нового элемента = " + singlyLinkedList);

        System.out.println("Удален первый элемент = " + singlyLinkedList.deleteHead());

        Integer newData = 5;
        System.out.println("Удален элемент со значением 5: " + singlyLinkedList.deleteListItem(newData));

        System.out.println("Копия односвязного списка: " + singlyLinkedList.copy());

        singlyLinkedList.reverse();
        System.out.println("Развернутый список: " + singlyLinkedList);
    }
}
