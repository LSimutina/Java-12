import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class RepositoryTest {
    Repository repo = new Repository();

    FilmItem item1 = new FilmItem(1, "Film 1");
    FilmItem item2 = new FilmItem(2, "Film 2");
    FilmItem item3 = new FilmItem(3, "Film 3");
    FilmItem item4 = new FilmItem(5, "Film 5");

    @Test // Проверка добавления фильмов и вывод массива фильмов
    public void shouldAddFilm() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        FilmItem[] expected = {item1, item2, item3};
        FilmItem[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка добавления фильмов и вывод массива фильмов
    public void shouldAddFilmNull() {
        FilmItem[] expected = {};
        FilmItem[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка удаления фильма по ИД
    public void shouldRemoveToId() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(item2.getId());

        FilmItem[] expected = {item1, item3};
        FilmItem[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка удаления фильма по ИД всех фильмов
    public void shouldRemoveAllToId() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(item1.getId());
        repo.removeById(item2.getId());
        repo.removeById(item3.getId());

        FilmItem[] expected = {};
        FilmItem[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка поиска объекта по идентификатору
    public void shouldFindById() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.findById(item3.getId());

        FilmItem[] expected = {item3};
        FilmItem[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка поиска объекта по идентификатору если объекта не существует
    public void shouldNoFindById() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.findById(item4.getId());

        FilmItem[] expected = {null};
        FilmItem[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка удаления полного репозитория
    public void shouldRemoveAll() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeAll();

        FilmItem[] expected = {};
        FilmItem[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }
}
