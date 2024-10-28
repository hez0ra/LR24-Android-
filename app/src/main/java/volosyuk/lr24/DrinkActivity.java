package volosyuk.lr24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKID = "drinkId";
    public static final String EXTRA_TYPE = "type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);



        switch (getIntent().getExtras().getInt(EXTRA_TYPE, 0)){
            case 0:
                //Получить напиток из данных интента
                int drinkId = (Integer) getIntent().getExtras().get(EXTRA_DRINKID);
                Drink element = Drink.drinks[drinkId];
                //Заполнение названия напитка
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(element.getName());

                //Заполнение описания напитка
                TextView description = (TextView) findViewById(R.id.description);
                description.setText(element.getDescription());

                //Заполнение изображения напитка
                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(element.getImageResourceId());
                photo.setContentDescription(element.getName());
                break;
            case 1:
                //Получить напиток из данных интента
                int foodId = (Integer) getIntent().getExtras().get(EXTRA_DRINKID);
                Food food = Food.foods[foodId];
                //Заполнение названия напитка
                TextView nameFood = (TextView) findViewById(R.id.name);
                nameFood.setText(food.getName());

                //Заполнение описания напитка
                TextView descriptionFood = (TextView) findViewById(R.id.description);
                descriptionFood.setText(food.getDescription());

                //Заполнение изображения напитка
                ImageView photoFood = (ImageView) findViewById(R.id.photo);
                photoFood.setImageResource(food.getImageResourceId());
                photoFood.setContentDescription(food.getName());
                break;
            case 2:
                //Получить напиток из данных интента
                int adressId = (Integer) getIntent().getExtras().get(EXTRA_DRINKID);
                Adress adress = Adress.adresses[adressId];
                //Заполнение названия напитка
                TextView nameAdress = (TextView) findViewById(R.id.name);
                nameAdress.setText(adress.getName());

                //Заполнение описания напитка
                TextView descriptionAdress = (TextView) findViewById(R.id.description);
                descriptionAdress.setText(adress.getDescription());

                //Заполнение изображения напитка
                ImageView photoAdress = (ImageView) findViewById(R.id.photo);
                photoAdress.setImageResource(adress.getImageResourceId());
                photoAdress.setContentDescription(adress.getName());
                break;
            default: break;
        }






    }
}