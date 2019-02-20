package com.example.galig.petit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class HomePage extends Activity {

    private static final String TAG2 = HomePage.class.getName();
    private static final String KEY_VALUE2 = TAG2 +" .extra.value " ;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        textView=findViewById(R.id.it);

        String name=getIntent().getStringExtra(KEY_VALUE2);
        textView.setText(name);

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.MENU1) {

            Intent intent0 = new Intent(HomePage.this, HomePage.class);
            startActivity(intent0);
        }
        if (itemId == R.id.MENU2) {
            Intent intent1 = new Intent(HomePage.this, Profilo.class);
            startActivity(intent1);
        }
        if (itemId == R.id.MENU3) {
            Intent intent2 = new Intent(HomePage.this, Registrazione.class);
            startActivity(intent2);
        }
        if (itemId == R.id.MENU4) {
            Intent intent2 = new Intent(HomePage.this, MainActivity.class);
            startActivity(intent2);
        }
        if (itemId == R.id.MENU5) {
            Intent intent2 = new Intent(HomePage.this, MainActivity.class);
            startActivity(intent2);
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent getInstanceIntent(Context context, String value){
        Intent intent= new Intent(context,HomePage.class);
        intent.putExtra(KEY_VALUE2, "value");
        context.startActivity(intent);
        return intent;
    }
}