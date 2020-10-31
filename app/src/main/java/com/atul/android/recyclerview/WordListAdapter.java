package com.atul.android.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atul.android.recyclerview.databinding.WordlistItemBinding;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;
    private Context context;

    public WordListAdapter(Context context,LinkedList<String> mWordList) {
        this.mWordList = mWordList;
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordlistItemBinding b = WordlistItemBinding.inflate(
                LayoutInflater.from(context)
                , parent
                , false
        );
        return new WordViewHolder(b,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String word = mWordList.get(position);
        holder.b.word.setText(word);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

       WordListAdapter adapter;
       WordlistItemBinding b;

        public WordViewHolder(@NonNull WordlistItemBinding b, WordListAdapter adapter) {
            super(b.getRoot());
            this.adapter = adapter;
            this.b = b;
            b.word.setOnClickListener(this);
        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            int count = 0;
            count++;

            String element = mWordList.get(mPosition);
            mWordList.set(mPosition, "Clicked " + element);

            adapter.notifyItemChanged(mPosition);
        }
    }
}
