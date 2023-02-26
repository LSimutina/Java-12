public class ManagerPoster {
    private Repository repo;
    private int limit;

    public ManagerPoster(Repository repo) {
        this.repo = repo;
        this.limit = 10;
    }

    public ManagerPoster(int limit) {
        this.limit = limit;
    }

    // Добавление нового фильма в массив
    public void addFilm(FilmItem item) {
        repo.save(item);
    }

    // Возвращает все элементы массива
    public FilmItem[] findAdd() {
        FilmItem[] all = repo.getItems();
        return all;
    }

    //Возвращает элементы массива с конца массива
    public FilmItem[] getItems() {
        FilmItem[] all = repo.getItems();
        int resultLength;
        if (all.length < limit) {
            resultLength = all.length;
        } else {
            resultLength = limit;
        }
        FilmItem[] reversed = new FilmItem[all.length];
        for (int i = 0; i < all.length; i++) {
            reversed[i] = all[all.length - 1 - i];
        }

        FilmItem[] tmp = new FilmItem[resultLength];
        for (int i = 0; i < resultLength; i++) {
            tmp[i] = reversed[i];
        }
        reversed = tmp;
        return reversed;
    }

    public int getCount() {
        int count = 0;
        for (FilmItem item : repo.getItems()) {
            count = count + 1;
        }
        return count;
    }
}
