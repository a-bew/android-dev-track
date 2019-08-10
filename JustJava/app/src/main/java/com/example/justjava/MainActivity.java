package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;
import android.widget.LinearLayout;

//    This app displays an order form to order coffee.

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    This method is called when the order button is clicked


    public void submitOrder(View view){
        int price = 10;
        display(quantity);
        displayMessage((quantity * price));
    }

    public void increment(View view){
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view){
        quantity = quantity - 1;
        if (quantity < 0){
            quantity = 0;
        }
        display(quantity);
    }

    public void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
        R.id.qty_value_text_view);
        quantityTextView.setText("" + number);
    }

    // This method display the given quantity value on the screen.
    private void displayMessage(int number) {
        String message = "Total: "+ NumberFormat.getCurrencyInstance().format(number);

        TextView priceTextView = (TextView) findViewById(R.id.price_value_text_view);
        if (number>0) {
            message = message + "\nThank you!";
            switchOrientation();
            priceTextView.setText(message);
        } else {
            priceTextView.setText(message);
        }
    }

    private void switchOrientation(){
        LinearLayout linearLayoutOrientation = (LinearLayout) findViewById(R.id.linear_layout_qty_picker);
        int orientatn = linearLayoutOrientation.getOrientation();
        if (orientatn != LinearLayout.HORIZONTAL) {
            linearLayoutOrientation.setOrientation(LinearLayout.HORIZONTAL);
        }
    }
}
