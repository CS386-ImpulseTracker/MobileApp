package com.example.impulse_tracker;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.impulse_tracker.ui.main.SectionsPagerAdapter;

import org.w3c.dom.Text;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class MainActivity extends AppCompatActivity {

    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.frag1_layout);

        Button b = (Button)     findViewById(R.id.EditB);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,Pop.class));
            }

        });

        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    public void addItem(View view) {
        // Do something in response to button click
        TableLayout table = findViewById(R.id.itemTable);
        TableRow tr = new TableRow(this);
        tr.setId(count);
        count +=1;

        TextView dateText=(TextView)findViewById(R.id.dateText);
        TextView costText=(TextView)findViewById(R.id.costText);
        TextView descText=(TextView)findViewById(R.id.descText);
        TextView storeText=(TextView)findViewById(R.id.storeText);TextView col1 = new TextView(this);
        formatCell(dateText, col1);
        TextView col2 = new TextView(this);
        formatCell(costText, col2);
        TextView col3 = new TextView(this);
        formatCell(descText, col3);
        TextView col4 = new TextView(this);
        formatCell(storeText, col4);

        tr.setLayoutParams(new TableRow.LayoutParams(MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        tr.addView(col1);
        tr.addView(col2);
        tr.addView(col3);
        tr.addView(col4);

        table.addView(tr);


    }

    public void pop(View view)
    {
        startActivity(new Intent(MainActivity.this,Pop.class));

    }

    public void DelLast(View view)
    {
        TableLayout table = findViewById(R.id.itemTable);
        table.removeViewAt(count);
        count -=1;
    }

    public void delItem(View view) {
        TableLayout table = findViewById(R.id.itemTable);
        //TableRow tr = findViewById(view.getId());
        table.removeView(view);
    }




    @RequiresApi(api = Build.VERSION_CODES.M)
    private void formatCell(TextView cellText, TextView col) {
        col.setText(cellText.getText());
        col.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL), Typeface.BOLD);
        col.setGravity(Gravity.CENTER);
        col.setBackgroundColor(Color.WHITE);
        col.setHeight(60);
        col.setTextAppearance(android.R.style.TextAppearance_Large);
        //col.setOnClickListener(this.delItem(?));
    }
}