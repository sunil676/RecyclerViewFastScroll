package com.sunil.recyclerviewfastscroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private String[] names = Constant.name;
    private  String[] images = Constant.image;

    private RecyclerItemAdapter mAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

    }
    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<ItemModel> listItems = getList();
        mAdapter = new RecyclerItemAdapter(this, listItems);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

    }

    private List<ItemModel> getList(){
        List<ItemModel> list = new ArrayList<>();
        for (int index =0; index < names.length; index++){
            ItemModel itemModel = new ItemModel();
            itemModel.setName(names[index]);
            itemModel.setImagePath(images[index]);
            list.add(itemModel);
        }

        if (list.size() > 0) {
            Collections.sort(list, new Comparator<ItemModel>() {
                @Override
                public int compare(final ItemModel object1, final ItemModel object2) {
                    return object1.getName().compareTo(object2.getName());
                }
            });
        }
        return list;
    }
}
