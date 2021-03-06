package com.example.recylerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<ModalClass> modalClassList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);


        recyclerView=findViewById(R.id.recyler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);


        modalClassList = new ArrayList<>();
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","default",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","default","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("default","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));
        modalClassList.add(new ModalClass("https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg","Avinash Kumar Singh","Chennai","1 day ago","Nice bro , Well Done","https://upload.wikimedia.org/wikipedia/commons/1/16/HDRI_Sample_Scene_Balls_%28JPEG-HDR%29.jpg",52,10));

        adapter = new Adapter(MainActivity.this,modalClassList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(MainActivity.this);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        ModalClass clickedItem = modalClassList.get(position);
        Toast.makeText(MainActivity.this,""+clickedItem.getProfileUrl(),Toast.LENGTH_SHORT).show();
    }
}
