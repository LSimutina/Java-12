public class Repository {
    private FilmItem[] items = new FilmItem[0];

    // 1. Возвращает массив всех хранящихся в массиве объектов
    public FilmItem[] getItems() {
        return items;
    }

    // 2. Добавление нового фильма в массив
    public void save(FilmItem item) {
        FilmItem[] tmp = new FilmItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    // 3. Возвращает объект по идентификатору, либо null, если такого объекта нет
    public void findById(int id) {
        int count = 0;
        FilmItem[] tmp = new FilmItem[count + 1];
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId() == id) {
                tmp[count] = items[i];
            } else {
                tmp[count] = null;
            }
        }
        items = tmp;
    }

    // 4. Удаляет объект по идентификатору, если объекта нет, то пусть будет исключение, как на лекции
    public void removeById(int id) {
        FilmItem[] tmp = new FilmItem[items.length - 1];
        int copyToIndex = 0;
        for (FilmItem item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    // 5. Полностью вычищает репозиторий, для удаления всех элементов достаточно в поле items положить пустой массив
    public void removeAll() {
        FilmItem[] tmp = new FilmItem[0];
        items = tmp;
    }
}
