package Kelompok5.PBO.Novel_Web.models;

public class NovelView {
    private int id;
    private Novel novel;

    public NovelView(int id, Novel novel) {
        this.id = id;
        this.novel = novel;
    }

    public int getId() {
        return id;
    }

    public Novel getNovel() {
        return novel;
    }
}