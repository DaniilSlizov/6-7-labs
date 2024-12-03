package ru.netology.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onChooseIngredientsClick(View view) {
        // массив значений для отображаемых в окне строк
        String[] mIngredients = {"Томаты", "Сыр", "Грибы", "Солённые огурцы"};
        // массив для хранения выбора пунктов (по умолчанию ни один пункт не выбран, поэтому false)
        final boolean[] mSelectedIngredients = {false, false, false, false};

        // Создание диалогового окна для выбора ингредиентов
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выберите ингредиенты для своей пиццы")
                .setIcon(R.drawable.pizza)
                .setCancelable(false)
                // множественный выбор
                .setMultiChoiceItems(mIngredients, mSelectedIngredients, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        mSelectedIngredients[which] = isChecked;
                    }
                })
                .setPositiveButton("Далее", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Логика для обработки выбора ингредиентов может быть добавлена здесь
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onCloseButtonClick(View view) {
        // Создание диалогового окна для подтверждения выхода из приложения
        showExitConfirmationDialog();
    }

    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выход из приложения")
                .setIcon(R.drawable.close)
                .setMessage("Вы уверены, что хотите закрыть приложение?")
                .setCancelable(false)
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }
}

