public class FilmItem {
    private int id;
    private String nameFilm;

    public FilmItem(int id, String nameFilm) {
        this.id = id;
        this.nameFilm = nameFilm;
    }

    public FilmItem() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }
}
