import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ManagerPosterTest {
    Repository repo = new Repository();
    ManagerPoster manager = new ManagerPoster(repo);

    FilmItem item1 = new FilmItem(1, "Film 1");
    FilmItem item2 = new FilmItem(2, "Film 2");
    FilmItem item3 = new FilmItem(3, "Film 3");
    FilmItem item4 = new FilmItem(4, "Film 4");
    FilmItem item5 = new FilmItem(5, "Film 5");
    FilmItem item6 = new FilmItem(6, "Film 6");
    FilmItem item7 = new FilmItem(7, "Film 7");
    FilmItem item8 = new FilmItem(8, "Film 8");
    FilmItem item9 = new FilmItem(9, "Film 9");
    FilmItem item10 = new FilmItem(10, "Film 10");
    FilmItem item11 = new FilmItem(11, "Film 11");

    @Test  // Подсчет количества фильмов через Mockito
    public void shouldGetCount() {
        Repository repo = Mockito.mock(Repository.class);
        FilmItem[] items = {item1, item2, item3};
        doReturn(items).when(repo).getItems();

        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);

        int expected = 3;
        int actual = manager.getCount();

        Assertions.assertEquals(expected, actual);
    }

    @Test // Проверка добавления фильмов в массив и вывод
    public void shouldAddFilm() {
        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);
        manager.addFilm(item5);

        FilmItem[] expected = {item1, item2, item3, item4, item5};
        FilmItem[] actual = manager.findAdd();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddFilmNull() {
        FilmItem[] expected = {};
        FilmItem[] actual = manager.findAdd();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка вывода фильмов в массив с конца
    public void shouldReservedAllItems() {
        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);

        FilmItem[] expected = {item3, item2, item1};
        FilmItem[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFilmLastNull() {
        FilmItem[] expected = {};
        FilmItem[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFilmLastOne() {
        manager.addFilm(item1);
        FilmItem[] expected = {item1};
        FilmItem[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFilmLastNine() {
        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);
        manager.addFilm(item5);
        manager.addFilm(item6);
        manager.addFilm(item7);
        manager.addFilm(item8);
        manager.addFilm(item9);

        FilmItem[] expected = {item9, item8, item7, item6, item5, item4, item3, item2, item1};
        FilmItem[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFilmLastLimit() {
        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);
        manager.addFilm(item5);
        manager.addFilm(item6);
        manager.addFilm(item7);
        manager.addFilm(item8);
        manager.addFilm(item9);
        manager.addFilm(item10);

        FilmItem[] expected = {item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        FilmItem[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFilmLastMoreLimit() {
        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);
        manager.addFilm(item5);
        manager.addFilm(item6);
        manager.addFilm(item7);
        manager.addFilm(item8);
        manager.addFilm(item9);
        manager.addFilm(item10);
        manager.addFilm(item11);

        FilmItem[] expected = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        FilmItem[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
}
