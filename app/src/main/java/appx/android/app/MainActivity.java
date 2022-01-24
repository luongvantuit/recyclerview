package appx.android.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MakeRecyclerView makeRecyclerView = findViewById(R.id.m_make_recyclerview);
        List<Integer> items= new ArrayList<>();
        items.add(10);
        items.add(11);
        items.add(12);
        makeRecyclerView.setItems(items);
    }
}