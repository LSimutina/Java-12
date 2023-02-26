import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmItemTest {

    @Test
    public void shouldAddId() {
        FilmItem film = new FilmItem();
        film.setId(1);
        int expected = 1;
        int actual = film.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddName() {
        FilmItem film = new FilmItem();
        film.setNameFilm("Film1");
        String expected = "Film1";
        String actual = film.getNameFilm();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAdd() {
        FilmItem film = new FilmItem(1, "Film1");
        film.setNameFilm("Film1");
        String expected = "Film1";
        String actual = film.getNameFilm();
        Assertions.assertEquals(expected, actual);
    }
}
