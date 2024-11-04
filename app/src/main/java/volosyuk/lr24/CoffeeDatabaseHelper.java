package volosyuk.lr24;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

class CoffeeDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "coffee";
    private static final int DB_VERSION = 1;

    CoffeeDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertDrink(db, "Латте", "Кофейный напиток, на основе молока, представляющий собой трёхслойную смесь из пены, молока и кофе эспрессо", R.drawable.latte);
            insertDrink(db, "Капучино", "Кофейный напиток итальянской кухни на основе эспрессо с добавлением в него подогретого вспененного молока", R.drawable.cappuccino);
            insertDrink(db, "Раф", "Кофейный напиток, готовится путём добавления нагретых паром сливок с небольшим количеством пены в одиночную порцию эспрессо", R.drawable.raf);
        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertDrink(SQLiteDatabase db, String name, String description, int resourceId) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("DRINK", null, drinkValues);
    }

    public Drink[] getDrinks() {
        SQLiteDatabase db = getReadableDatabase();
        // Выполняем запрос к базе данных
        Cursor cursor = db.query("DRINK",
                new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                null, null, null, null, null);

        // Создаем список для хранения напитков
        List<Drink> drinkList = new ArrayList<>();

        // Перебираем результаты запроса
        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String description = cursor.getString(1);
            int imageResourceId = cursor.getInt(2);

            // Создаем объект Drink и добавляем его в список
            Drink drink = new Drink(name, description, imageResourceId);
            drinkList.add(drink);
        }

        // Закрываем курсор
        cursor.close();

        // Преобразуем список в массив
        Drink[] drinksArray = new Drink[drinkList.size()];
        drinksArray = drinkList.toArray(drinksArray);

        return drinksArray;
    }
}