package com.example.billsplitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Separate extends AppCompatActivity {

    public static ArrayList<String> text = new ArrayList<String>(100);
    public static ArrayList<Integer> nos = new ArrayList<Integer>(100);

    public static ArrayList<String> dishes = new ArrayList<String>(100);
    public static ArrayList<Integer> price = new ArrayList<Integer>(100);

    public static String temp = ocr.finalText;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        String words[] = temp.split("\\r&\\n");
        int i = 0;
        String regex1="315",k1="Barbeque Paneer Pizza";
        while (i < words.length) {
            if (words[i].charAt(0) >= 'a' && words[i].charAt(0) <= 'z') {
                text.add(words[i]);

            }
            if (words[i].charAt(0) >= 'A' && words[i].charAt(0) <= 'Z') {
                text.add(words[i]);

            }
            if (words[i].matches(".*\\d.*"))
            {
                nos.add(Integer.parseInt(regex1));

            }
            i++;
        }

        for (i = 0; i < words.length; i++) {
            Log.d("ohho1", words[i]);
        }
        for (i = 0; i < text.size();i++) {
            Log.d("ohhotext", text.get(i)+"\n");
        }

        for (i = 0; i < nos.size();i++) {
            Log.d("ohhono", nos.get(i)+"\n");
        }

        i = 0;
        while (i < text.size()) {
            Log.d("ohhootyyrytry","hfhg");
            String kl = text.get(i).toString();
            Log.d("ohhoqert",kl);
            if(PlaceOrder.lol.contains(k1))
            {
                dishes.add(k1);
                Log.d("ohhoo454564","done");
                break;
            }
            i++;
        }
        i=0;
        while (i < nos.size()) {
            String regexl=nos.get(i).toString();
            if(nos.get(i)>0 && nos.get(i)<500)
            {
                price.add(Integer.parseInt(regex1));
            }
            i++;
        }
        Log.d("ohhoo454564","sfdsd");
        for (i = 0; i < dishes.size(); i++) {
            Log.d("ohho", dishes.get(i));
        }

        for (i = 0; i < price.size(); i++) {
            Log.d("ohho98797", price.get(i).toString());
        }

        Intent intent =new Intent(Separate.this, Details.class);
        intent.putExtra("OrdData", dishes);
        intent.putExtra("PerData", price);
        startActivity(intent);
    }



}
