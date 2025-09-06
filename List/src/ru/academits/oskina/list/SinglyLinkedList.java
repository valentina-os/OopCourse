public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private final int count;

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;

        int listCount = 0;

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            listCount += 1;
        }

        count = listCount;
    }

    public int getSize() {
        return count;
    }

    public T getHead() {
        return head.getData();
    }

    public T getData(int index) {
        try {
            if (index < count) {
                int currentIndex = 0;

                for (ListItem<T> item = head; item != null; item = item.getNext()) {
                    if (currentIndex == index) {
                        return item.getData();
                    }

                    currentIndex += 1;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка:" + e.getMessage());
        }

        return null;
    }

    public T setData(int index, T newData) {
        try {
            if (index >= count) {
                throw new IndexOutOfBoundsException();
            }

            int currentIndex = 0;

            for (ListItem<T> item = head; item != null; item = item.getNext()) {
                if (currentIndex == index) {
                    T previousData = item.getData();
                    item.setData(newData);

                    return previousData;
                }

                currentIndex += 1;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Индекс не должен превышать длину списка. Элемент не изменен.");
        }

        return null;
    }

    public T deleteListItem(int index) {
        try {
            if (index >= count) {
                throw new IndexOutOfBoundsException();
            }

            int currentIndex = 0;

            for (ListItem<T> item = head; item != null; item = item.getNext()) {
                if (currentIndex + 1 == index) {
                    ListItem<T> nextItem = item.getNext();
                    item.setNext(nextItem.getNext());

                    return nextItem.getData();
                }

                currentIndex += 1;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Индекс не должен превышать длину списка");
        }

        return null;
    }

    public void setHead(T data) {
        head = new ListItem<>(data, head);
    }

    public void setListItem(int index, ListItem<T> listItem) {
        try {
            if (index >= count) {
                throw new IndexOutOfBoundsException();
            }

            int currentIndex = 0;

            for (ListItem<T> item = head; item != null; item = item.getNext()) {
                if (currentIndex + 1 == index) {
                    ListItem<T> nextItem = item.getNext();

                    item.setNext(listItem);
                    listItem.setNext(nextItem);

                    return;
                }

                currentIndex += 1;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Элемент не вставлен. Индекс не должен превышать длину списка");
        }
    }

    public boolean deleteListItem(T data) {
        if (head.getData() == data) {
            deleteHead();

            return true;
        }

        ListItem<T> previousItem = head;

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            if (item.getData() == data) {
                previousItem.setNext(item.getNext());

                return true;
            }

            previousItem = item;
        }

        return false;
    }

    public T deleteHead() {
        ListItem<T> deletedHead = head;
        head = head.getNext();

        return deletedHead.getData();
    }

    public SinglyLinkedList<T> copy() {
        ListItem<T> newHead = head;

        return new SinglyLinkedList<>(newHead);
    }

    public void reverse() {
        ListItem<T> previousItem = null;
        ListItem<T> nextItem;

        while (head != null) {
            nextItem = head.getNext();
            head.setNext(previousItem);
            previousItem = head;

            head = nextItem;
        }

        head = previousItem;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            stringBuilder.append(item.getData()).append(" ");
        }

        return stringBuilder.toString();
    }
}
