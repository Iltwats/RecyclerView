package com.atul.android.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.atul.android.recyclerview.databinding.ActivityMainBinding;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;
    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        for (int i = 1; i <=20; i++) {
            mWordList.addLast("Word " + i);
        }

        mRecyclerView = b.recyclerView;
        mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        setupFAB();

    }

    private void setupFAB() {
        b.floatingActionButton.setOnClickListener(view -> {
            //Create new word
            String newWord = "+ Word" + mWordList.size();

            //Add the word to list
            mWordList.add(newWord);

            //Notify adapter
            mAdapter.notifyItemInserted(mWordList.size() - 1);

            //Scroll to bottom
            b.recyclerView.smoothScrollToPosition(mWordList.size() - 1);
        });
    }


}