package volosyuk.lr24;

public class Adress {

    private String name;
    private String description;
    private int imageResourceId;
    public static final Adress[] adresses = {
            new Adress("Регенс", "Излюбленное заведение парижской богемы и интеллектуалов. Работает с 1681 года и до сегодняшнего дня.", R.drawable.coffee_shop_1),
            new Adress("Грин Драгон", "В Массачусетсе - место встреч американских патриотов (открыто в 1691 году).", R.drawable.coffee_shop_2),
            new Adress("Джонатан", "В Лондоне (1690-1700 гг.) - центр торгов, ставший первой фондовой биржой Англии.", R.drawable.coffee_shop_3)};

    private Adress(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }

}
