package com.quantum.bmicalculator;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import java.text.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		//Set Review To Be Empty onCreate and onstarting application
		TextView txtUserReview = (TextView)findViewById(R.id.txtUserReview);
		txtUserReview.setText("");
		
		TextView txtName = (TextView)findViewById(R.id.txtName);
		txtName.setText("");
		
		TextView txtFLName = (TextView)findViewById(R.id.txtFLName);
		txtFLName.setText("");
		
		TextView txtYourWeight = (TextView)findViewById(R.id.txtYourWeight);
		txtYourWeight.setText("");
		
		TextView txtWeight = (TextView)findViewById(R.id.txtWeight);
		txtWeight.setText("");
		
		TextView txtYourHeight = (TextView)findViewById(R.id.txtYourHeight);
		txtYourHeight.setText("");
		
		TextView txtHeight = (TextView)findViewById(R.id.txtHeight);
		txtHeight.setText("");
		
		TextView txtYourBMI = (TextView)findViewById(R.id.txtYourBMI);
		txtYourBMI.setText("");
		
		TextView txtBMI = (TextView)findViewById(R.id.txtBMI);
		txtBMI.setText("");
		
		TextView txtYourBMICategory = (TextView)findViewById(R.id.txtYourBMICategory);
		txtYourBMICategory.setText("");
		
		TextView txtBMICategory = (TextView)findViewById(R.id.txtBMICategory);
		txtBMICategory.setText("");
		
		calculateBMI();
		ResetContent();
    }
	
	public void calculateBMI(){
		Button button = (Button) findViewById(R.id.buttonCalculateBMI);
		
		button.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					//Code That will be Run When The Button is Clicked
					
					//Get The Name Of The User
					final EditText nameText = (EditText) findViewById(R.id.nameInput);
					String nameStr = nameText.getText().toString();
					
					//Get The Height of the User
					final EditText heightText = (EditText) findViewById(R.id.heightInput);
					String heightStr = heightText.getText().toString();
					//Convert The Height Value to Double Datatype
					double height = Double.parseDouble(heightStr);
					
					//Get The Weight of the user
					final EditText weightText = (EditText) findViewById(R.id.weightInput);
					String WeightStr = weightText.getText().toString();
					//Convert The Weight Value to Double Datatype
					double weight = Double.parseDouble(WeightStr);
					
					double BMI = (weight)/(height * height);
					
					
					//Trim The Value of the BMI Result to one decimal number
					DecimalFormat df = new DecimalFormat("#.#");
					double BMI_Trim = Double.parseDouble(df.format(BMI));
					//Get The BMI Result Text Of The Userdf
					final TextView BMIResult = (TextView) findViewById(R.id.BMIResult);
					//Convert the value of the BMIResult from Double to String
					BMIResult.setText(Double.toString(BMI_Trim));
					
					
					String BMI_Category;
					
					if(BMI < 15){
						BMI_Category = "Very Severely UnderWeight";
					}else if(BMI < 16){
						BMI_Category = "Severly UnderWeight";
					}else if(BMI < 18.5){
						BMI_Category = "UnderWeight";
					}else if(BMI < 25){
						BMI_Category = "Normal";
					}else if(BMI < 30){
						BMI_Category = "OverWeight";
					}else if(BMI < 35){
						BMI_Category = "Obese Class 1 : Moderately Obese";
					}else if(BMI < 40){
						BMI_Category = "Obese Class 2 : Severely Obese";
					}else{
						BMI_Category = "Obese Class 3 : Very Severely Obsese";
					}
					
					
					final TextView BMICat = (TextView) findViewById(R.id.BMICategory);
					BMICat.setText("BMI =" + " " + BMI_Category);
					
					//Set Review To Be Empty onCreate and onstarting application
					TextView txtUserReview = (TextView)findViewById(R.id.txtUserReview);
					txtUserReview.setText("BMI TEST RESULT");

					TextView txtName = (TextView)findViewById(R.id.txtName);
					txtName.setText("Name:");

					TextView txtFLName = (TextView)findViewById(R.id.txtFLName);
					txtFLName.setText(nameStr);

					TextView txtYourWeight = (TextView)findViewById(R.id.txtYourWeight);
					txtYourWeight.setText("Weight:");

					TextView txtWeight = (TextView)findViewById(R.id.txtWeight);
					txtWeight.setText(weightText.getText()+"kg");

					TextView txtYourHeight = (TextView)findViewById(R.id.txtYourHeight);
					txtYourHeight.setText("Height:");

					TextView txtHeight = (TextView)findViewById(R.id.txtHeight);
					txtHeight.setText(heightText.getText()+"m");

					TextView txtYourBMI = (TextView)findViewById(R.id.txtYourBMI);
					txtYourBMI.setText("BMI:");

					TextView txtBMI = (TextView)findViewById(R.id.txtBMI);
					txtBMI.setText(BMIResult.getText());

					TextView txtYourBMICategory = (TextView)findViewById(R.id.txtYourBMICategory);
					txtYourBMICategory.setText("BMI Category:");

					TextView txtBMICategory = (TextView)findViewById(R.id.txtBMICategory);
					txtBMICategory.setText(BMI_Category);
					
					if(nameText.equals("") && heightText.equals("") && weightText.equals("")){
						Toast.makeText(MainActivity.this, "No Values Inputed", Toast.LENGTH_LONG).show();
					}
				}
				
				
			
		});
	}
	
	public void ResetContent(){
		Button reset = (Button) findViewById(R.id.reset);
		
		reset.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					//Get The Name Of The User
					final EditText nameText = (EditText) findViewById(R.id.nameInput);
					nameText.setText("");
					
					//Get The Height of the User
					final EditText heightText = (EditText) findViewById(R.id.heightInput);
					heightText.setText("");
					
					//Get The Weight of the user
					final EditText weightText = (EditText) findViewById(R.id.weightInput);
					weightText.setText("");

					//Get The BMI Result Text Of The User
					final TextView BMIResult = (TextView) findViewById(R.id.BMIResult);
					BMIResult.setText("..............");
					
					final TextView BMICat = (TextView) findViewById(R.id.BMICategory);
					BMICat.setText("BMI Category Appears Here.");
					
					
					//Set Review To Be Empty onCreate and onstarting application
					TextView txtUserReview = (TextView)findViewById(R.id.txtUserReview);
					txtUserReview.setText("");

					TextView txtName = (TextView)findViewById(R.id.txtName);
					txtName.setText("");

					TextView txtFLName = (TextView)findViewById(R.id.txtFLName);
					txtFLName.setText("");

					TextView txtYourWeight = (TextView)findViewById(R.id.txtYourWeight);
					txtYourWeight.setText("");

					TextView txtWeight = (TextView)findViewById(R.id.txtWeight);
					txtWeight.setText("");

					TextView txtYourHeight = (TextView)findViewById(R.id.txtYourHeight);
					txtYourHeight.setText("");

					TextView txtHeight = (TextView)findViewById(R.id.txtHeight);
					txtHeight.setText("");

					TextView txtYourBMI = (TextView)findViewById(R.id.txtYourBMI);
					txtYourBMI.setText("");

					TextView txtBMI = (TextView)findViewById(R.id.txtBMI);
					txtBMI.setText("");

					TextView txtYourBMICategory = (TextView)findViewById(R.id.txtYourBMICategory);
					txtYourBMICategory.setText("");

					TextView txtBMICategory = (TextView)findViewById(R.id.txtBMICategory);
					txtBMICategory.setText("");
				}
			
			
		});
	}
}
