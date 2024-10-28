package volosyuk.lr24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends AppCompatActivity {

    public static final String TYPE = "type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        int type = getIntent().getIntExtra(TYPE, 0);

        switch (type){
            case 0:
                ArrayAdapter<Drink> drinkAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Drink.drinks);
                ListView listDrinks = (ListView) findViewById(R.id.list_drinks);
                listDrinks.setAdapter(drinkAdapter);

                AdapterView.OnItemClickListener drinkClickListener = new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listDrinks, View itemView, int position, long id) {
                        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                        intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int) id);
                        intent.putExtra(DrinkActivity.EXTRA_TYPE, (int) 0);
                        startActivity(intent);
                    }
                };
                listDrinks.setOnItemClickListener(drinkClickListener);
                break;
            case 1:
                ArrayAdapter<Food> foodAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Food.foods);
                ListView listFood = (ListView) findViewById(R.id.list_drinks);
                listFood.setAdapter(foodAdapter);

                AdapterView.OnItemClickListener foodClickListener = new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listDrinks, View itemView, int position, long id) {
                        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                        intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int) id);
                        intent.putExtra(DrinkActivity.EXTRA_TYPE, (int) 1);
                        startActivity(intent);
                    }
                };
                listFood.setOnItemClickListener(foodClickListener);
                break;
            case 2:
                ArrayAdapter<Adress> adressAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Adress.adresses);
                ListView listAdress = (ListView) findViewById(R.id.list_drinks);
                listAdress.setAdapter(adressAdapter);

                AdapterView.OnItemClickListener adressClickListener = new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listDrinks, View itemView, int position, long id) {
                        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                        intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int) id);
                        intent.putExtra(DrinkActivity.EXTRA_TYPE, (int) 2);
                        startActivity(intent);
                    }
                };
                listAdress.setOnItemClickListener(adressClickListener);
                break;
            default: break;

        }
    }
}