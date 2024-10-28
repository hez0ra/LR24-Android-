package volosyuk.lr24;

public class Food {
    private String name;
    private String description;
    private int imageResourceId;
    public static final Food[] foods = {
            new Food("Яичница", " Блюдо, приготовляемое на сковороде из разбитых яиц.", R.drawable.fried_egg),
            new Food("Сэндвич", "Вид бутерброда, состоящего из двух кусочков хлеба и какой-либо начинки между ними (закрытый бутерброд)", R.drawable.sandwich),
            new Food("Круассан", "Небольшое мучное кондитерское изделие, булочка в форме полумесяца из слоёного теста. Очень популярный продукт французской кухни, подаётся на завтрак к кофе для взрослых или к какао для детей; своеобразный символ этой страны. ", R.drawable.croissant)};

    private Food(String name, String description, int imageResourceId) {
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
